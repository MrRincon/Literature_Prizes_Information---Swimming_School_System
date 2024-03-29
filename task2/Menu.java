//Student ID: M00774667
package task2;

//Import any essential packages to use in this class

public class Menu {

    private static Menu instance;

    //Private constructor to disallow creation of other object instances of LoadMenu outside of this class 
    private Menu() {
    }

    //Returns a new LoadMenu if one does not exist, or the previously created object if it does exist
    public static Menu getLoaderInstance() {
        if (instance != null) {
            return instance;
        } else {
            instance = new Menu();
            return instance;
        }
    }

    //Method to print the menu
    public void mainMenu() {
        System.out.printf("%-40s%n", "==========================================");
        System.out.printf("|%-40s|%n", " The Swim School Administration System  ");
        System.out.printf("%-40s%n", "==========================================");
        System.out.printf("|%-40s|%n", "                 Menu                   ");
        System.out.printf("%-40s%n", "------------------------------------------");
        System.out.printf("|%-40s|%n", "View swim student information..........1");
        System.out.printf("|%-40s|%n", "View swim lesson details...............2");
        System.out.printf("|%-40s|%n", "View instructor schedule...............3");
        System.out.printf("|%-40s|%n", "Add new swim student...................4");
        System.out.printf("|%-40s|%n", "Award swim qualification...............5");
        System.out.printf("|%-40s|%n", "Move swim student from waiting list....6");
        System.out.printf("|%-40s|%n", "Exit...................................0");
        System.out.printf("%-40s%n", "==========================================");
    }
}
