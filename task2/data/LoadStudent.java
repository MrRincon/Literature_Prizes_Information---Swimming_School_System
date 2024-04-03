//Student ID: M00774667
package task2.data;

//Import any essential packages to use in this class
import java.util.ArrayList;
import task2.Enums.LEnum;
import task2.SwimLesson;
//Import SwimStudent class to create the objects
import task2.SwimStudent;

public class LoadStudent {

    private static LoadStudent instance;//Static variable referring to the single created instance of LoadStudent
    private final ArrayList<SwimStudent> allStudents;

    //Private constructor to disallow creation of other object instances of LoadStudent outside of this class
    private LoadStudent() {
        this.allStudents = new ArrayList<>();
    }

    //Returns a new LoadStudent if one does not exist or the previously created object if it does exist
    public static LoadStudent getLoaderInstance() {
        if (instance != null) {
            return instance;
        } else {
            instance = new LoadStudent();
            return instance;
        }
    }

    //Method to create SwimStudent objects for dummy data
    public void createDummy(LoadInstructor instructors, LoadLesson lessons) {
        int x = 400;//Create x amount of students
        for (int i = 0; i < x; i++) {
            //Create SwimStudent with random level
            SwimStudent ss = new SwimStudent(("Student" + (i + 1)), LEnum.randomLevel());
            //Select a random instructor and grant a qualification to the student
            instructors.selectRandomInstructor().grantQualification(ss);
            switch (ss.getLevel()) {//Switch depending on the level of the SwimStudent
                case NOVICE:
                    if (!ss.getAchievements().isEmpty()) {//Check for achievements
                        switch (ss.getAchievements().get(0).getDistance()) {
                            case M20:
                                ss.setLevel(LEnum.IMPROVER);//Increase the level of the student when achieving 20 meters
                                ss.setWaitingList(true);//Then add to waiting list
                                break;
                            default:
                                //Find the next lesson for the student level
                                SwimLesson nextAvailable = findNextAvailable(lessons.getLessons(), ss.getLevel());
                                if (nextAvailable != null) {
                                    //Set the student upcoming lesson and add the student to the lesson
                                    ss.setUpcomingLesson(nextAvailable);
                                    nextAvailable.addStudentsInLesson(ss);
                                } else {
                                    //if no available lesson, add SwimStudent to the waiting list
                                    ss.setWaitingList(true);
                                }
                                break;
                        }
                    } else {
                        //if novice SwimStudent is empty, add them to the waiting list as these are new students
                        ss.setWaitingList(true);
                    }
                    break;
                case IMPROVER:
                    switch (ss.getAchievements().get(1).getDistance()) {
                        case M400:
                            ss.setLevel(LEnum.ADVANCE);
                            ss.setWaitingList(true);
                            break;
                        default:
                            SwimLesson nextAvailable = findNextAvailable(lessons.getLessons(), ss.getLevel());
                            if (nextAvailable != null) {
                                ss.setUpcomingLesson(nextAvailable);
                                nextAvailable.addStudentsInLesson(ss);
                            } else {
                                ss.setWaitingList(true);
                            }
                            break;
                    }
                    break;
                case ADVANCE:
                    //For advance, just add them to the next lesson available, if any
                    SwimLesson nextAvailable = findNextAvailable(lessons.getLessons(), ss.getLevel());
                    if (nextAvailable != null) {
                        ss.setUpcomingLesson(nextAvailable);
                        nextAvailable.addStudentsInLesson(ss);
                    } else {
                        ss.setWaitingList(true);
                    }
                    break;
            }
            this.allStudents.add(ss);//add all the SwimStudents to an ArrayList
        }

    }

    //Method to find the next available lesson
    private SwimLesson findNextAvailable(ArrayList<SwimLesson> lessons, LEnum studentLevel) {
        for (SwimLesson lesson : lessons) {
            //Check if the lesson matches with the student level and that it is not full with other students
            if (lesson.getLevel() == studentLevel && lesson.getStudentsInLesson().size() < lesson.getMaxStudents()) {
                return lesson;
            }
        }
        return null;
    }

    //Method to return all the SwimStudent objects
    public ArrayList<SwimStudent> getStudents() {
        return this.allStudents;
    }
}
