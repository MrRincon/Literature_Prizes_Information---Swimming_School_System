//Student ID: M00774667
package task2;

//Import any essential packages to use in this class
import java.util.ArrayList;
import task2.Enums.LEnum;

public class SwimStudent {
    
    private String name;
    private LEnum level;
    private boolean waitingList;
    private SwimLesson upcomingLesson;
    private ArrayList<DistanceSwim> achievements;
    private PersonalSurvival psQualification;
    
    //Constructor for swim student object using name only
    public SwimStudent (String n){
        this.name = n;
        this.level = LEnum.NOVICE;
        this.waitingList = false;
        this.upcomingLesson = null;
        this.achievements = new ArrayList<>();
        this.psQualification = null;
    }
    
    //Overload constructor for swim student object using name and level
    public SwimStudent(String n, LEnum l){
        this.name = n;
        this.level = l;
        this.waitingList = false;
        this.upcomingLesson = null;
        this.achievements = new ArrayList<>();
        this.psQualification = null;
    }

    //Getters and setters for the attributes
    public String getName() {
        return name;
    }

    public LEnum getLevel() {
        return level;
    }

    public boolean isWaitingList() {
        return waitingList;
    }

    public ArrayList<DistanceSwim> getAchievements() {
        return achievements;
    }

    public PersonalSurvival getPsQualification() {
        return psQualification;
    }

    public void setLevel(LEnum level) {
        this.level = level;
    }

    public void setWaitingList(boolean waitingList) {
        this.waitingList = waitingList;
    }

    public void setUpcomingLesson(SwimLesson upcomingLesson) {
        this.upcomingLesson = upcomingLesson;
    }

    public void setPsQualification(PersonalSurvival ps) {
        this.psQualification = ps;
    }
    
    //Method to add a distance swim qualification to the achievements
    public void addDistanceSwim(DistanceSwim ds) {
        this.achievements.add(ds);
    }

    //toString method to represent the object with detailed information
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%-35s%n","==================================="));
        sb.append(String.format("| %-16s %-15s|%n", name, level));
        if(upcomingLesson==null){//Check if the student has no upcoming lesson
            if(achievements.isEmpty()){//Check if the student has no qualifications
                sb.append(String.format("| %-32s|%n", "This is a new student"));
            }
            sb.append(String.format("| %-32s|%n", "Student is on waiting list"));
            sb.append(String.format("%-35s%n","==================================="));
        } else { //If there is an upcoming lesson, add it to the StringBuilder 
            sb.append(String.format("| %-11s %-12s %-7s|%n", upcomingLesson.getDay(), upcomingLesson.getDate(), upcomingLesson.getStart_time()));
            sb.append(String.format("| %-32s|%n", upcomingLesson.getInstructorAssigned().getName()));
            sb.append(String.format("%-35s%n","==================================="));
        }
        if(!achievements.isEmpty()){//Check if the student has any achievements
            achievements.forEach(achievement -> {//Display each achievement
                sb.append(String.format("| %-32s|%n", achievement));
            });
            sb.append(String.format("%-35s%n","==================================="));
        }
        if(psQualification != null){//Check if the student has achieved a personal survival medal
            sb.append(String.format("| %-32s|%n", psQualification));
            sb.append(String.format("%-35s%n","==================================="));
        }
        return sb.toString();
    }
}
  