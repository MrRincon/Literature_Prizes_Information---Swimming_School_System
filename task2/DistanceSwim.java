//Student ID: M00774667
package task2;

import task2.Enums.DAEnum;


public class DistanceSwim extends Qualification {
    private DAEnum distanceAchieved;

    public DistanceSwim(Instructor i, DAEnum da) {
        super(i);
        this.distanceAchieved = da;
    }
    public DAEnum getDistance(){
        return this.distanceAchieved;
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.distanceAchieved+" "+this.instructor.getName());
        return sb.toString();
    }
    
    
}
