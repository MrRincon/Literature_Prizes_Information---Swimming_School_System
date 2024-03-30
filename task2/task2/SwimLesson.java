//Student ID: M00774667
package task2;

import java.time.DayOfWeek;
import java.time.LocalDate;
import task2.Enums.DOWEnum;
import task2.Enums.LEnum;
import task2.Enums.STEnum;

public class SwimLesson {

    private DOWEnum day;
    private STEnum start_time;
    private LEnum level;
    private int maxStudents;
    private LocalDate date;
    private Instructor instructorAssigned;

    public SwimLesson(DOWEnum dow, STEnum t, LEnum l, LocalDate d, Instructor i) {
        this.day = dow;
        this.start_time = t;
        this.level = l;
        this.maxStudents = 4;
        this.date = lessonDate(d, dow);
        this.instructorAssigned = i;
        
    }

    public LocalDate lessonDate(LocalDate d, DOWEnum dow) {
        DayOfWeek desiredDay = DayOfWeek.valueOf(dow.name());
        DayOfWeek currentDay = d.getDayOfWeek();
        int daysToAdd = desiredDay.getValue() - currentDay.getValue();
        if (daysToAdd < 0) {
            daysToAdd += 7;
        }
        return d.plusDays(daysToAdd);
    }

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

    public LocalDate getDate() {
        return date;
    }

    public void setMaxStudents(int maxStudents) {
        this.maxStudents = maxStudents;
    }
    public void setInstructor(){
        
    }
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("| %-10s| %-11s| %-6s| %-10s| %-2d| %-20s|%n", day, date, start_time, level, maxStudents, instructorAssigned.getName()));
        return sb.toString();
    }
}
