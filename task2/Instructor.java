//Student ID: M00774667
package task2;

import java.util.ArrayList;
import java.util.Random;
import task2.Enums.DAEnum;
import task2.Enums.PSEnum;

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
    
    public void grantQualification(){
        
    }
    public void grantQualification(SwimStudent ss){
        int x = 0;
        switch(ss.getLevel()){
            case NOVICE:
                int[] choices = {1,2};
                Random r = new Random();
                int choice = choices[r.nextInt(choices.length)];
                switch(choice){
                    case 1:
                        break;
                    case 2: 
                        DistanceSwim ds = new DistanceSwim(this, DAEnum.selectRandomNovice());
                        ss.addDistanceSwim(ds);
                        break;
                }
                break;
            case IMPROVER:
                switch (x){
                    case 0:
                        DistanceSwim ds = new DistanceSwim(this, DAEnum.M20);
                        ss.addDistanceSwim(ds);
                        x++;
                    case 1: 
                        DistanceSwim ds1 = new DistanceSwim(this, DAEnum.selectRandomImprover());
                        ss.addDistanceSwim(ds1);
                        x=0;
                        break;
                }
                break;
            case ADVANCE:
                switch(x){
                    case 0:
                        DistanceSwim ds = new DistanceSwim(this, DAEnum.M20);
                        ss.addDistanceSwim(ds);
                        x++;
                    case 1:
                        DistanceSwim ds1 = new DistanceSwim(this, DAEnum.M400);
                        ss.addDistanceSwim(ds1);
                        x++;
                    case 2:
                        DistanceSwim ds2 = new DistanceSwim(this, DAEnum.selectRandomAdvance());
                        ss.addDistanceSwim(ds2);
                        x=0;
                        break;
                }
                Random randy = new Random();
                int y = randy.nextInt(2);
                switch (y){
                    case 0:
                        break;
                    case 1: 
                        PersonalSurvival ps = new PersonalSurvival(this, PSEnum.selectRandom());
                        ss.setPsQualification(ps);
                        break;
                }
                break;
        }
    }
    

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
