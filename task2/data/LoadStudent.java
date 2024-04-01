//Student ID: M00774667
package task2.data;

import java.util.ArrayList;
import task2.Enums.LEnum;
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
    
    public void createDummy(LoadInstructor instructors){
        int x = 400;
        for(int i = 0; i < x; i++){
//            working here
            SwimStudent ss = new SwimStudent(("Student"+(i+1)), LEnum.randomLevel());
            instructors.selectRandomInstructor().grantQualification(ss);
            this.allStudents.add(ss);
        }
        
    }
    public ArrayList<SwimStudent> getStudents(){
        return this.allStudents;
    }
}
