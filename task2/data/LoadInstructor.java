//Student ID: M00774667
package task2.data;

//Import any essential packages to use in this class
import java.util.ArrayList;
import java.util.Random;
//Import Instructor class to create the objects
import task2.Instructor;

public class LoadInstructor {

    private static LoadInstructor instance;//Static variable referring to the single created instance of LoadInstructor
    private final ArrayList<Instructor> allInstructors;
    private final ArrayList<Instructor> recentlySelected;

    //Private constructor to disallow creation of other object instances of LoadInstructor outside of this class
    private LoadInstructor() {
        this.allInstructors = new ArrayList<>();
        this.recentlySelected = new ArrayList<>();
    }

    //Returns a new LoadInstructor if one does not exist or the previously created object if it does exist
    public static LoadInstructor getLoaderInstance() {
        if (instance != null) {
            return instance;
        } else {
            instance = new LoadInstructor();
            return instance;
        }
    }

    //Method that creates an Instructor object for each string element in an array for the dummy data
    public void createDummy() {
        String[] in = {"Willy Wonka", "Jackie Chan", "Jennifer Coolidge", "John Wick", "Timmy Turner", "Tom Hanks"};
        for (String name : in) {
            Instructor instructor = new Instructor(name);
            //Add each Instructor object to an ArrayList
            allInstructors.add(instructor);
        }
    }

    //Method to return the ArrayList with all the Instructor objects
    public ArrayList<Instructor> getInstructors() {
        return this.allInstructors;
    }

    //Method to return a random Instructor from the ArrayList
    public Instructor selectRandom() {
        Random r = new Random();
        int index = r.nextInt(allInstructors.size());
        return allInstructors.get(index);
    }

    //Method to return a random Instructor 
    public Instructor selectRandomInstructor() {
        Random random = new Random();
        Instructor selectedInstructor;
        do {//Loop until an instructor is found and that has not been recentrly selected 
            selectedInstructor = allInstructors.get(random.nextInt(allInstructors.size()));
        } while (recentlySelected.contains(selectedInstructor));
        recentlySelected.add(selectedInstructor);
        //If more than two instructors have been selected consecutively, clear the recently selected ArrayList
        if (recentlySelected.size() > 2) {
            recentlySelected.clear();
        }
        return selectedInstructor;
    }
}
