//Student ID: M00774667
package task2;

//Import any essential packages to use in this class
//import java.util.LinkedList;

import java.util.ArrayList;
import task2.Enums.DAEnum;
import task2.Enums.LEnum;
import task2.data.LoadStudent;

public class WaitingList {
    
    private static WaitingList instance;
    private final ArrayList<SwimStudent> waitingStudents;
    
    private WaitingList(){
        this.waitingStudents = new ArrayList<>();
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
                this.waitingStudents.add(student);
            }
        });
    }
    public ArrayList<SwimStudent> getWS() {
        ArrayList<SwimStudent> newNovSS = new ArrayList<>();
        ArrayList<SwimStudent> noviceSS = new ArrayList<>();
        ArrayList<SwimStudent> newImpSS = new ArrayList<>();
        ArrayList<SwimStudent> improverSS = new ArrayList<>();
        ArrayList<SwimStudent> newAdvSS = new ArrayList<>();
        ArrayList<SwimStudent> advanceSS = new ArrayList<>();
        waitingStudents.forEach(student->{
            if(student.getLevel()==LEnum.NOVICE && student.getAchievements().isEmpty()){
                newNovSS.add(student);
            } else if (student.getLevel()==LEnum.NOVICE){
                noviceSS.add(student);
            } else if (student.getLevel()==LEnum.IMPROVER){
                boolean hasVal = false;
                for(DistanceSwim ds : student.getAchievements()){
                    if(ds.getDistance()==DAEnum.M100 || ds.getDistance()==DAEnum.M200){
                        hasVal = true;
                        improverSS.add(student);
                        break;
                    }
                }
                if (!hasVal){
                    newImpSS.add(student);
                } 
            } else if(student.getLevel()==LEnum.ADVANCE){
                boolean hasVal = false;
                for(DistanceSwim ds : student.getAchievements()){
                    if(ds.getDistance()==DAEnum.M800 || ds.getDistance()==DAEnum.M1500 ||ds.getDistance()==DAEnum.M3000){
                        hasVal = true;
                        advanceSS.add(student);
                        break;
                    }
                }
                if(!hasVal){
                    newAdvSS.add(student);
                }
            }
        });
        waitingStudents.clear();
        waitingStudents.addAll(newNovSS);
        waitingStudents.addAll(noviceSS);
        waitingStudents.addAll(newImpSS);
        waitingStudents.addAll(improverSS);
        waitingStudents.addAll(newAdvSS);
        waitingStudents.addAll(advanceSS);
        return waitingStudents;
    }

    public void addToWL(SwimStudent ss) {
        this.waitingStudents.add(ss);
    }
    public void removeFromWL(SwimStudent ss){
        waitingStudents.remove(ss);
    }
}
