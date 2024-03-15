 package task1;

import task1.data.DataLoader;
import java.util.Scanner;

public class ProgrammeManager {
    public void start(){
        DataLoader loadFile = DataLoader.getLoaderInstance();
        loadFile.readLines();
        for(int i = 0; i<loadFile.getYearObj().size();i++){
            System.out.println((loadFile.getYearObj().get(i)).getYear());
        }
        LoadMenu menu = LoadMenu.getLoaderInstance();
        menu.mainMenu();
        Scanner scanner = new Scanner(System.in);
        int choice = -1;
        while(choice != 0){
            try{
                System.out.println("Enter choice > ");
                choice = Integer.parseInt(scanner.nextLine());
                if(!menu.processChoice(choice)){
                    System.out.println("Invalid choice. Please enter a valid option.");
                }
            } catch (NumberFormatException e){
                System.out.println("Invalid input. Please enter a number.(No spaces or special characters");
            }
        }
        scanner.close();
    }
}
