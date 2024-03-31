//Student ID: M00774667
package task2;

import java.util.ArrayList;
import java.util.Random;
import task2.Enums.DAEnum;
import task2.Enums.LEnum;

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
        if(ss.getLevel() == LEnum.NOVICE){
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
        } else if(ss.getLevel() == LEnum.IMPROVER){
            int x = 0;
            switch (x){
                case 0:
                    DistanceSwim ds = new DistanceSwim(this, DAEnum.selectRandomNovice());
                    ss.addDistanceSwim(ds);
                    x++;
                case 1: 
                    DistanceSwim ds1 = new DistanceSwim(this, DAEnum.selectRandomImprover());
                    ss.addDistanceSwim(ds1);
                    x=0;
                    break;
            }
        }
        System.out.println(ss);
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
