//Student ID: M00774667
package task2.Enums;

import java.util.Random;

public enum PSEnum {
    BRONZE,
    SILVER,
    GOLD;
    
    public static PSEnum selectRandom(){
        Random r = new Random();
        int i = r.nextInt(PSEnum.values().length);
        return PSEnum.values()[i];
    }
}
