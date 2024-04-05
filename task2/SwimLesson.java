//Student ID: M00774667
package task2;

//Import any essential packages to use in this class
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import task2.Enums.DOWEnum;
import task2.Enums.LEnum;
import task2.Enums.STEnum;

public class SwimLesson {
    private final DOWEnum day;
    private final STEnum start_time;
    private final LEnum level;
    private int maxStudents;
    private final ArrayList<SwimStudent> studentsInLesson;
    private final LocalDate date;
    private final Instructor instructorAssigned;
    
    //Constructor for swim lesson object
    public SwimLesson(DOWEnum dow, STEnum t, LEnum l, LocalDate d, Instructor i) {
        this.day = dow;
        this.start_time = t;
        this.level = l;
        this.maxStudents = 4;
        this.studentsInLesson =  new ArrayList<>();
        this.date = lessonDate(d, dow);
        this.instructorAssigned = i;
        
    }
    
    /*Method to calculate the date of the lesson based on the current date 
    and the day of the week passed as a parameter*/
    public final LocalDate lessonDate(LocalDate d, DOWEnum dow) {
        DayOfWeek desiredDay = DayOfWeek.valueOf(dow.name());
        DayOfWeek currentDay = d.getDayOfWeek();
        int daysToAdd = desiredDay.getValue() - currentDay.getValue();
        if (daysToAdd < 0) {
            daysToAdd += 7;
        }
        return d.plusDays(daysToAdd);
    }
    
    //Getters and setters for the attributes
    public DOWEnum getDay() {
        return day;
    }

    public STEnum getStart_time() {
        return start_time;
    }

    public LEnum getLevel() {
        return level;
    }

    public int getMaxStudents() {
        return maxStudents;
    }

    public ArrayList<SwimStudent> getStudentsInLesson() {
        return studentsInLesson;
    }

    public LocalDate getDate() {
        return date;
    }

    public Instructor getInstructorAssigned() {
        return instructorAssigned;
    }

    public void addStudentsInLesson(SwimStudent ss) {
        this.studentsInLesson.add(ss);
    }
    
    //Method for simple representation of the swim lesson
    public String toStringOptionList(){
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("| %-11s| %-10s| %-6s| %-10s|%n", date, day, start_time, level));
        return sb.toString();
    }
    
    
    //Overload method for simple representation of the swim lesson for an specific swim level
    public String toStringOptionList(LEnum lvl){
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("| %-11s| %-10s| %-6s| %-10s|%n", date, day, start_time, lvl));
        return sb.toString();
    }
    
    //toString method to represent the object with detailed information
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%-46s%n","=============================================="));
        sb.append(String.format("| %-11s| %-10s| %-6s| %-10s|%n", date, day, start_time, level));
        sb.append(String.format("%-46s%n","----------------------------------------------"));
        sb.append(String.format("| %-15s %26s |%n", "Instructor:", instructorAssigned.getName()));
        if(!studentsInLesson.isEmpty()){//Check if there are students in lesson
            sb.append(String.format("%-46s%n","----------------------------------------------"));
            sb.append(String.format("| %-25s %16s |%n", "Students for this class:", studentsInLesson.get(0).getName()));
            int maxLoop = studentsInLesson.size();
            for(int i = 1; i < maxLoop; i++){
                sb.append(String.format("| %-25s %16s |%n", "", studentsInLesson.get(i).getName()));
            }
        }
        int x = maxStudents - studentsInLesson.size();//Calculates the available space in the lesson
        sb.append(String.format("%-46s%n","----------------------------------------------"));
        sb.append(String.format("| %-43s|%n", "There is " + x + " space(s) available"));
        sb.append(String.format("%-46s%n","=============================================="));
        return sb.toString();
    }
}
