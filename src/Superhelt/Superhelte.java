package Superhelt;

public class Superhelte {
    private String navn;
    private boolean menneske;
    private String superkraft;
    private int fødselsår;
    private int styrke;

    public Superhelte(String navn, boolean erMenneske, String superkraft, int fødselsår, int styrke) {
        this.navn = navn;
        this.menneske = erMenneske;
        this.superkraft = superkraft;
        this.fødselsår = fødselsår;
        this.styrke = styrke;
    }

    public String toString() {
        return "Navn: " + navn +
                ", Menneske: " + (menneske ? "Ja" : "Nej") +
                ", Superkraft: " + superkraft +
                ", Fødselsår: " + fødselsår +
                ", Styrke " + styrke;

    }
    public String getSuperheroName() {
        return navn;
    }

    public boolean getIsHuman() {
        return menneske;
    }

    public String getSuperpower() {
        return superkraft;
    }

    public int getCreationYear(){
        return fødselsår;
    }
    public int getStyrke(){
        return styrke;
    }
    }
