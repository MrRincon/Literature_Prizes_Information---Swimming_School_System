//Student ID: M00774667
package task2;

//Import any essential packages to use in this class
import task2.Enums.DAEnum;

//Class defined as a child of the Qualification abstract class
public class DistanceSwim extends Qualification {
    private final DAEnum distanceAchieved;
    private final Instructor instructor;

    //Constructor for the distance swim object
    public DistanceSwim(Instructor i, DAEnum da) {
        this.instructor = i;
        this.distanceAchieved = da;
    }
    
    //Getter method for the distance swim qualification 
    public DAEnum getDistance(){
        return this.distanceAchieved;
    }
    
    //Getter method from the abstract class to get the instructor
    @Override
    public Instructor getInstructor() {
        return this.instructor;
    }
    
    //toString method to represent the object
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.distanceAchieved+" "+this.instructor.getName());
        return sb.toString();
    }
}
