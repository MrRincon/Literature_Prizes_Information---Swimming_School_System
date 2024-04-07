//Student ID: M00774667
package task2.Enums;

//Import any essential packages to use in this enum
import java.util.Random;

//Enum to represent the levels that can be achieved by a SwimStudent
public enum LEnum {
    NOVICE,
    IMPROVER,
    ADVANCE;

    //Method to return a random level from the enum, for the dummy data
    public static LEnum randomLevel() {
        Random random = new Random();
        int index = random.nextInt(values().length);
        return values()[index];
    }
}
