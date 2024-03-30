//Student ID: M00774667
package task2.Enums;

public enum DAEnum {
    M0("0 metres"),
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
}
