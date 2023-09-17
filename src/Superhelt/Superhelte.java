package Superhelt;
import java.io.PrintWriter;
import java.util.StringJoiner;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;

public class Superhelte implements Serializable {
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
    public String toFileString() {
        StringJoiner joiner = new StringJoiner(",");
        joiner.add(navn);
        joiner.add(String.valueOf(menneske));
        joiner.add(superkraft);
        joiner.add(String.valueOf(fødselsår));
        joiner.add(String.valueOf(styrke));
        return joiner.toString();
    }
    public static Superhelte fromFileString(String fileString) {
        String[] parts = fileString.split(",");
        String superheroName = parts[0];
        boolean isHuman = Boolean.parseBoolean(parts[1]);
        String superpower = parts[2];
        int creationYear = Integer.parseInt(parts[3]);
        int styrke = Integer.parseInt(parts[4]);

        return new Superhelte(superheroName, isHuman, superpower, creationYear, styrke);
    }
    public static void gemSuperhelteTilFil(ArrayList<Superhelte> superhelteListe, String filnavn) {
        try (PrintWriter writer = new PrintWriter(filnavn)) {
            for (Superhelte superhelt : superhelteListe) {
                writer.println(superhelt.toFileString());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Superhelte> indlæsSuperhelteFraFil(String filnavn) {
        ArrayList<Superhelte> superhelteListe = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filnavn))) {
            String line;
            while ((line = reader.readLine()) != null) {
                superhelteListe.add(Superhelte.fromFileString(line));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return superhelteListe;
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
