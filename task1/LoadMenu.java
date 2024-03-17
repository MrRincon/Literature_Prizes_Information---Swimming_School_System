package task1;

import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.ArrayList;

public class LoadMenu {
    private static LoadMenu instance;
     
    private LoadMenu(){
    }
    
    public static LoadMenu getLoaderInstance(){
        if(instance != null){
            return instance;
        } else {
            instance = new LoadMenu();
            return instance;
        }
    }
    public void mainMenu(){
        System.out.printf("%-22s%n","----------------------");
        System.out.printf("%-22s%n","Literature Prize Menu ");
        System.out.printf("%-22s%n","----------------------");
        System.out.printf("%-22s%n","List ................1");
        System.out.printf("%-22s%n","Select ..............2");
        System.out.printf("%-22s%n","Search ..............3");
        System.out.printf("%-22s%n","Exit.................0");
        System.out.printf("%-22s%n","----------------------");
    }
    public boolean processChoice(int choice, ArrayList<LiteraturePrize> allYearObjs){
        switch(choice){
            case 1:
                listPrizeWinners(allYearObjs);
                return true;
            case 2: 
                //WORKING HEREEEE
                System.out.println("Select selected");
                return true;
            case 3: 
                System.out.println("Search selected");
                return true;
            case 0: 
                System.out.println("Exiting...");
                return true;
            default:
                return false;
        }
    }
    public void listPrizeWinners(ArrayList<LiteraturePrize> allYearObjs){
        int startYear = 0;
        int endYear = 0;
        boolean validInput = false;
        Scanner inputScan = new Scanner(System.in);
        do{
            try{
                System.out.print("Enter start year > ");
                startYear = inputScan.nextInt();
                System.out.print("Enter end year > ");
                endYear = inputScan.nextInt();
                if(startYear < allYearObjs.get(0).getYear()
                        || endYear > allYearObjs.get(allYearObjs.size()-1).getYear()
                        || startYear > endYear){
                    System.out.println("Invalid year range.");
                } else{
                    System.out.printf("------------------------------------------------------------------------------\n");
                    System.out.printf("| %4s | %-68s|\n", "Year", "Prize winners (and associated nations)");
                    System.out.printf("------------------------------------------------------------------------------\n");
                    for(int year = startYear; year <= endYear; year++){
            //            System.out.printf("| %4d |", year);
                        for (LiteraturePrize prize : allYearObjs){
                            if (prize.getYear() == year){
                                String prizeWinners = prize.getPrizeWinnersString();
                                System.out.printf("| %-4d | %-68s|\n", year, prizeWinners.isEmpty() ? "NOT AWARDED" : prizeWinners);
                                break;
                            }
                        }
                    }
                    System.out.println("------------------------------------------------------------------------------");
                    validInput = true;
                }
            } catch (InputMismatchException e){
                System.out.println("Invalid input. Please enter a valid year");
                inputScan.nextLine();
            }
        } while (!validInput);
    }
}