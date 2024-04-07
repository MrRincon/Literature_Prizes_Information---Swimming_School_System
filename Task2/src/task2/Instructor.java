//Student ID: M00774667
package task2;

//Import any essential packages to use in this class
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;
import task2.Enums.DAEnum;
import task2.Enums.LEnum;
import task2.Enums.PSEnum;

public class Instructor {

    private final String name;
    private final ArrayList<SwimLesson> schedule;

    //Constructor for swim instructor object
    public Instructor(String name) {
        this.name = name;
        this.schedule = new ArrayList<>();
    }

    //Getters and setters for some of the attributes
    public String getName() {
        return name;
    }

    public void setSchedule(SwimLesson lesson) {
        this.schedule.add(lesson);
    }

    //Method to return the missing swim distances within the student level
    public ArrayList<DAEnum> showMissingSD(SwimStudent ss) {
        ArrayList<DAEnum> missingQ = new ArrayList<>();
        switch (ss.getLevel()) {
            case NOVICE://Define novice qualification distances and find missing ones
                DAEnum[] noviceD = {DAEnum.M5, DAEnum.M10, DAEnum.M20};
                missingQ.addAll(findMissing(noviceD, ss));
                break;
            case IMPROVER://Define improver qualification distances and find missing ones
                DAEnum[] improverD = {DAEnum.M100, DAEnum.M200, DAEnum.M400};
                missingQ.addAll(findMissing(improverD, ss));
                break;
            case ADVANCE://Define advance qualification distances and find missing ones
                DAEnum[] advanceD = {DAEnum.M800, DAEnum.M1500, DAEnum.M3000};
                missingQ.addAll(findMissing(advanceD, ss));
                break;
        }
        return missingQ;
    }
    
    //Method to find and return the missing swim distance qualifications not yet achieved by the student
    private ArrayList<DAEnum> findMissing(DAEnum[] availableD, SwimStudent ss) {
        ArrayList<DAEnum> missingQ = new ArrayList<>();
        //Loop through the available distances
        for (DAEnum distance : availableD) {
            boolean achieved = false;
            //Check if the student has achieved any of the distances
            for (DistanceSwim achievement : ss.getAchievements()) {
                if (achievement.getDistance().equals(distance)) {
                    achieved = true;
                    break;
                }
            }
            if (!achieved) {//if not achieved, add it to the missing qualifications ArrayList
                missingQ.add(distance);
            }
        }
        return missingQ;
    }
    
    //Overload method to find and return the missing personal survival qualifications not yet achieved by the student
    public ArrayList<PSEnum> findMissing(PSEnum[] availablePS, SwimStudent ss) {
        ArrayList<PSEnum> missingQ = new ArrayList<>();
        if (ss.getPsQualification() != null) {//Check if the student has any personal survival qualification
            switch (ss.getPsQualification().getPsQualification()) {
                case BRONZE:
                    missingQ.add(PSEnum.SILVER);
                    missingQ.add(PSEnum.GOLD);
                    break;
                case SILVER:
                    missingQ.add(PSEnum.GOLD);
                    break;
                case GOLD:
                    //If gold, no personal survival qualification can be achieved
                    break;
            }
        } else {//If student has no qualifications achieved, return all the qualifications the student could be granted
            missingQ.add(PSEnum.BRONZE);
            missingQ.add(PSEnum.SILVER);
            missingQ.add(PSEnum.GOLD);
        }
        return missingQ;
    }

    //Method to grant swim qualifications (for dummy data)
    public void grantQualification(SwimStudent ss) {
        int x = 0;
        switch (ss.getLevel()) {
            case NOVICE:
                int[] choices = {1, 2};
                Random r = new Random();
                int choice = choices[r.nextInt(choices.length)];
                switch (choice) {
                    case 1://Student will be a new student
                        break;
                    case 2://Grant a random novice distance swim qualification
                        DistanceSwim ds = new DistanceSwim(this, DAEnum.selectRandomNovice());
                        ss.addDistanceSwim(ds);
                        break;
                }
                break;
            case IMPROVER:
                switch (x) {
                    case 0://Grant the student a distance swim worth to be promoted to improver
                        DistanceSwim ds = new DistanceSwim(this, DAEnum.M20);
                        ss.addDistanceSwim(ds);
                        x++;
                    case 1://Grant a random improver distance swim qualification
                        DistanceSwim ds1 = new DistanceSwim(this, DAEnum.selectRandomImprover());
                        ss.addDistanceSwim(ds1);
                        break;
                }
                break;
            case ADVANCE:
                switch (x) {
                    case 0:
                        DistanceSwim ds = new DistanceSwim(this, DAEnum.M20);
                        ss.addDistanceSwim(ds);
                        x++;
                    case 1://Grant the student a distance swim worth to be promoted to advance
                        DistanceSwim ds1 = new DistanceSwim(this, DAEnum.M400);
                        ss.addDistanceSwim(ds1);
                        x++;
                    case 2://Grant a random advance distance swim qualification
                        DistanceSwim ds2 = new DistanceSwim(this, DAEnum.selectRandomAdvance());
                        ss.addDistanceSwim(ds2);
                        break;
                }
                //Randomly grant a personal survival qualification for an advance level student
                Random randy = new Random();
                int y = randy.nextInt(2);
                switch (y) {
                    case 0://Do nothing
                        break;
                    case 1://Grant a random personal survival qualification
                        PersonalSurvival ps = new PersonalSurvival(this, PSEnum.selectRandom());
                        ss.setPsQualification(ps);
                        break;
                }
                break;
        }
    }

    //Overload method to grant swim qualifications based on an specific distance
    public boolean grantQualification(SwimStudent ss, DAEnum sd) {
        boolean lookForNextLesson = true;
        DistanceSwim ds = new DistanceSwim(this, sd);
        //Grant a qualification according to the student level and distance provided within that level
        switch (ss.getLevel()) {
            case NOVICE:
                if (sd == DAEnum.M20) {//If distance is 20m
                    ss.addDistanceSwim(ds);//Add distance
                    ss.setLevel(LEnum.IMPROVER);//Promote student to improver
                    ss.setWaitingList(true);//Confirm the student is on waiting list
                    lookForNextLesson = false;//Do not look for next lesson for the student
                } else {//if not, grant distance
                    ss.addDistanceSwim(ds);
                }
                break;
            case IMPROVER:
                if (sd == DAEnum.M400) {//If distance is 400m
                    ss.addDistanceSwim(ds);//Add distance 
                    ss.setLevel(LEnum.ADVANCE);//Promote student to advance 
                    ss.setWaitingList(true);//Confirm the student is on waiting list
                    lookForNextLesson = false;//Do not look for next lesson for the student
                } else {//if not, grant distance
                    ss.addDistanceSwim(ds);
                }
                break;
            case ADVANCE:
                ss.addDistanceSwim(ds);//Grant distance only
                break;
        }
        return lookForNextLesson;
    }

    //toString method to represent the object with detailed information
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%-46s%n", "=============================================="));
        sb.append(String.format("|| %-41s||%n", name));
        LocalDate currentDate = LocalDate.now();
        //Use the current date and loop through all the lessons
        schedule.forEach(lesson -> {
            //Append to StringBuilder only the lessons of the next 7 days 
            if (lesson.getDate().isAfter(currentDate.minusDays(1))
                    && lesson.getDate().isBefore(currentDate.plusDays(7))) {
                sb.append(lesson);
            }
        });
        return sb.toString();
    }

}
