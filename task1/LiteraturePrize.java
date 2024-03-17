package task1;

import java.util.ArrayList;

public class LiteraturePrize {

    private int year;
    private ArrayList<Laureate> lauretes;

    public LiteraturePrize(int year, ArrayList<Laureate> lauretes) {
        this.year = year;
        this.lauretes = lauretes;
    }
    public String toString() {
        return "LiteraturePrize{\n" + "year=" + year + ", lauretes=" + lauretes + '}';
    }

    public int getYear() {
        return year;
    }

    public ArrayList<Laureate> getLauretes() {
        return lauretes;
    }
    public String getPrizeWinnersString(){
        if(lauretes.isEmpty()){
            return "";
        }
        StringBuilder builder = new StringBuilder();
        for (Laureate laureate : lauretes){
            builder.append(laureate.getName()+" "+laureate.getNations());
        }
        return builder.toString();
    }
}
