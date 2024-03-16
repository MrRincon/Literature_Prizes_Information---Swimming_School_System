package task1;

import java.util.ArrayList;

public class LiteraturePrize {

    private String year;
    private ArrayList<Laureate> lauretes;

    public LiteraturePrize(String year, ArrayList<Laureate> lauretes) {
        this.year = year;
        this.lauretes = lauretes;
    }
    public String toString() {
        return "LiteraturePrize{\n" + "year=" + year + ", lauretes=" + lauretes + '}';
    }

    public String getYear() {
        return year;
    }

    public ArrayList<Laureate> getLauretes() {
        return lauretes;
    }
}
