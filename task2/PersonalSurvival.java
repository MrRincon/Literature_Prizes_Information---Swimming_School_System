//Student ID: M00774667
package task2;

//Import any essential packages to use in this class
import task2.Enums.PSEnum;

//Class defined as a child of the Qualification abstract class
public class PersonalSurvival extends Qualification {
    private final PSEnum psQualification;
    private final Instructor instructor;

    //Constructor for the personal survival object
    public PersonalSurvival(Instructor i, PSEnum ps) {
        this.instructor = i;
        this.psQualification = ps;
    }

    //Getter method for the personal survival qualification
    public PSEnum getPsQualification() {
        return psQualification;
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
        sb.append(psQualification + " " + instructor.getName());
        return sb.toString();
    }
}
