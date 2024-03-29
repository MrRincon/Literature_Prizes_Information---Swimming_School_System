package task2.data;

import java.time.LocalDate;
import java.util.ArrayList;
import task2.Enums.DOWEnum;
import task2.Enums.LEnum;
import task2.Enums.STEnum;
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

    public void createDummy() {
        DOWEnum[] dow = {DOWEnum.MONDAY, DOWEnum.WEDNESDAY, DOWEnum.FRIDAY};
        STEnum[] startTimes = {STEnum.T1700, STEnum.T1730, STEnum.T1800, STEnum.T1830, STEnum.T1900, STEnum.T1930};
        LEnum[] levels = {LEnum.NOVICE, LEnum.IMPROVER, LEnum.ADVANCE};
        LocalDate currentd = LocalDate.now();
        LocalDate endWeekOfDate = LocalDate.of(2024, 12, 23);
        while (currentd.isBefore(endWeekOfDate) || currentd.isEqual(endWeekOfDate)) {
            for (DOWEnum dowI : dow) {
                for (STEnum stI : startTimes) {
                    for (LEnum lI : levels) {
                        SwimLesson sl = new SwimLesson(dowI, stI, lI, currentd);
                        allLessons.add(sl);
                    }
                }
            }
            currentd = currentd.plusDays(1); // Move to the next day
        }
    }

    public ArrayList<SwimLesson> getLessons() {
        return this.allLessons;
    }

}
