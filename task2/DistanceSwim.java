//Student ID: M00774667
package task2;

import task2.Enums.DAEnum;


public class DistanceSwim extends Qualification {
    private DAEnum distanceAchieved;
    private Instructor instructor;

    public DistanceSwim(Instructor i, DAEnum da) {
        this.instructor = i;
        this.distanceAchieved = da;
    }
    public DAEnum getDistance(){
        return this.distanceAchieved;
    }
    
    @Override
    public Instructor getInstructor() {
        return this.instructor;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.distanceAchieved+" "+this.instructor.getName());
        return sb.toString();
    }

    
    
    
}
