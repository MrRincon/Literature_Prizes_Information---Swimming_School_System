package task2.data;

import java.time.LocalDate;
import java.util.ArrayList;
import task2.Enums.DOWEnum;
import task2.Enums.LEnum;
import task2.Enums.STEnum;
import task2.Instructor;
import task2.SwimLesson;

public class LoadLesson {

    private static LoadLesson instance;
    private final ArrayList<SwimLesson> allLessons;

    private LoadLesson() {
        this.allLessons = new ArrayList<>();
    }

    public static LoadLesson getLoaderInstance() {
        if (instance != null) {
            return instance;
        } else {
            instance = new LoadLesson();
            return instance;
        }
    }

    public void createDummy(LoadInstructor instructors) {
        DOWEnum[] dow = {DOWEnum.MONDAY, DOWEnum.WEDNESDAY, DOWEnum.FRIDAY};
        LEnum[] levels = {LEnum.NOVICE, LEnum.IMPROVER, LEnum.ADVANCE};
        STEnum[] startTimes = {STEnum.T1700, STEnum.T1730, STEnum.T1800, STEnum.T1830, STEnum.T1900, STEnum.T1930};
        LocalDate currentd = LocalDate.now();
        LocalDate endWeekOfDate = currentd.plusDays(30);
        while (currentd.isBefore(endWeekOfDate) || currentd.isEqual(endWeekOfDate)) {
            for (DOWEnum dowI : dow) {
                for (LEnum lI : levels) {
                    Instructor instObj = instructors.selectRandomInstructor();
                    for (STEnum stI : startTimes) {
                        //Add the instructor to this constructor
                        SwimLesson sl = new SwimLesson(dowI, stI, lI, currentd, instObj);
                        instObj.setSchedule(sl);
                        allLessons.add(sl);
                    }
                }
            }
            currentd = currentd.plusDays(7); // Move to the next 7 days
        }
    }

    public ArrayList<SwimLesson> getLessons() {
        return this.allLessons;
    }

}
