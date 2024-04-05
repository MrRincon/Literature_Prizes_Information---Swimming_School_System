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
                students.add(addNewSS(lessons, wl));
                return true;
            case 5://Award a swim qualification
                awardSQ(instructors, students, lessons, wl);
                return true;
            case 6://Move swim student from the waiting list
                moveStudentFromWL(students, wl, lessons);
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
        //Swimming students ArrayList sorted alphabetically by name using TreeSet
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
        //Swimming lessons ArrayList sorted by a TreeSet and a string pattern defined on the SwimLesson class
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

    //Method to display information about the swimming instructors schedules
    private void instructorSchedule(ArrayList<Instructor> si) {
        Scanner sc = new Scanner(System.in);
        int selectedSIIndex;
        boolean validInput = false;
        int x = 1;
        //Swimming instructor ArrayList sorted alphabetically by name using TreeSet
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

    //Method to add a new swimming student
    private SwimStudent addNewSS(ArrayList<SwimLesson> sl, WaitingList wl) {
        Scanner sc = new Scanner(System.in);
        String newName = "";
        boolean validName = false;
        int x = 1;
        int lsSelectedIndex = 0;
        do {
            //Prompt user input for the name of the new student
            System.out.print("Enter the new student's name > ");
            newName = sc.nextLine();
            //Check for only alphabetic characters
            if (newName.matches("[a-zA-Z]+")) {
                validName = true;
            } else {
                System.out.println("Please enter an actual name");
            }
        } while (!validName);
        //Use the name input to create a SwimStudent object
        SwimStudent newss = new SwimStudent(newName);
        //Swimming lessons ArrayList sorted by a string pattern and the novice level
        TreeSet<SwimLesson> sortedSL = new TreeSet<>(Comparator.comparing(lesson -> lesson.toStringOptionList(LEnum.NOVICE)));
        sortedSL.addAll(sl);
        ArrayList<SwimLesson> sortedSLList = new ArrayList<>(sortedSL);
        //Display all the novice lessons basic information with an index
        for (SwimLesson lesson : sortedSLList) {
            System.out.printf("%-46s%n", "^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
            System.out.printf("%-4d...%n", x);
            System.out.print(lesson);
            x++;
        }
        System.out.printf("%-46s%n", "^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
        do {
            //Prompt user input to select a lesson using the index
            System.out.print("Insert the lesson's index that the student would like to attend > ");
            try {
                lsSelectedIndex = Integer.parseInt(sc.nextLine().trim());
                //Check if the input is within range
                if (lsSelectedIndex >= 1 && lsSelectedIndex <= sortedSLList.size()){
                    //Check if the selected lesson is full
                    if (sortedSLList.get(lsSelectedIndex - 1).getStudentsInLesson().size() == 4) {
                        System.out.println("Sorry, but this lesson is full.");
                        String yORn;
                        do {
                            //Prompt user input to choose another lesson or get on the waiting list
                            System.out.print("Would the student like to select another lesson? (Y/N) > ");
                            yORn = sc.nextLine().trim().toUpperCase();
                            switch (yORn) {
                                case "Y":
                                    //Reset the scanner and the selected index to select again
                                    sc.reset();
                                    lsSelectedIndex = 0;
                                    break;
                                case "N":
                                    wl.addToWL(newss);//Add student to the waiting list
                                    newss.setWaitingList(true);//Specify that the student is on the waiting list
                                    System.out.println("Student is now added to waiting list.");
                                    break;
                                default:
                                    System.out.println("Invalid input. Please enter 'Y' for yes or 'N' for no.");
                                    break;
                            }
                        } while (!yORn.equals("Y") && !yORn.equals("N"));
                    } else {
                        //Add the new student to the lesson
                        sortedSLList.get(lsSelectedIndex - 1).addStudentsInLesson(newss);
                        //Assign the lesson to the new student
                        newss.setUpcomingLesson(sortedSLList.get(lsSelectedIndex - 1));
                        System.out.println("Student is now booked for this lesson.");
                    }
                } else {
                    System.out.println("Please enter a number within the valid range");
                    lsSelectedIndex = 0;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number");
            }
        } while (lsSelectedIndex < 1 || lsSelectedIndex > x);
        //Return the new student to be added to the list of all the students
        return newss;
    }

    //Method for an instructor to award a qualification to a student
    private void awardSQ(ArrayList<Instructor> si, ArrayList<SwimStudent> ss, ArrayList<SwimLesson> sl, WaitingList wl) {
        Scanner sc = new Scanner(System.in);
        int selectedSIIndex;
        boolean validInput = false;
        int x = 1;
        Instructor chosenSI = null;
        //Swimming instructor ArrayList sorted alphabetically by name using TreeSet
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
            System.out.print("Input a number to select an instructor > ");
            try {
                String input = sc.nextLine();
                selectedSIIndex = Integer.parseInt(input.trim());
                //Check if input is within range
                if (selectedSIIndex > 0 && selectedSIIndex <= sortedSIList.size()) {
                    chosenSI = sortedSIList.get(selectedSIIndex - 1);//Save the instructor selected
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
        SwimStudent chosenSS = null; 
        //Swimming students that are not on waiting list in ArrayList sorted alphabetically by name using TreeSet
        TreeSet<SwimStudent> sortedSS = new TreeSet<>(Comparator.comparing(SwimStudent::getName));
        sortedSS.addAll(ss);
        ArrayList<SwimStudent> sortedSSList = new ArrayList<>();
        sortedSS.forEach(student -> {
            if (!student.isWaitingList()) {
                sortedSSList.add(student);
            }
        });
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
            System.out.print("Input a number to select the student > ");
            try {
                String input = sc.nextLine();
                selectedSSIndex = Integer.parseInt(input.trim());
                //Check if input is within range
                if (selectedSSIndex > 0 && selectedSSIndex <= sortedSSList.size()) {
                    chosenSS = sortedSSList.get(selectedSSIndex - 1);//Save the student selected
                    validInput = true;
                } else {
                    System.out.println("Please select a value from the available range.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter an existent student.");
            }
        } while (!validInput);
        if (chosenSS.getLevel() != LEnum.ADVANCE) {//Distance award selection if student level is not advance
            chooseAward(chosenSI, chosenSS, sl, wl);//Award qualification for Distance Swim
        } else {
            String dsORps;
            do {
                // Prompt user input to specify the type of qualification for advance level students
                System.out.print("Is the awarded qualification for Distance Swim or Personal Survival? (DS/PS) > ");
                dsORps = sc.nextLine().trim().toUpperCase();
                switch (dsORps) {
                    case "DS":
                        chooseAward(chosenSI, chosenSS, sl, wl);//Award qualification for Distance Swim
                        break;
                    case "PS":
                        chooseAward(chosenSI, chosenSS);//Award qualification for Personal Survival
                        break;
                    default:
                        System.out.println("Invalid input. Please enter 'DS' for Distance Swim or 'PS' for Personal Survival.");
                        break;
                }
            } while (!dsORps.equals("DS") && !dsORps.equals("PS"));
        }
    }

    //Method to assign a lesson to a student and remove the student from the waiting list
    private void moveStudentFromWL(ArrayList<SwimStudent> ss, WaitingList wl, ArrayList<SwimLesson> sl) {
        Scanner sc = new Scanner(System.in);
        int selectedSSIndex;
        boolean validInput = false;
        int x = 1;
        SwimStudent chosenSS = null;
        //Header for students basic information
        System.out.printf("%-34s%n", "==================================");
        System.out.printf("%-7s| %-12s| %-10s|%n", "", "Name", "Level");
        System.out.printf("%-34s%n", "----------------------------------");
        //Display all the students in waiting list basic information with an index
        for (SwimStudent student : wl.getWS()) {
            System.out.printf("%-4d...| %-12s| %-10s|%n", x, student.getName(), student.getLevel());
            x++;
        }
        System.out.printf("%-34s%n", "==================================");
        do {
            //Prompt user input to select a student using the index
            System.out.print("Input the student's index to assign a lesson > ");
            try {
                selectedSSIndex = Integer.parseInt(sc.nextLine().trim());
                //Check if input is within range
                if (selectedSSIndex > 0 && selectedSSIndex <= wl.getWS().size()) {
                    //Display all the information of the student
                    chosenSS = wl.getWS().get(selectedSSIndex - 1);
                    validInput = true;
                } else {
                    System.out.println("Please select a value from the available range.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter an existent student.");
            }
        } while (!validInput);
        System.out.println(chosenSS);
        int lsSelectedIndex = 0;
        int y = 1;
        //Swimming lessons ArrayList sorted by a string pattern and student level using a TreeSet
        TreeSet<SwimLesson> sortedSL = new TreeSet<>(Comparator.comparing(lesson -> lesson.toStringOptionList()));
        for (SwimLesson lesson : sl){
            if(lesson.getLevel() == chosenSS.getLevel()){
                sortedSL.add(lesson);
            }
        }
        ArrayList<SwimLesson> sortedSLList = new ArrayList<>(sortedSL);
        //Header for lessons basic information
        System.out.printf("%-75s%n", "===========================================================================");
        System.out.printf("%-7s| %-11s| %-10s| %-6s| %-10s| %-14s|%n", "", "Date", "Day", "Time", "Level", "Space(s) Available");
        System.out.printf("%-75s%n", "---------------------------------------------------------------------------");
        //Display all the lessons within the student level using basic information and availability with an index
        for (SwimLesson lesson : sortedSLList) {
            String spacesAvail = ""+(4 - lesson.getStudentsInLesson().size())+" space(s) available";
            System.out.printf("%-4d...| %-11s| %-10s| %-6s| %-10s| %-14s|%n", y, lesson.getDate(), lesson.getDay(), lesson.getStart_time(), lesson.getLevel(), spacesAvail);
            y++;
        }
        System.out.printf("%-75s%n", "===========================================================================");
        do {
            //Prompt user input to select a lesson using the index
            System.out.print("Insert the lesson's index that the student would like to attend > ");
            try {
                lsSelectedIndex = Integer.parseInt(sc.nextLine().trim());
                //Check if the input is within range
                if (lsSelectedIndex >= 1 && lsSelectedIndex <= sortedSLList.size()){
                    //Check if the selected lesson is full
                    if (sortedSLList.get(lsSelectedIndex - 1).getStudentsInLesson().size() == 4) {
                        System.out.println("Sorry, but this lesson is full.");
                        String yORn;
                        do {
                            //Prompt user input to choose another lesson or get on the waiting list
                            System.out.print("Would the student like to select another lesson? (Y/N) > ");
                            yORn = sc.nextLine().trim().toUpperCase();
                            switch (yORn) {
                                case "Y":
                                    //Reset the scanner and the selected index to select again
                                    sc.reset();
                                    lsSelectedIndex = 0;
                                    break;
                                case "N":
                                    System.out.println("No lesson has been booked for the student.\nStudent will remain on the waiting list.");
                                    break;
                                default:
                                    System.out.println("Invalid input. Please enter 'Y' for yes or 'N' for no.");
                                    break;
                            }
                        } while (!yORn.equals("Y") && !yORn.equals("N"));
                    } else {
                        sortedSLList.get(lsSelectedIndex - 1).addStudentsInLesson(chosenSS);//Add the student to the lesson
                        chosenSS.setUpcomingLesson(sortedSLList.get(lsSelectedIndex - 1));//Assign the lesson to the student
                        chosenSS.setWaitingList(false);//Confirm the student is not on waiting list
                        wl.removeFromWL(chosenSS);//Remove student from the waiting list
                        System.out.println("Student is now booked for this lesson and removed from the waiting list.");
                    }
                } else {
                    System.out.println("Please enter a number within the valid range");
                    lsSelectedIndex = 0;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number");
            }
        } while (lsSelectedIndex < 1 || lsSelectedIndex > y);
    }

    //Method to choose the distance qualification to award the student
    private void chooseAward(Instructor chosenSI, SwimStudent chosenSS, ArrayList<SwimLesson> sl, WaitingList wl) {
        Scanner sc = new Scanner(System.in);
        int selectedSDIndex;
        boolean validInput = false;
        int x = 1;
        DAEnum chosenDA = null;
        //Header for distances to award
        System.out.printf("%-29s%n", "=============================");
        System.out.printf("%-7s| %-19s|%n", "", "Distances to Award");
        System.out.printf("%-29s%n", "-----------------------------");
        //Check if student has missing qualifications on the student's current level
        if (!chosenSI.showMissingSD(chosenSS).isEmpty()) {
            //Display all the qualifications not achieved by the student at the student's level
            for (DAEnum distance : chosenSI.showMissingSD(chosenSS)) {
                System.out.printf("%-4d...| %-19s|%n", x, distance);
                x++;
            }
            System.out.printf("%-29s%n", "=============================");
            do {
                //Prompt user input to select a distance qualification to grant
                System.out.print("Select the qualification to be granted > ");
                try {
                    String input = sc.nextLine();
                    selectedSDIndex = Integer.parseInt(input.trim());
                    //Check if the input is within range
                    if (selectedSDIndex > 0 && selectedSDIndex <= chosenSI.showMissingSD(chosenSS).size()) {
                        chosenDA = chosenSI.showMissingSD(chosenSS).get(selectedSDIndex - 1);//Save the chosen qualification to award
                        validInput = true;
                    } else {
                        System.out.println("Please select a value from the available range.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter an available distance to award.");
                }
            } while (!validInput);
            //If the grant qualification method returns true, the qualification will be granted
            if (chosenSI.grantQualification(chosenSS, chosenDA)) {
                SwimLesson lessonFound = null;
                for (SwimLesson lesson : sl) {
                    //Finds a lesson that matches with the student level and that it is not full with other students
                    if (lesson.getLevel() == chosenSS.getLevel() && lesson.getStudentsInLesson().size() < lesson.getMaxStudents()) {
                        lessonFound = lesson;
                    }
                }
                //If lesson is found, assign and display lesson basic information
                if (lessonFound != null) {
                    lessonFound.addStudentsInLesson(chosenSS);//Add student to the lesson
                    chosenSS.setUpcomingLesson(lessonFound);//Assign lesson as the upcoming lesson of that student
                    System.out.println("The next lesson for " + chosenSS.getName() + " will be: ");
                    System.out.printf("%-50s%n", "==============================================");
                    System.out.print(lessonFound.toStringOptionList());
                    System.out.printf("%-50s%n", "==============================================");
                } else {//If lesson is not found, student will be added on the waiting list
                    chosenSS.setWaitingList(true);
                    wl.addToWL(chosenSS);
                    System.out.println("This lesson is not available at the moment for this level. Swim student will be place on the waiting list.");
                }
            } else {//if function returns false, the student was promoted and still granted the qualification
                chosenSS.setWaitingList(true);//Confirm the student is on waiting list
                wl.addToWL(chosenSS);//Add student to waiting list
                chosenSS.setUpcomingLesson(null);//Remove any upcoming lesson
                System.out.println("The swim level of the student has increased to " + chosenSS.getLevel()
                        + ".\nStudent is now on the waiting list.");
            }
        } else {//Display message if the advanced student has achieved all the distance swim qualification
            System.out.printf("| %-26s|%n", "No more awards to give");
            System.out.printf("%-29s%n", "=============================");
        }
    }

    //Method to choose the personal survival qualification to award an advanced student
    private void chooseAward(Instructor chosenSI, SwimStudent chosenSS) {
        Scanner sc = new Scanner(System.in);
        //Array of possible personal survival qualifications
        PSEnum[] psQ = {PSEnum.BRONZE, PSEnum.SILVER, PSEnum.GOLD};
        int selectedPSIndex;
        boolean validInput = false;
        int x = 1;
        PSEnum chosenPS = null;
        //Header for survival medals to award
        System.out.printf("%-35s%n", "===================================");
        System.out.printf("%-7s| %-25s|%n", "", "Survival medal to Award");
        System.out.printf("%-35s%n", "-----------------------------------");
        //Check if student has missing qualifications
        if (!chosenSI.findMissing(psQ, chosenSS).isEmpty()) {
            //Display all the qualifications not achieved by the student
            for (PSEnum ps : chosenSI.findMissing(psQ, chosenSS)) {
                System.out.printf("%-4d...| %-25s|%n", x, ps);
                x++;
            }
            System.out.printf("%-35s%n", "===================================");
            do {
                //Prompt user input to select a personal survival qualification to grant
                System.out.print("Select the qualification to be granted > ");
                try {
                    String input = sc.nextLine();
                    selectedPSIndex = Integer.parseInt(input.trim());
                    //Check if the input is within range
                    if (selectedPSIndex > 0 && selectedPSIndex <= chosenSI.findMissing(psQ, chosenSS).size()) {
                        chosenPS = chosenSI.findMissing(psQ, chosenSS).get(selectedPSIndex - 1);//Save the chosen qualification
                        validInput = true;
                    } else {
                        System.out.println("Please select a value from the available range.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter an available medal to award.");
                }
            } while (!validInput);
            //Create new personal survival qualification object
            PersonalSurvival newPSQ = new PersonalSurvival(chosenSI, chosenPS);
            chosenSS.setPsQualification(newPSQ);//Set the qualification as the student's qualification
        } else {//Display message if the student has achieved the highest personal survival qualification
            System.out.printf("| %-32s|%n", "Highest survival medal achieved");
            System.out.printf("%-35s%n", "===================================");
        }
    }
}
