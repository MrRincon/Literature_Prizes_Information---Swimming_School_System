package task1.data;

import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
//import java.util.regex.Matcher;
//import java.util.regex.Pattern;

public class DataLoader {
//    static variable referring to the single created instance of DataLoader
    private static DataLoader instance;
    private final String filePath = System.getProperty("user.dir");
    private final String ipFile = filePath + File.separator + "literature-prizes.txt";
    
//    privatize constructor to disallow creation of other object instances of DataLoader outside of this class
    private DataLoader(){        
    }
    
//    returns a new DataLoader if one does not exist and the previously created object if it does exist
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
                System.out.println("----------------");
                //Create LiteraturePrize Obj with the Year only if it doesn't exist already
                System.out.println(parseData.extractYear()); 
                System.out.println(parseData.checkIfAwarded());
                //Check if on that year anything has been awarded, if not, do nothing
                if(parseData.checkIfAwarded()){
                    //Extract the data from the current data block and create Laureate Obj
                    System.out.println(parseData.extractName());
                    System.out.println(parseData.extractBirthDeath());
////                    System.out.println(parseData.extractCountry());
////                    System.out.println(parseData.extractLanguage());
////                    System.out.println(parseData.extractCitation());
////                    System.out.println(parseData.extractGenres());
////                    //Add Laureate Obj into the LiteraturePrize Obj a rray
                }
            }
            scanner.close();
        } catch (FileNotFoundException e){
            e.printStackTrace();
        }  
    }
}
//public class DataLoader {
//    private final String filePath = System.getProperty("user.dir");
//    private final String ipFile = filePath + File.separator + "literature-prizes.txt";
//    private final ArrayList<String> dataBlocks = new ArrayList<>();
//    public ArrayList<String> readLines() {
//        try {
//            File file = new File(ipFile);
//            Scanner scanner = new Scanner(file);
//            scanner.useDelimiter("-----");
//            while(scanner.hasNext()){ 
//                String block = scanner.next();
//                dataBlocks.add(block);
//                DataParser parseData = new DataParser(block);
//                System.out.println(parseData.getBlockData()); 
//                System.out.println(parseData.extractYear());
//
//            }
//            scanner.close();
//        } catch (FileNotFoundException e){
//            e.printStackTrace();
//        }
//        return (dataBlocks);
//    }
//}
    
//    public DataLoader(){
//        theData = new String[1000];
//        the readLines();
//    }
//    public String[] getTheData(){
//        return theData;
//    }
//    private void loadFromFile(){
//        
////        String awardedRegexPattern = "(\\d{4})\\s*(.+?)\\((\\d{4}-\\d{4})\\)\\|(.*?)\\|(.*?)\\s*\"(.*?)\"\\s*(.*?)\\s*-----";
////        String notAwardedRegexPattern = "(\\d{4}\\Not awarded\\s*-----";
//        File fileObj = new File(ipFile);
//        Scanner sc = null;
//        try {
//            sc = new Scanner(fileObj);
//            int index = 0;
//            while (sc.hasNext()){
//                theData[index]= sc.nextLine().trim();
//                index++;
//            }
//        } catch (FileNotFoundException fnf){
//            System.out.println("File not found ");
//            System.exit(0);
//        }
//    }
    

