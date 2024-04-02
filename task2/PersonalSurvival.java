//Student ID: M00774667
package task2;

import task2.Enums.PSEnum;

public class PersonalSurvival extends Qualification {
    private PSEnum psQualification;
    
    public PersonalSurvival(Instructor i, PSEnum ps) {
        super(i);
        this.psQualification = ps;
    }
    
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(psQualification + " " + this.instructor.getName());
        return sb.toString();
    }
    
}
