//Student ID: M00774667
package task2;

import java.util.ArrayList;
import task2.Enums.LEnum;

public class SwimStudent {
    private String name;
    private LEnum level;
    private boolean waitingList;
    private SwimLesson upcomingLesson;
    private ArrayList<Qualification> qualifications;
    
    public SwimStudent(String name){
        this.name = name;
        this.level = null;
        this.waitingList = true;
        this.upcomingLesson = null;
        this.qualifications = null;
    }
    
}
  