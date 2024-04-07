//Student ID: M00774667
package task2.Enums;

//Import any essential packages to use in this enum
import java.util.Random;

//Enum to represent the distances in meters
public enum DAEnum {
    M5("5 meters"),
    M10("10 meters"),
    M20("20 meters"),
    M100("100 meters"),
    M200("200 meters"),
    M400("400 meters"),
    M800("800 meters"),
    M1500("1500 meters"),
    M3000("3000 meters");

    private final String distance;//distance value

    //Constructor to initialize distance value
    DAEnum(String d) {
        this.distance = d;
    }

    //Method to get the distance value
    public String getDistance() {
        return distance;
    }

    //Methods to return random distances for dummy data depending on the level
    public static DAEnum selectRandomNovice() {
        Random r = new Random();
        int rindex = r.nextInt(3);
        switch (rindex) {
            case 0:
                return M5;
            case 1:
                return M10;
            default:
                return M20;
        }
    }

    public static DAEnum selectRandomImprover() {
        Random r = new Random();
        int rindex = r.nextInt(3);
        switch (rindex) {
            case 0:
                return M100;
            case 1:
                return M200;
            default:
                return M400;
        }
    }

    public static DAEnum selectRandomAdvance() {
        Random r = new Random();
        int rindex = r.nextInt(3);
        switch (rindex) {
            case 0:
                return M800;
            case 1:
                return M1500;
            default:
                return M3000;
        }
    }

    //Override toString method to return distance value
    @Override
    public String toString() {
        return distance;
    }
}
