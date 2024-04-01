//Student ID: M00774667
package task2.data;

import java.util.ArrayList;
import java.util.Random;
import task2.Instructor;

public class LoadInstructor {

    private static LoadInstructor instance;
    private final ArrayList<Instructor> allInstructors;
    private final ArrayList<Instructor> recentlySelected;

    private LoadInstructor() {
        this.allInstructors = new ArrayList<>();
        this.recentlySelected = new ArrayList<>();
    }

    public static LoadInstructor getLoaderInstance() {
        if (instance != null) {
            return instance;
        } else {
            instance = new LoadInstructor();
            return instance;
        }
    }

    public void createDummy() {
        String[] in = {"Willy Wonka", "Jackie Chan", "Jennifer Coolidge", "John Wick", "Timmy Turner", "Tom Hanks"};
        for (String name : in) {
            Instructor instructor = new Instructor(name);
            allInstructors.add(instructor);
        }
    }

    public ArrayList<Instructor> getInstructors() {
        return this.allInstructors;
    }
    public Instructor selectRandom(){
        Random r = new Random();
        int index = r.nextInt(allInstructors.size());
        return allInstructors.get(index);
    }
    public Instructor selectRandomInstructor(){
        Random random = new Random();
        Instructor selectedInstructor;

        do {
            selectedInstructor = allInstructors.get(random.nextInt(allInstructors.size()));
        } while (recentlySelected.contains(selectedInstructor));

        recentlySelected.add(selectedInstructor);

        if (recentlySelected.size() > 2) {
            recentlySelected.clear();
        }
        return selectedInstructor;
        
    }
}
