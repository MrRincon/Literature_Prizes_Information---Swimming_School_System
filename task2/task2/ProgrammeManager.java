   //Student ID: M00774667
package task2;

import java.util.Scanner;
import task2.data.LoadInstructor;
import task2.data.LoadLesson;
import task2.data.LoadStudent;

public class ProgrammeManager {

    public void start() {
        WaitingList wl = WaitingList.getLoaderInstance();
        LoadInstructor instructorD = LoadInstructor.getLoaderInstance();
        instructorD.createDummy();
        LoadLesson lessonD = LoadLesson.getLoaderInstance();
        lessonD.createDummy(instructorD);
        LoadStudent studentD = LoadStudent.getLoaderInstance();
        studentD.createDummy();
        lessonD.getLessons().forEach(lesson -> {
            System.out.print(lesson);
        });
        instructorD.getInstructors().forEach(instructor -> {
            System.out.print(instructor);  
        });
        
        

        Menu menu = Menu.getLoaderInstance();
        menu.mainMenu();
        Scanner scanner = new Scanner(System.in);
        int choice = -1;
        while (choice != 0) {
            try {
                System.out.print("Enter choice > ");//Input choice for main menu
                choice = Integer.parseInt(scanner.nextLine());
                //If the menu choice is false print error message
                if (!processChoice(choice)) {
                    System.out.println("Invalid choice. Please enter a valid option.");
                } else {
                    System.out.println(choice);
                    switch (choice) {
                        case 1:
//                          menu.whateverfunction
                        case 2:
//                          
                        case 3:
//                          
                        case 4:
//                            
                        case 5:
//                            
                        case 6:
//                            
                    }
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.(No spaces or special characters)");
            }
            menu.mainMenu();
        }
        scanner.close();
    }

    public boolean processChoice(int choice) {
        switch (choice) {
            case 1:
                return true;
            case 2:
                return true;
            case 3:
                return true;
            case 4:
                return true;
            case 5:
                return true;
            case 6:
                return true;
            case 0:
                System.out.println("Exiting...");
                System.exit(0);
            default:
                return false;
        }
    }
}
