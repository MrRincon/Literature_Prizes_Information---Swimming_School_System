//Student ID: M00774667
package task2;

import java.util.LinkedList;
import task2.data.LoadStudent;

public class WaitingList {
    private static WaitingList instance;
    private LinkedList<SwimStudent> waitingStudents;
    
    private WaitingList(){
        this.waitingStudents = new LinkedList<>();
    }
    
    public static WaitingList getLoaderInstance() {
        if (instance != null) {
            return instance;
        } else {
            instance = new WaitingList();
            return instance;
        }
    }
    
    public void addDummy(LoadStudent students){
        students.getStudents().forEach((SwimStudent student) -> { 
            if(student.isWaitingList()){
                this.waitingStudents.offer(student);
            }
        });
    }
    public LinkedList<SwimStudent> getWS() {
        return waitingStudents;
    }

    public void addToWL(SwimStudent ss) {
        this.waitingStudents.offer(ss);
    }
//    public SwimStudent removeFromWL(){
//        return this.waitingStudents.poll();
//    }
}
