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

    //Method to handle missing swim distances within the student level
    public ArrayList<DAEnum> showMissingSD(SwimStudent ss) {
        ArrayList<DAEnum> missingQ = new ArrayList<>();
        switch (ss.getLevel()) {
            case NOVICE:
                DAEnum[] noviceD = {DAEnum.M5, DAEnum.M10, DAEnum.M20};
                missingQ.addAll(findMissing(noviceD, ss));
                break;
            case IMPROVER:
                DAEnum[] improverD = {DAEnum.M100, DAEnum.M200, DAEnum.M400};
                missingQ.addAll(findMissing(improverD, ss));
                break;
            case ADVANCE:
                DAEnum[] advanceD = {DAEnum.M800, DAEnum.M1500, DAEnum.M3000};
                missingQ.addAll(findMissing(advanceD, ss));
                break;
        }
        return missingQ;
    }
    
    //Method to find the missing swim distance qualifications not yet achieved by the student
    private ArrayList<DAEnum> findMissing(DAEnum[] availableD, SwimStudent ss) {
        ArrayList<DAEnum> missingQ = new ArrayList<>();
        for (DAEnum distance : availableD) {
            boolean achieved = false;
            for (DistanceSwim achievement : ss.getAchievements()) {
                if (achievement.getDistance().equals(distance)) {
                    achieved = true;
                    break;
                }
            }
            if (!achieved) {
                missingQ.add(distance);
            }
        }
        return missingQ;
    }
    
    //Overload method to find the missing personal survival qualifications not yet achieved by the student
    public ArrayList<PSEnum> findMissing(PSEnum[] availablePS, SwimStudent ss) {
        ArrayList<PSEnum> missingQ = new ArrayList<>();
        if (ss.getPsQualification() != null) {
            switch (ss.getPsQualification().getPsQualification()) {
                case BRONZE:
                    missingQ.add(PSEnum.SILVER);
                    missingQ.add(PSEnum.GOLD);
                    break;
                case SILVER:
                    missingQ.add(PSEnum.GOLD);
                    break;
                case GOLD:
                    break;
            }
        } else {
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
                    case 1:
                        break;
                    case 2:
                        DistanceSwim ds = new DistanceSwim(this, DAEnum.selectRandomNovice());
                        ss.addDistanceSwim(ds);
                        break;
                }
                break;
            case IMPROVER:
                switch (x) {
                    case 0:
                        DistanceSwim ds = new DistanceSwim(this, DAEnum.M20);
                        ss.addDistanceSwim(ds);
                        x++;
                    case 1:
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
                    case 1:
                        DistanceSwim ds1 = new DistanceSwim(this, DAEnum.M400);
                        ss.addDistanceSwim(ds1);
                        x++;
                    case 2:
                        DistanceSwim ds2 = new DistanceSwim(this, DAEnum.selectRandomAdvance());
                        ss.addDistanceSwim(ds2);
                        break;
                }
                Random randy = new Random();
                int y = randy.nextInt(2);
                switch (y) {
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

    //Method to grant swim qualifications based on an specific distance
    public boolean grantQualification(SwimStudent ss, DAEnum sd) {
        boolean lookForNextLesson = true;
        DistanceSwim ds = new DistanceSwim(this, sd);
        switch (ss.getLevel()) {
            case NOVICE:
                if (sd == DAEnum.M20) {
                    ss.addDistanceSwim(ds);
                    ss.setLevel(LEnum.IMPROVER);
                    ss.setWaitingList(true);
                    lookForNextLesson = false;
                } else {
                    ss.addDistanceSwim(ds);
                }
                break;
            case IMPROVER:
                if (sd == DAEnum.M400) {
                    ss.addDistanceSwim(ds);
                    ss.setLevel(LEnum.ADVANCE);
                    ss.setWaitingList(true);
                    lookForNextLesson = false;
                } else {
                    ss.addDistanceSwim(ds);
                }
                break;
            case ADVANCE:
                ss.addDistanceSwim(ds);
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
        schedule.forEach(lesson -> {
            if (lesson.getDate().isAfter(currentDate.minusDays(1))
                    && lesson.getDate().isBefore(currentDate.plusDays(7))) {
                sb.append(lesson);
            }
        });
        return sb.toString();
    }

}
