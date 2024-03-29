//Student ID: M00774667
package task2;

import java.util.LinkedList;

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

    public LinkedList<SwimStudent> getWS() {
        return waitingStudents;
    }

    public void addToWL(SwimStudent ws) {
        this.waitingStudents.offer(ws);
    }
    public SwimStudent removeFromWL(){
        return this.waitingStudents.poll();
    }
}
