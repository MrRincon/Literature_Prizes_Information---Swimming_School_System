//Student ID: M00774667
package task2;

import task2.Enums.DAEnum;


public class DistanceSwim extends Qualification {
    private DAEnum distanceAchieved;

    public DistanceSwim(Instructor i, DAEnum da) {
        super(i);
        this.distanceAchieved = da;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(distanceAchieved.toString());
        sb.append(" "+this.instructor.getName());
        return sb.toString();
    }
    
    
}
