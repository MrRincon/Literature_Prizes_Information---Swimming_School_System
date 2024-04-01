//Student ID: M00774667
package task2;

abstract class Qualification {
    public Instructor instructor;
    
    Qualification(Instructor i){
        this.instructor = i;
    }
    public Instructor getInstructor(){
        return this.instructor;
    }
}
