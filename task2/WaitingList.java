//Student ID: M00774667
package task2;

//Import any essential packages to use in this class
import java.util.ArrayList;
import task2.Enums.DAEnum;
import task2.Enums.LEnum;
import task2.data.LoadStudent;

public class WaitingList {
    
    private static WaitingList instance;//Static variable referring to the single created instance of WaitingList
    private final ArrayList<SwimStudent> waitingStudents;
    
    //Private constructor to disallow creation of other object instances of WaitingList outside of this class
    private WaitingList(){
        this.waitingStudents = new ArrayList<>();
    }
    
    //Returns a new WaitingList if one does not exist or the previously created object if it does exist
    public static WaitingList getLoaderInstance() {
        if (instance != null) {
            return instance;
        } else {
            instance = new WaitingList();
            return instance;
        }
    }
    
    //Add dummy data of the students to the waitinglist 
    public void addDummy(LoadStudent students){
        //Add only the students marked as waiting list students
        students.getStudents().forEach((SwimStudent student) -> { 
            if(student.isWaitingList()){
                this.waitingStudents.add(student);
            }
        });
    }
    
    /*Method to return the students organised by:
    1-New novice students, 2-Novice students on wait, 3-Promoted improver students,
    4-Improver students on wait, 5-Promoted advance students, 6-Advance students on wait
    */
    public ArrayList<SwimStudent> getWS() {
        //ArrayLists of categories for waiting students
        ArrayList<SwimStudent> newNovSS = new ArrayList<>();
        ArrayList<SwimStudent> noviceSS = new ArrayList<>();
        ArrayList<SwimStudent> newImpSS = new ArrayList<>();
        ArrayList<SwimStudent> improverSS = new ArrayList<>();
        ArrayList<SwimStudent> newAdvSS = new ArrayList<>();
        ArrayList<SwimStudent> advanceSS = new ArrayList<>();
        //Each on the waiting list is added on the right category ArrayList
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
        //Clear waiting list and readd the sorted students to return the waiting list organised
        waitingStudents.clear();
        waitingStudents.addAll(newNovSS);
        waitingStudents.addAll(noviceSS);
        waitingStudents.addAll(newImpSS);
        waitingStudents.addAll(improverSS);
        waitingStudents.addAll(newAdvSS);
        waitingStudents.addAll(advanceSS);
        return waitingStudents;
    }

    //Method to add a student to the WaitingList
    public void addToWL(SwimStudent ss) {
        this.waitingStudents.add(ss);
    }
    
    //Method to remove a student from the waiting list
    public void removeFromWL(SwimStudent ss){
        waitingStudents.remove(ss);
    }
}
