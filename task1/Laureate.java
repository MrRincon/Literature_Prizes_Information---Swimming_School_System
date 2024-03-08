package task1;

public class Laureate {
    private String name;
    private String birth_death;
    private String nations;
    private String languages;
    private String genres;
    private String citation;

    public Laureate(String name, String birth_death, String nations, String languages, String genres, String citation) {
        this.name = name;
        this.birth_death = birth_death;
        this.nations = nations;
        this.languages = languages;
        this.genres = genres;
        this.citation = citation;
    }

    @Override
    public String toString() {
        return "Laureate{" + "name=" + name + ", birth_death=" + birth_death + ", nations=" + nations + ", languages=" + languages + ", genres=" + genres + ", citation=" + citation + '}';
    }
    
}
