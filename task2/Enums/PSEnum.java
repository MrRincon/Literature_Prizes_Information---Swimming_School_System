//Student ID: M00774667
package task2.Enums;

//Import any essential packages to use in this enum
import java.util.Random;

//Enum representing the PersonalSurvival qualifications
public enum PSEnum {
    BRONZE,
    SILVER,
    GOLD;
    
    //Method to return a random qualification from the enum, for the dummy data
    public static PSEnum selectRandom(){
        Random r = new Random();
        int i = r.nextInt(PSEnum.values().length);
        return PSEnum.values()[i];
    }
}
