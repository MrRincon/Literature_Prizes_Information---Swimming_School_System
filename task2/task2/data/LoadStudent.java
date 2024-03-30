
package task2.data;

import java.util.ArrayList;
import task2.SwimStudent;

public class LoadStudent {
    private static LoadStudent instance;
    private final ArrayList<SwimStudent> allStudents;

    private LoadStudent() {
        this.allStudents = new ArrayList<>();
    }

    public static LoadStudent getLoaderInstance() {
        if (instance != null) {
            return instance;
        } else {
            instance = new LoadStudent ();
            return instance;
        }
    }
    
    public void createDummy(){
        int x = 432;
        
        
    }
    public ArrayList<SwimStudent> getStudents(){
        return this.allStudents;
    }
}
