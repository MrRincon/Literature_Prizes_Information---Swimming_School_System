//Student ID: M00774667
package task2;

//Import any essential packages to use in this class
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;
import java.util.TreeSet;
import task2.Enums.DAEnum;
import task2.Enums.LEnum;
import task2.Enums.PSEnum;

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
        System.out.printf("%-40s%n", "------------------------------------------");
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

    public boolean processChoice(int choice, ArrayList<Instructor> instructors, ArrayList<SwimLesson> lessons, ArrayList<SwimStudent> students, WaitingList wl) {
        switch (choice) {
            case 1:
                swimStudentInfo(students);
                return true;
            case 2:
                swimLessonDeets(lessons);
                return true;
            case 3:
                instructorSchedule(instructors);
                return true;
            case 4:
                addNewSS(students, lessons, wl);
                return true;
            case 5:
                awardSQ(instructors, students, lessons, wl);
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

    private void swimStudentInfo(ArrayList<SwimStudent> ss) {
        Scanner sc = new Scanner(System.in);
        int selectedSSIndex = -1;
        boolean validInput = false;
        int x = 1;
        TreeSet<SwimStudent> sortedSS = new TreeSet<>(Comparator.comparing(SwimStudent::getName));
        sortedSS.addAll(ss);
        ArrayList<SwimStudent> sortedSSList = new ArrayList<>(sortedSS);
        System.out.printf("%-34s%n", "==================================");
        System.out.printf("%-7s| %-12s| %-10s|%n", "", "Name", "Level");
        System.out.printf("%-34s%n", "----------------------------------");
        for (SwimStudent student : sortedSSList) {
            System.out.printf("%-4d...| %-12s| %-10s|%n", x, student.getName(), student.getLevel());
            x++;
        }
        System.out.printf("%-34s%n", "==================================");
        do {
            System.out.print("Input a number to see the student information > ");
            try {
                String input = sc.nextLine();
                selectedSSIndex = Integer.parseInt(input.trim());
                if (selectedSSIndex > 0 && selectedSSIndex <= sortedSSList.size()) {
                    System.out.print(sortedSSList.get(selectedSSIndex - 1));
                    validInput = true;
                } else {
                    System.out.println("Please select a value from the available range.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter an existent student.");
            }
        } while (!validInput);
    }

    private void swimLessonDeets(ArrayList<SwimLesson> sl) {
        Scanner sc = new Scanner(System.in);
        int selectedSLIndex = -1;
        boolean validInput = false;
        int x = 1;
        TreeSet<SwimLesson> sortedSL = new TreeSet<>(Comparator.comparing(SwimLesson::toStringOptionList));
        sortedSL.addAll(sl);
        ArrayList<SwimLesson> sortedSLList = new ArrayList<>(sortedSL);
        System.out.printf("%-58s%n", "=====================================================");
        System.out.printf("%-7s| %-11s| %-10s| %-6s| %-10s|%n", "", "Date", "Day", "Time", "Level");
        System.out.printf("%-58s%n", "-----------------------------------------------------");
        for (SwimLesson lesson : sortedSLList) {
            System.out.printf("%-4d...| %-11s| %-10s| %-6s| %-10s|%n", x, lesson.getDate(), lesson.getDay(), lesson.getStart_time(), lesson.getLevel());
            x++;
        }
        System.out.printf("%-58s%n", "=====================================================");
        do {
            System.out.print("Input a number to see the lesson details > ");
            try {
                String input = sc.nextLine();
                selectedSLIndex = Integer.parseInt(input.trim());
                if (selectedSLIndex > 0 && selectedSLIndex <= sortedSLList.size()) {
                    System.out.print(sortedSLList.get(selectedSLIndex - 1));
                    validInput = true;
                } else {
                    System.out.println("Please select a value from the available range.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter an existent lesson.");
            }
        } while (!validInput);
    }

    private void instructorSchedule(ArrayList<Instructor> si) {
        Scanner sc = new Scanner(System.in);
        int selectedSIIndex = -1;
        boolean validInput = false;
        int x = 1;
        TreeSet<Instructor> sortedSI = new TreeSet<>(Comparator.comparing(Instructor::getName));
        sortedSI.addAll(si);
        ArrayList<Instructor> sortedSIList = new ArrayList<>(sortedSI);
        System.out.printf("%-30s%n", "==============================");
        System.out.printf("%-7s| %-20s|%n", "", "Instructor name");
        System.out.printf("%-30s%n", "------------------------------");
        for (Instructor instructor : sortedSIList) {
            System.out.printf("%-4d...| %-20s|%n", x, instructor.getName());
            x++;
        }
        System.out.printf("%-30s%n", "==============================");
        do {
            System.out.print("Input a number to see the lesson details > ");
            try {
                String input = sc.nextLine();
                selectedSIIndex = Integer.parseInt(input.trim());
                if (selectedSIIndex > 0 && selectedSIIndex <= sortedSIList.size()) {
                    System.out.print(sortedSIList.get(selectedSIIndex - 1));
                    validInput = true;
                } else {
                    System.out.println("Please select a value from the available range.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter an existent lesson.");
            }
        } while (!validInput);
    }

    private void addNewSS(ArrayList<SwimStudent> ss, ArrayList<SwimLesson> sl, WaitingList wl) {
        Scanner sc = new Scanner(System.in);
        String newName = "";
        boolean validName = false;
        do {
            System.out.print("Enter the new student's name > ");
            try {
                newName = sc.nextLine();
                if (newName.matches("[a-zA-Z]+")) {
                    validName = true;
                } else {
                    System.out.println("Please enter an actual name");
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Try again your name input");
            }
        } while (!validName);
        SwimStudent newss = new SwimStudent(newName);
        TreeSet<SwimLesson> sortedSL = new TreeSet<>(Comparator.comparing(lesson -> lesson.toStringOptionList(LEnum.NOVICE)));
        sortedSL.addAll(sl);
        ArrayList<SwimLesson> sortedSLList = new ArrayList<>(sortedSL);
        int x = 1;
        for (SwimLesson lesson : sortedSLList) {
            System.out.printf("%-46s%n", "^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
            System.out.printf("%-4d...%n", x);
            System.out.print(lesson);
            x++;
        }
        System.out.printf("%-46s%n", "^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
        int lsSelectedIndex = 0;
        do {
            System.out.print("Insert the number of the lesson that the student would like to attend > ");
            try {
                lsSelectedIndex = Integer.parseInt(sc.nextLine().trim());
                lsSelectedIndex++;
                if (lsSelectedIndex >= 1 && lsSelectedIndex <= x) {
                    System.out.print(sortedSLList.get(lsSelectedIndex));
                    if (sortedSLList.get(lsSelectedIndex).getStudentsInLesson().size() == 4) {
                        System.out.println("Sorry, but this lesson is full.");
                        String yORn = "";
                        do {
                            System.out.print("Would the student like to select another lesson? (Y/N) > ");
                            yORn = sc.nextLine().trim().toUpperCase();
                            if (yORn.equals("Y")) {
                                lsSelectedIndex = 0;
                            } else if (yORn.equals("N")) {
                                wl.addToWL(newss);
                                newss.setWaitingList(true);
                                System.out.println("Student is now added to waiting list.");
                            } else {
                                System.out.println("Invalid input. Please enter 'Y' for yes or 'N' for no.");
                            }
                        } while (!yORn.equals("Y") && !yORn.equals("N"));
                    } else {
                        sortedSLList.get(lsSelectedIndex).addStudentsInLesson(newss);
                        newss.setUpcomingLesson(sortedSLList.get(lsSelectedIndex));
                        System.out.println("Student is now booked for this lesson.");
                    }
                } else {
                    System.out.println("Please enter a number within the valid range");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number");
            }
        } while (lsSelectedIndex < 1 || lsSelectedIndex > x);
        ss.add(newss);
    }

    private void awardSQ(ArrayList<Instructor> si, ArrayList<SwimStudent> ss, ArrayList<SwimLesson> sl, WaitingList wl) {
        Scanner sc = new Scanner(System.in);
        int selectedSIIndex = -1;
        boolean validInput = false;
        int x = 1;
        TreeSet<Instructor> sortedSI = new TreeSet<>(Comparator.comparing(Instructor::getName));
        sortedSI.addAll(si);
        ArrayList<Instructor> sortedSIList = new ArrayList<>(sortedSI);
        Instructor chosenSI = null;
        System.out.printf("%-30s%n", "==============================");
        System.out.printf("%-7s| %-20s|%n", "", "Instructor name");
        System.out.printf("%-30s%n", "------------------------------");
        for (Instructor instructor : sortedSIList) {
            System.out.printf("%-4d...| %-20s|%n", x, instructor.getName());
            x++;
        }
        System.out.printf("%-30s%n", "==============================");
        do {
            System.out.print("Input a number to select an instructor > ");
            try {
                String input = sc.nextLine();
                selectedSIIndex = Integer.parseInt(input.trim());
                if (selectedSIIndex > 0 && selectedSIIndex <= sortedSIList.size()) {
                    chosenSI = sortedSIList.get(selectedSIIndex - 1);
                    validInput = true;
                } else {
                    System.out.println("Please select a value from the available range.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number to select the instructor");
            }
        } while (!validInput);
        //
        int selectedSSIndex = -1;
        validInput = false;
        x = 1;
        TreeSet<SwimStudent> sortedSS = new TreeSet<>(Comparator.comparing(SwimStudent::getName));
        sortedSS.addAll(ss);
        ArrayList<SwimStudent> sortedSSList = new ArrayList<>();
        sortedSS.forEach(student -> {
            if (!student.isWaitingList()) {
                sortedSSList.add(student);
            }
        });
        SwimStudent chosenSS = null;
        System.out.printf("%-34s%n", "==================================");
        System.out.printf("%-7s| %-12s| %-10s|%n", "", "Name", "Level");
        System.out.printf("%-34s%n", "----------------------------------");
        for (SwimStudent student : sortedSSList) {
            System.out.printf("%-4d...| %-12s| %-10s|%n", x, student.getName(), student.getLevel());
            x++;
        }
        System.out.printf("%-34s%n", "==================================");
        do {
            System.out.print("Input a number to select the student > ");
            try {
                String input = sc.nextLine();
                selectedSSIndex = Integer.parseInt(input.trim());
                if (selectedSSIndex > 0 && selectedSSIndex <= sortedSSList.size()) {
                    chosenSS = sortedSSList.get(selectedSSIndex - 1);
                    validInput = true;
                } else {
                    System.out.println("Please select a value from the available range.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter an existent student.");
            }
        } while (!validInput);
        //
        if (chosenSS.getLevel() == LEnum.ADVANCE) {
            String dsORps = "";
            do {
                System.out.print("Is the awarded qualification for Distance Swim or Personal Survival? (DS/PS) > ");
                dsORps = sc.nextLine().trim().toUpperCase();
                if (dsORps.equals("DS")) {
                    chooseDistance(chosenSI, chosenSS, sl, wl);
                } else if (dsORps.equals("PS")) {
                    choosePersonalSurvival(chosenSI, chosenSS, sl, wl);
                } else {
                    System.out.println("Invalid input. Please enter 'DS' for Distance Swim or 'PS' for Personal Survival.");
                }
            } while (!dsORps.equals("DS") && !dsORps.equals("PS"));
        } else {
            chooseDistance(chosenSI, chosenSS, sl, wl);
        }
    }

    private void chooseDistance(Instructor chosenSI, SwimStudent chosenSS, ArrayList<SwimLesson> sl, WaitingList wl) {
        Scanner sc = new Scanner(System.in);
        int selectedSDIndex = -1;
        boolean validInput = false;
        int x = 1;
        DAEnum chosenDA = null;
        System.out.printf("%-29s%n", "=============================");
        System.out.printf("%-7s| %-19s|%n", "", "Distances to Award");
        System.out.printf("%-29s%n", "-----------------------------");
        if (!chosenSI.showMissingSD(chosenSS).isEmpty()) {
            for (DAEnum distance : chosenSI.showMissingSD(chosenSS)) {
                System.out.printf("%-4d...| %-19s|%n", x, distance);
                x++;
            }
            System.out.printf("%-29s%n", "=============================");
            do {
                System.out.print("Select the award to be granted > ");
                try {
                    String input = sc.nextLine();
                    selectedSDIndex = Integer.parseInt(input.trim());
                    if (selectedSDIndex > 0 && selectedSDIndex <= chosenSI.showMissingSD(chosenSS).size()) {
                        chosenDA = chosenSI.showMissingSD(chosenSS).get(selectedSDIndex - 1);
                        validInput = true;
                    } else {
                        System.out.println("Please select a value from the available range.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter an available distance to award.");
                }
            } while (!validInput);
            if (chosenSI.grantQualification(chosenSS, chosenDA)) {
                SwimLesson lessonFound = null;
                for (SwimLesson lesson : sl) {
                    //Check if the lesson matches with the student level and that it is not full with other students
                    if (lesson.getLevel() == chosenSS.getLevel() && lesson.getStudentsInLesson().size() < lesson.getMaxStudents()) {
                        lessonFound = lesson;
                    }
                }
                if (lessonFound != null){
                    lessonFound.addStudentsInLesson(chosenSS);
                    chosenSS.setUpcomingLesson(lessonFound);
                    System.out.println("The next lesson for " + chosenSS.getName() + " will be: ");
                    System.out.printf("%-58s%n", "=====================================================");      
                    System.out.print(lessonFound.toStringOptionList());
                } else {
                    chosenSS.setWaitingList(true);
                    wl.addToWL(chosenSS);
                    System.out.println("There is no available lessons at the moment for this level. Swim student will be place on the waiting list.");
                }
            } else {
                chosenSS.setWaitingList(true);
                wl.addToWL(chosenSS);
                System.out.println("The swim level of the student has increased to " + chosenSS.getLevel()
                        + ".\nStudent is now on the waiting list.");
            }
        } else {
            System.out.printf("| %-26s|%n", "No more awards to give");
            System.out.printf("%-29s%n", "=============================");
        }
    }
    
    private void choosePersonalSurvival(Instructor chosenSI, SwimStudent chosenSS, ArrayList<SwimLesson> sl, WaitingList wl){
        Scanner sc = new Scanner(System.in);
        PSEnum[] psQ = {PSEnum.BRONZE,PSEnum.SILVER,PSEnum.GOLD};
        ArrayList<PSEnum> missingPSQ = new ArrayList<>(chosenSI.findMissing(psQ, chosenSS));
        int selectedSDIndex = -1;
        boolean validInput = false;
        int x = 1;
        PSEnum chosenPS = null;
        System.out.printf("%-29s%n", "=============================");
        System.out.printf("%-7s| %-24s|%n", "", "Survival medal to Award");
        System.out.printf("%-29s%n", "-----------------------------");
        if(!missingPSQ.isEmpty()){
            //WORKING HERE
        } else {
            System.out.printf("| %-26s|%n", "No more survival medals to give");
            System.out.printf("%-29s%n", "=============================");
        }
    }
}
