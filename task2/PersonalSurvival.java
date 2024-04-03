//Student ID: M00774667
package task2;

import task2.Enums.PSEnum;

public class PersonalSurvival extends Qualification {
    private PSEnum psQualification;
    private Instructor instructor;
    
    public PersonalSurvival(Instructor i, PSEnum ps) {
        this.instructor = i;
        this.psQualification = ps;
    }

    public PSEnum getPsQualification() {
        return psQualification;
    }
    
    @Override
    public Instructor getInstructor() {
        return this.instructor;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(psQualification + " " + instructor.getName());
        return sb.toString();
    }

    
    
}
