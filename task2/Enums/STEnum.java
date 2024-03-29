//Student ID: M00774667
package task2.Enums;

public enum STEnum {
    T1700("17:00"),
    T1730("17:30"),
    T1800("18:00"),
    T1830("18:30"),
    T1900("19:00"),
    T1930("19:30");

    private final String startTime;

    STEnum(String t) {
        this.startTime = t;
    }

    public String toString() {
        return startTime;
    }
}
