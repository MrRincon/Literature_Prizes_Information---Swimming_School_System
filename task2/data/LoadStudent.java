//Student ID: M00774667
package task2.data;

import java.util.ArrayList;
import task2.Enums.LEnum;
import task2.SwimLesson;
import task2.SwimStudent;

public class LoadStudent {
    private static LoadStudent instance;
    private final ArrayList<SwimStudent> allStudents;
    private final ArrayList<SwimStudent> recentlySelected;

    private LoadStudent() {
        this.allStudents = new ArrayList<>();
        this.recentlySelected = new ArrayList<>();
    }

    public static LoadStudent getLoaderInstance() {
        if (instance != null) {
            return instance;
        } else {
            instance = new LoadStudent ();
            return instance;
        }
    }
    
    public void createDummy(LoadInstructor instructors, LoadLesson lessons){
        int x = 400;
        for(int i = 0; i < x; i++){
            SwimStudent ss = new SwimStudent(("Student"+(i+1)), LEnum.randomLevel());
            instructors.selectRandomInstructor().grantQualification(ss);
            switch (ss.getLevel()){
                case NOVICE:
                    if(!ss.getAchievements().isEmpty()){
                        switch (ss.getAchievements().get(0).getDistance()){
                            case M20:
                                ss.setLevel(LEnum.IMPROVER);
                                ss.setWaitingList(true);
                                break;
                            default:
                                SwimLesson nextAvailable = findNextAvailable(lessons, ss.getLevel());
                                if(nextAvailable != null){
                                    ss.setUpcomingLesson(nextAvailable);
                                    nextAvailable.addStudentsInLesson(ss);
                                } else{
                                    ss.setWaitingList(true);
                                }
                                break;
                        }
                    } else{
                        ss.setWaitingList(true);
                    }
                    break;
                case IMPROVER:
                    switch(ss.getAchievements().get(1).getDistance()){
                        case M400:
                            ss.setLevel(LEnum.ADVANCE);
                            ss.setWaitingList(true);
                            break;
                        default:
                            SwimLesson nextAvailable = findNextAvailable(lessons, ss.getLevel());
                            if(nextAvailable != null){
                                ss.setUpcomingLesson(nextAvailable);
                                nextAvailable.addStudentsInLesson(ss);
                            } else{
                                ss.setWaitingList(true);
                            }
                            break;
                    }
                    break;
                case ADVANCE: 
                    SwimLesson nextAvailable = findNextAvailable(lessons, ss.getLevel());
                    if(nextAvailable != null){
                        ss.setUpcomingLesson(nextAvailable);
                        nextAvailable.addStudentsInLesson(ss);
                    } else{
                        ss.setWaitingList(true);
                    }
                    break;
                
            }
            this.allStudents.add(ss);
        }
        
    }
    
    private SwimLesson findNextAvailable(LoadLesson lessons, LEnum studentLevel){
        for(SwimLesson lesson : lessons.getLessons()){
            if (lesson.getLevel() == studentLevel && lesson.getStudentsInLesson().size() < lesson.getMaxStudents()){
                return lesson;
            }
        }
        return null;
    } 
    public ArrayList<SwimStudent> getStudents(){
        return this.allStudents;
    }
}
