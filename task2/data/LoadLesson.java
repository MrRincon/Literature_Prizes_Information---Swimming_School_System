//Student ID: M00774667
package task2.data;

//Import any essential packages to use in this class
import java.time.LocalDate;
import java.util.ArrayList;
import task2.Enums.DOWEnum;
import task2.Enums.LEnum;
import task2.Enums.STEnum;
import task2.Instructor;
//Import SwimLesson class to create the objects
import task2.SwimLesson;

public class LoadLesson {

    private static LoadLesson instance;//Static variable referring to the single created instance of LoadLesson
    private final ArrayList<SwimLesson> allLessons;

    //Private constructor to disallow creation of other object instances of LoadLesson outside of this class
    private LoadLesson() {
        this.allLessons = new ArrayList<>();
    }

    //Returns a new LoadLesson if one does not exist or the previously created object if it does exist
    public static LoadLesson getLoaderInstance() {
        if (instance != null) {
            return instance;
        } else {
            instance = new LoadLesson();
            return instance;
        }
    }

    //Method to create SwimLesson objects for dummy data
    public void createDummy(LoadInstructor instructors) {
        DOWEnum[] dow = {DOWEnum.MONDAY, DOWEnum.WEDNESDAY, DOWEnum.FRIDAY};
        LEnum[] levels = {LEnum.NOVICE, LEnum.IMPROVER, LEnum.ADVANCE};
        STEnum[] startTimes = {STEnum.T1700, STEnum.T1730, STEnum.T1800, STEnum.T1830, STEnum.T1900, STEnum.T1930};
        LocalDate currentd = LocalDate.now();//Get current date
        LocalDate endWeekOfDate = currentd.plusDays(30);//Add all the days for the weeks that are in the next 30 days

        //Loop for the days of the week, levels and start times to create the lessons
        while (currentd.isBefore(endWeekOfDate) || currentd.isEqual(endWeekOfDate)) {
            for (DOWEnum dowI : dow) {
                for (LEnum lI : levels) {
                    //Select random Instructor to assign to the lesson of the day for an specific level
                    Instructor instObj = instructors.selectRandomInstructor();
                    for (STEnum stI : startTimes) {
                        //Create a SwimLesson and add swim lesson to the Instructor schedule 
                        SwimLesson sl = new SwimLesson(dowI, stI, lI, currentd, instObj);
                        instObj.setSchedule(sl);
                        allLessons.add(sl);//Add SwimLesson object to an ArrayList
                    }
                }
            }
            currentd = currentd.plusDays(7); // Move to the next 7 days
        }
    }

    //Method to return all the SwimLesson objects
    public ArrayList<SwimLesson> getLessons() {
        return this.allLessons;
    }
}
