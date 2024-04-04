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
    
    //Method to process the user's choice
    public boolean processChoice(int choice, ArrayList<Instructor> instructors, ArrayList<SwimLesson> lessons, ArrayList<SwimStudent> students, WaitingList wl) {
        switch (choice) {
            case 1://Display information about the swimming students
                swimStudentInfo(students);
                return true;
            case 2://Display details of the swimming lessons
                swimLessonDeets(lessons);
                return true;
            case 3://Display the upcoming seven days of the instructor's schedule
                instructorSchedule(instructors);
                return true;
            case 4://Add a new swim student
                addNewSS(students, lessons, wl);
                return true;
            case 5://Award a swim qualification
                awardSQ(instructors, students, lessons, wl);
                return true;
            case 6://Move swim student from the waiting list
                return true;
            case 0://Exit the program
                System.out.println("Exiting...");
                System.exit(0);
            default://Default for invalid choice
                return false;
        }
    }
    
    //Method to display information about swimming students
    private void swimStudentInfo(ArrayList<SwimStudent> ss) {
        Scanner sc = new Scanner(System.in);
        int selectedSSIndex;
        boolean validInput = false;
        int x = 1;
        //Swimming students list sorted alphabetically by name
        TreeSet<SwimStudent> sortedSS = new TreeSet<>(Comparator.comparing(SwimStudent::getName));
        sortedSS.addAll(ss);
        ArrayList<SwimStudent> sortedSSList = new ArrayList<>(sortedSS);
        //Header for students basic information
        System.out.printf("%-34s%n", "==================================");
        System.out.printf("%-7s| %-12s| %-10s|%n", "", "Name", "Level");
        System.out.printf("%-34s%n", "----------------------------------");
        //Display all the students basic information with an index
        for (SwimStudent student : sortedSSList) {
            System.out.printf("%-4d...| %-12s| %-10s|%n", x, student.getName(), student.getLevel());
            x++;
        }
        System.out.printf("%-34s%n", "==================================");
        do {
            //Prompt user input to select a student using the index
            System.out.print("Input the student's index for more information > ");
            try {
                String input = sc.nextLine();
                selectedSSIndex = Integer.parseInt(input.trim());
                //Check if input is within range
                if (selectedSSIndex > 0 && selectedSSIndex <= sortedSSList.size()) {
                    //Display all the information of the student
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

    //Method to display information about swimming lessons
    private void swimLessonDeets(ArrayList<SwimLesson> sl) {
        Scanner sc = new Scanner(System.in);
        int selectedSLIndex;
        boolean validInput = false;
        int x = 1;
        //Swimming lessons list sorted by a string pattern
        TreeSet<SwimLesson> sortedSL = new TreeSet<>(Comparator.comparing(SwimLesson::toStringOptionList));
        sortedSL.addAll(sl);
        ArrayList<SwimLesson> sortedSLList = new ArrayList<>(sortedSL);
        //Header for lessons basic information
        System.out.printf("%-58s%n", "=====================================================");
        System.out.printf("%-7s| %-11s| %-10s| %-6s| %-10s|%n", "", "Date", "Day", "Time", "Level");
        System.out.printf("%-58s%n", "-----------------------------------------------------");
        //Display all the lessons basic information with an index
        for (SwimLesson lesson : sortedSLList) {
            System.out.printf("%-4d...| %-11s| %-10s| %-6s| %-10s|%n", x, lesson.getDate(), lesson.getDay(), lesson.getStart_time(), lesson.getLevel());
            x++;
        }
        System.out.printf("%-58s%n", "=====================================================");
        do {
            //Prompt user input to select a lesson using the index
            System.out.print("Input the lesson's index for more details > ");
            try {
                String input = sc.nextLine();
                selectedSLIndex = Integer.parseInt(input.trim());
                //Check if input is within range
                if (selectedSLIndex > 0 && selectedSLIndex <= sortedSLList.size()) {
                    //Display all the information of the lesson
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

    //Method to display information about swimming instructors
    private void instructorSchedule(ArrayList<Instructor> si) {
        Scanner sc = new Scanner(System.in);
        int selectedSIIndex;
        boolean validInput = false;
        int x = 1;
        //Swimming instructor list sorted alphabetically by name
        TreeSet<Instructor> sortedSI = new TreeSet<>(Comparator.comparing(Instructor::getName));
        sortedSI.addAll(si);
        ArrayList<Instructor> sortedSIList = new ArrayList<>(sortedSI);
        //Header for instructors basic information
        System.out.printf("%-30s%n", "==============================");
        System.out.printf("%-7s| %-20s|%n", "", "Instructor name");
        System.out.printf("%-30s%n", "------------------------------");
        //Display all the instructors basic information with an index
        for (Instructor instructor : sortedSIList) {
            System.out.printf("%-4d...| %-20s|%n", x, instructor.getName());
            x++;
        }
        System.out.printf("%-30s%n", "==============================");
        do {
            //Prompt user input to select an instructor using the index
            System.out.print("Input the instructor's index for more scheduled lessons details > ");
            try {
                String input = sc.nextLine();
                selectedSIIndex = Integer.parseInt(input.trim());
                //Check if input is within range
                if (selectedSIIndex > 0 && selectedSIIndex <= sortedSIList.size()) {
                    //Display all the information of the instructor's lessons scheduled for the next 7 days
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
                if (lsSelectedIndex >= 1 && lsSelectedIndex <= x) {
                    if (sortedSLList.get(lsSelectedIndex - 1).getStudentsInLesson().size() == 4) {
                        System.out.println("Sorry, but this lesson is full.");
                        String yORn;
                        do {
                            System.out.print("Would the student like to select another lesson? (Y/N) > ");
                            yORn = sc.nextLine().trim().toUpperCase();
                            switch (yORn) {
                                case "Y":
                                    sc.reset();
                                    lsSelectedIndex = 0;
                                    break;
                                case "N":
                                    wl.addToWL(newss);
                                    newss.setWaitingList(true);
                                    System.out.println("Student is now added to waiting list.");
                                    break;
                                default:
                                    System.out.println("Invalid input. Please enter 'Y' for yes or 'N' for no.");
                                    break;
                            }
                        } while (!yORn.equals("Y") && !yORn.equals("N"));
                    } else {
                        sortedSLList.get(lsSelectedIndex - 1).addStudentsInLesson(newss);
                        newss.setUpcomingLesson(sortedSLList.get(lsSelectedIndex - 1));
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
        int selectedSIIndex;
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
        int selectedSSIndex;
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
        if (chosenSS.getLevel() != LEnum.ADVANCE) {
            chooseAward(chosenSI, chosenSS, sl, wl);
        } else {
            String dsORps;
            do {
                System.out.print("Is the awarded qualification for Distance Swim or Personal Survival? (DS/PS) > ");
                dsORps = sc.nextLine().trim().toUpperCase();
                switch (dsORps) {
                    case "DS":
                        chooseAward(chosenSI, chosenSS, sl, wl);
                        break;
                    case "PS":
                        chooseAward(chosenSI, chosenSS);
                        break;
                    default:
                        System.out.println("Invalid input. Please enter 'DS' for Distance Swim or 'PS' for Personal Survival.");
                        break;
                }
            } while (!dsORps.equals("DS") && !dsORps.equals("PS"));
        }
    }

    private void chooseAward(Instructor chosenSI, SwimStudent chosenSS, ArrayList<SwimLesson> sl, WaitingList wl) {
        Scanner sc = new Scanner(System.in);
        int selectedSDIndex;
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
                if (lessonFound != null) {
                    lessonFound.addStudentsInLesson(chosenSS);
                    chosenSS.setUpcomingLesson(lessonFound);
                    System.out.println("The next lesson for " + chosenSS.getName() + " will be: ");
                    System.out.printf("%-50s%n", "==============================================");
                    System.out.print(lessonFound.toStringOptionList());
                    System.out.printf("%-50s%n", "==============================================");
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

    private void chooseAward(Instructor chosenSI, SwimStudent chosenSS) {
        Scanner sc = new Scanner(System.in);
        PSEnum[] psQ = {PSEnum.BRONZE, PSEnum.SILVER, PSEnum.GOLD};
        int selectedPSIndex;
        boolean validInput = false;
        int x = 1;
        PSEnum chosenPS = null;
        System.out.printf("%-35s%n", "===================================");
        System.out.printf("%-7s| %-25s|%n", "", "Survival medal to Award");
        System.out.printf("%-35s%n", "-----------------------------------");
        if (!chosenSI.findMissing(psQ, chosenSS).isEmpty()) {
            for (PSEnum ps : chosenSI.findMissing(psQ, chosenSS)) {
                System.out.printf("%-4d...| %-25s|%n", x, ps);
                x++;
            }
            System.out.printf("%-35s%n", "===================================");
            do {
                System.out.print("Select the award to be granted > ");
                try {
                    String input = sc.nextLine();
                    selectedPSIndex = Integer.parseInt(input.trim());
                    if (selectedPSIndex > 0 && selectedPSIndex <= chosenSI.findMissing(psQ, chosenSS).size()) {
                        chosenPS = chosenSI.findMissing(psQ, chosenSS).get(selectedPSIndex - 1);
                        validInput = true;
                    } else {
                        System.out.println("Please select a value from the available range.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter an available medal to award.");
                }
            } while (!validInput);
            PersonalSurvival newPSQ = new PersonalSurvival(chosenSI, chosenPS);
            chosenSS.setPsQualification(newPSQ);
        } else {
            System.out.printf("| %-32s|%n", "No more survival medals to give");
            System.out.printf("%-35s%n", "===================================");
        }
    }
}
