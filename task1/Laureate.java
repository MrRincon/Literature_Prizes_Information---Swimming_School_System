package task1;

import java.util.ArrayList;

public class Laureate {
    private String name;
    private ArrayList<String> birth_death;
    private ArrayList<String> nations;
    private ArrayList<String> languages;
    private String citation;
    private ArrayList<String> genres;
    public Laureate(String name, ArrayList<String> birth_death, ArrayList<String> nations, ArrayList<String> languages, String citation, ArrayList<String> genres) {
        this.name = name;
        this.birth_death = birth_death;
        this.nations = nations;
        this.languages = languages;
        this.citation = citation;
        this.genres = genres;
    } 
    public String toString(){
        return this.name + "\n" + this.birth_death + "\n" + this.nations + "\n" + this.languages + "\n" + this.citation + "\n" + this.genres;
    }

    public String getName() {
        return name;
    }

    public ArrayList<String> getBirth_death() {
        return birth_death;
    }

    public ArrayList<String> getNations() {
        return nations;
    }

    public ArrayList<String> getLanguages() {
        return languages;
    }

    public String getCitation() {
        return citation;
    }

    public ArrayList<String> getGenres() {
        return genres;
    }
    
}
