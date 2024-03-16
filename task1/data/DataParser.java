package task1.data;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Scanner;
import java.util.ArrayList;

public class DataParser {
    private String dBlock;
    private boolean awarded = true;
    private String yearRegex = "\\d{4}\\s*";
    private String notAwardedRegex = "Not awarded\\s*";
    private String secondLineRegex = "(.*?)\\s*(?:\\((b\\.\\s*(\\d{4}))\\)|\\((\\d{4}-\\d{4})\\)|\\((\\d{4}-\\d{3})\\))\\|([^\n]+)\\|([^\n]+)\\s*";
    private String citationLineRegex = "\"(.*?)\"";
    private String genresLineRegex = "^[a-zA-Z ,]+$";
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
    public ArrayList<String> extractName(){
        Scanner scanner = new Scanner(this.dBlock);
        ArrayList<String> namesToExtract = new ArrayList<>();
        while(scanner.hasNextLine()){
            String line = scanner.nextLine();
            Pattern secondLinePattern = Pattern.compile(this.secondLineRegex);
            Matcher secondLineMatcher = secondLinePattern.matcher(line);
            if(secondLineMatcher.find()){
                //Get matching line and use the group with the name only
                namesToExtract.add(secondLineMatcher.group(1));
            }
        }
        scanner.close();
        //return the name group
        return namesToExtract;
    }
    public ArrayList<ArrayList<String>> extractBirthDeath(){
       Scanner scanner = new Scanner(this.dBlock);
        ArrayList<ArrayList<String>> doBdoDToExtract = new ArrayList<>();
        while(scanner.hasNextLine()){
            String line = scanner.nextLine();
            Pattern secondLinePattern = Pattern.compile(this.secondLineRegex);
            Matcher secondLineMatcher = secondLinePattern.matcher(line);
            if(secondLineMatcher.find()){
                //Get whole line and add only the DoB/DoD group that is not null to an ArrayList
                if (secondLineMatcher.group(3) != null){
                    ArrayList<String> dobArrayL = new ArrayList<>();
                    dobArrayL.add(secondLineMatcher.group(3));
                    dobArrayL.add("----");
                    doBdoDToExtract.add(dobArrayL);
                } else if (secondLineMatcher.group(4) != null){
                    String[] dates = secondLineMatcher.group(4).split("-");
                    ArrayList<String> dobdodArrayL = new ArrayList<>();
                    for (String date : dates){
                        dobdodArrayL.add(date);
                    }
                    doBdoDToExtract.add(dobdodArrayL);
                } else if (secondLineMatcher.group(5) != null){
                    String[] dates = secondLineMatcher.group(5).split("-");
                    ArrayList<String> dobdodArrayL = new ArrayList<>();
                    for (String date : dates){
                        dobdodArrayL.add(date);
                    }
                    doBdoDToExtract.add(dobdodArrayL);
                }
            }   
        }
        scanner.close();
        //return the DoB or DoB-DoD group
        return doBdoDToExtract; 
    }
    public ArrayList<ArrayList<String>> extractCountry(){
        Scanner scanner = new Scanner(this.dBlock);
        ArrayList<ArrayList<String>> countriesToExtract = new ArrayList<>();
        while(scanner.hasNextLine()){
            String line = scanner.nextLine();
            Pattern secondLinePattern = Pattern.compile(this.secondLineRegex);
            Matcher secondLineMatcher = secondLinePattern.matcher(line);
            if(secondLineMatcher.find()){
                String[] countries = secondLineMatcher.group(6).split(",");
                ArrayList<String> countriesArrayL = new ArrayList<>();
                for (String country : countries){
                    countriesArrayL.add(country);
                }
                //Get whole line and add only the countries group to an ArrayList
                countriesToExtract.add(countriesArrayL);
            }
        }
        scanner.close();
        //return the countries ArrayList
        return countriesToExtract;
    }
    public ArrayList<ArrayList<String>> extractLanguage(){
        Scanner scanner = new Scanner(this.dBlock);
        ArrayList<ArrayList<String>> languagesToExtract = new ArrayList<>();
        while(scanner.hasNextLine()){
            String line = scanner.nextLine();
            Pattern secondLinePattern = Pattern.compile(this.secondLineRegex);
            Matcher secondLineMatcher = secondLinePattern.matcher(line);
            if(secondLineMatcher.find()){
                String[] languages = secondLineMatcher.group(7).split(",");
                ArrayList<String> languagesArrayL = new ArrayList<>();
                for (String language : languages){
                    languagesArrayL.add(language);
                }
                languagesToExtract.add(languagesArrayL);
            }
        }
        scanner.close();
        //return the languages ArrayList
        return languagesToExtract;
    }
    public ArrayList<String> extractCitation(){
        Scanner scanner = new Scanner(this.dBlock);
        ArrayList<String> citationToExtract = new ArrayList<>();
        while(scanner.hasNextLine()){
            String line = scanner.nextLine();
            Pattern citationLinePattern = Pattern.compile(this.citationLineRegex);
            Matcher citationLineMatcher = citationLinePattern.matcher(line);
            if(citationLineMatcher.matches()){
                citationToExtract.add(line);
            }
        }
        scanner.close();
        //return the citation line
        return citationToExtract;
    }
    public ArrayList<ArrayList<String>> extractGenres(){
        Scanner scanner = new Scanner(this.dBlock);
        ArrayList<ArrayList<String>> genresToExtract = new ArrayList<>();
        while(scanner.hasNextLine()){
            String line = scanner.nextLine();
            Pattern genresLinePattern = Pattern.compile(this.genresLineRegex);
            Matcher genresLineMatcher = genresLinePattern.matcher(line);
            if(genresLineMatcher.matches()){
                String[] genres = line.split(",");
                ArrayList<String> genresArrayL = new ArrayList<>();
                for (String genre : genres){
                    genresArrayL.add(genre);
                }
                genresToExtract.add(genresArrayL);   
            }
        }
        scanner.close();
        //return the genres line
        return genresToExtract;
    }
}
