package task1.data;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Scanner;

public class DataParser {
    private String dBlock;
    private boolean awarded = true;
    private String yearRegex = "\\d{4}\\s*";
    private String notAwardedRegex = "Not awarded\\s*";
    private String secondLineRegex = "^(.*?)\\s*(?:\\((b\\.\\s*(\\d{4}))\\)|\\((\\d{4}-\\d{4})\\))\\|([^\\n]+)\\|([^\\n]+)\\s*";
    private String CitationRegex = "";
    private String GenresRegex = "";
    public DataParser(String block) {
        this.dBlock = block;
    }
    public String extractYear(){
        Scanner scanner = new Scanner(this.dBlock);
        String yearToExtract = "";
        while(scanner.hasNextLine()){
            String line = scanner.nextLine();
            Pattern yearPattern = Pattern.compile(this.yearRegex);
            Matcher yearMatcher = yearPattern.matcher(line); 
            if(yearMatcher.matches()){
                yearToExtract = line;
            }
        }
        scanner.close();
        return yearToExtract;
    }
    public boolean checkIfAwarded(){
        Scanner scanner = new Scanner(this.dBlock);
        while(scanner.hasNextLine()){
            String line = scanner.nextLine();
            Pattern notAwardedPattern = Pattern.compile(this.notAwardedRegex);
            Matcher notAwardedMatcher = notAwardedPattern.matcher(line);
            if(notAwardedMatcher.matches()){
                this.awarded = false;
            }
        }
        scanner.close();
        return this.awarded;
    }
    public String extractName(){
        Scanner scanner = new Scanner(this.dBlock);
        String nameToExtract = "";
        while(scanner.hasNextLine()){
            String line = scanner.nextLine();
            Pattern secondLinePattern = Pattern.compile(this.secondLineRegex);
            Matcher secondLineMatcher = secondLinePattern.matcher(line);
            if(secondLineMatcher.find()){
                //Get matching line and use the group with the name only
                nameToExtract = secondLineMatcher.group(1);
//                System.out.println(nameMatcher.group(1));
            }
        }
        scanner.close();
        //return the name group
        return nameToExtract;
    }
    public String extractBirthDeath(){
       Scanner scanner = new Scanner(this.dBlock);
        String doBdoDToExtract = "";
        while(scanner.hasNextLine()){
            String line = scanner.nextLine();
            Pattern secondLinePattern = Pattern.compile(this.secondLineRegex);
            Matcher secondLineMatcher = secondLinePattern.matcher(line);
            if(secondLineMatcher.find()){
                //Get whole line and then split in blocks and store the name block
//                System.out.println(secondLineMatcher.group(1));
//                System.out.println(secondLineMatcher.group(5));
//                System.out.println(secondLineMatcher.group(6));
                if (secondLineMatcher.group(3) != null){
                    doBdoDToExtract = secondLineMatcher.group(3);
                } else if (secondLineMatcher.group(4) != null){                   
                    doBdoDToExtract = secondLineMatcher.group(4);
                }
            }
        }
        scanner.close();
        //return the DoB or DoB-DoD group
        return doBdoDToExtract; 
    }
//    public String extractCountry(){
//        
//    }
//    public String extractLanguage(){
//        
//    }
//    public String extractCitation(){
//        
//    }
//    public String extractGenres(){
//        
//    }
}
