//Student ID: M00774667
package task2.Enums;

import java.util.Random;

public enum DAEnum {
    M5("5 metres"),
    M10("10 metres"),
    M20("20 metres"),
    M100("100 metres"),
    M200("200 metres"),
    M400("400 metres"),
    M800("800 metres"),
    M1500("1500 metres"),
    M3000("3000 metres");

    private final String distance;

    DAEnum(String d) {
        this.distance = d;
    }

    public String getDistance() {
        return distance;
    }
    public static DAEnum selectRandomNovice(){
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
    public static DAEnum selectRandomImprover(){
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
    public static DAEnum selectRandomAdvance (){
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
    public String toString() {
        return distance;
    }
    
}
