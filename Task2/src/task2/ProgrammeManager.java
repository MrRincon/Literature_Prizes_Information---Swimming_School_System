//Student ID: M00774667
package task2;

//Import any essential packages to use in this class
import java.util.Scanner;
import task2.data.LoadInstructor;
import task2.data.LoadLesson;
import task2.data.LoadStudent;

public class ProgrammeManager {

    //Method to start the program and manage user interaction
    public void start() {
        //Initialize data loaders
        WaitingList waitingLD = WaitingList.getLoaderInstance();
        LoadInstructor instructorD = LoadInstructor.getLoaderInstance();
        LoadLesson lessonD = LoadLesson.getLoaderInstance();
        LoadStudent studentD = LoadStudent.getLoaderInstance();
        //Create dummy data for instructors, lessons, students, and waiting list
        instructorD.createDummy();
        lessonD.createDummy(instructorD);
        studentD.createDummy(instructorD, lessonD);
        waitingLD.addDummy(studentD);
        //Initialize the main menu
        Menu menu = Menu.getLoaderInstance();
        menu.mainMenu();
        //User interaction loop
        Scanner scanner = new Scanner(System.in);
        int choice = -1;
        while (choice != 0) {
            try {
                //Prompt user input for menu choice
                System.out.print("Enter choice > ");
                choice = Integer.parseInt(scanner.nextLine());
                //If the menu choice is false print error message
                if (!menu.processChoice(choice, instructorD.getInstructors(), lessonD.getLessons(), studentD.getStudents(), waitingLD)) {
                    System.out.println("Invalid choice. Please enter a valid option.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.(No spaces or special characters)");
            }
            //Display main menu again after processing the choice
            menu.mainMenu();
        }
        //Close the scanner
        scanner.close();
    }
}
