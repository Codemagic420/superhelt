package Superhelt;
import java.io.*;
import java.util.ArrayList;

public class filehandler {
    private static final String FILE_PATH = "superheroes.txt";

    public static void saveSuperheroes(ArrayList<Superhelte> superheroes) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
            for (Superhelte superhelt : superheroes) {
                writer.write(superhelt.toFileString());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Superhelte> loadSuperheroes() {
        ArrayList<Superhelte> superheroes = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                Superhelte superhelt = Superhelte.fromFileString(line);
                superheroes.add(superhelt);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return superheroes;
    }
}

