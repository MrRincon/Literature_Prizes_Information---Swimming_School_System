//Student ID: M00774667
package task2;

import java.util.Scanner;
import task2.data.LoadInstructor;
import task2.data.LoadLesson;
import task2.data.LoadStudent;

public class ProgrammeManager {

    public void start() {
        WaitingList waitingLD = WaitingList.getLoaderInstance();
        LoadInstructor instructorD = LoadInstructor.getLoaderInstance();
        LoadLesson lessonD = LoadLesson.getLoaderInstance();
        LoadStudent studentD = LoadStudent.getLoaderInstance();
        instructorD.createDummy();
        lessonD.createDummy(instructorD);
        studentD.createDummy(instructorD, lessonD);
        waitingLD.addDummy(studentD);
        Menu menu = Menu.getLoaderInstance();
        menu.mainMenu();
        Scanner scanner = new Scanner(System.in);
        int choice = -1;
        while (choice != 0) {
            try {
                System.out.print("Enter choice > ");//Input choice for main menu
                choice = Integer.parseInt(scanner.nextLine());
                //If the menu choice is false print error message
                if (!menu.processChoice(choice, instructorD.getInstructors(), lessonD.getLessons(), studentD.getStudents(), waitingLD)) {
                    System.out.println("Invalid choice. Please enter a valid option.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.(No spaces or special characters)");
            }
            menu.mainMenu();
        }
        scanner.close();
    }
}
