//Student ID: M00774667
package task2;

import java.util.ArrayList;
import task2.Enums.LEnum;

public class SwimStudent {
    private String name;
    private LEnum level;
    private boolean waitingList;
    private SwimLesson upcomingLesson;
    private ArrayList<DistanceSwim> achievements;
    private PersonalSurvival psQualification;
    
    public SwimStudent(String n, LEnum l){
        this.name = n;
        this.level = l;
        this.waitingList = true;
        this.upcomingLesson = null;
        this.achievements = new ArrayList<>();
        this.psQualification = null;
    }

    public String getName() {
        return name;
    }

    public LEnum getLevel() {
        return level;
    }

    public boolean isWaitingList() {
        return waitingList;
    }

    public SwimLesson getUpcomingLesson() {
        return upcomingLesson;
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

    public void addDistanceSwim(DistanceSwim ds) {
        this.achievements.add(ds);
    }

    public void setPsQualification(PersonalSurvival ps) {
        this.psQualification = ps;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("| %-12s| %-10s| %-5s| %-10s| %-30s| %-90s|", name, level, waitingList, upcomingLesson, psQualification, achievements));
        return sb.toString();
    }
    
}
  