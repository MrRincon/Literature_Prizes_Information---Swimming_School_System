package task1.data;

import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import task1.Laureate;
import task1.LiteraturePrize;

public class DataLoader {
    
    //Static variable referring to the single created instance of DataLoader
    private static DataLoader instance;
    private final String filePath = System.getProperty("user.dir");
    private final String ipFile = filePath + File.separator + "literature-prizes.txt";
    private final ArrayList<LiteraturePrize> allYears;
    //Privatize constructor to disallow creation of other object instances of DataLoader outside of this class
    private DataLoader(){
        this.allYears = new ArrayList<>();
    }
    
    //Returns a new DataLoader if one does not exist and the previously created object if it does exist
    public static DataLoader getLoaderInstance(){
        if(instance != null){
            return instance;
        }else{
            instance = new DataLoader();
            return instance;
        }
    }
    
    public void readLines() {
        File file = new File(ipFile);
        try {
            Scanner scanner = new Scanner(file);
            scanner.useDelimiter("-----");
            while(scanner.hasNext()){ 
                String block = scanner.next();
                DataParser parseData = new DataParser(block);
                ArrayList<Laureate> awardedTo = new ArrayList<>();
                //Check if on that year anything has been awarded, if not, do nothing
                if(parseData.checkIfAwarded()){
                    //Extract the data from the current data block and create Laureate Obj
                    for(int i = 0; i<(parseData.extractName().size()); i++){
                        Laureate laureate = new Laureate(
                                parseData.extractName().get(i),
                                parseData.extractBirthDeath().get(i),
                                parseData.extractCountry().get(i),
                                parseData.extractLanguage().get(i),
                                parseData.extractCitation().get(i),
                                parseData.extractGenres().get(i)
                        );
                        awardedTo.add(laureate);
                    }
                    LiteraturePrize NewPrize = new LiteraturePrize(
                            parseData.extractYear(),
                            awardedTo
                    );
                    //Add Laureate Obj into the LiteraturePrize Obj array
                    this.allYears.add(NewPrize);
                } else {
                    LiteraturePrize NewPrize = new LiteraturePrize(
                            parseData.extractYear(),
                            awardedTo
                    );
                    this.allYears.add(NewPrize);
                }
            }
            scanner.close();
        } catch (FileNotFoundException e){
            System.out.println("File not found");
        }
    }
    public ArrayList<LiteraturePrize> getYearObjs(){
        return this.allYears;
    }
}