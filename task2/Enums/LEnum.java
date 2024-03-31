//Student ID: M00774667
package task2.Enums;

import java.util.Random;

public enum LEnum {
    NOVICE,
    IMPROVER,
    ADVANCE;
    
    public static LEnum randomLevel(){
        Random random = new Random();
        int index = random.nextInt(values().length);
        return values()[index];
    }
}
