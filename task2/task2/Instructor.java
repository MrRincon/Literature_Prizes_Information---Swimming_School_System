//Student ID: M00774667
package task2;

import java.util.ArrayList;

public class Instructor {

    private String name;
    private ArrayList<SwimLesson> schedule;

    public Instructor(String name) {
        this.name = name;
        this.schedule = new ArrayList<>();
    }

    public String getName() {
        return name;
    }
    
    public void setSchedule(SwimLesson lesson) {
        this.schedule.add(lesson);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("| %5s | ", name));
        for(SwimLesson lesson : schedule){
            sb.append(String.format("%4s %4s,", lesson.getDay(), lesson.getDate()));
        }
        sb.append(" |\n");
        return sb.toString();
    }
    
}
