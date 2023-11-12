package Superhelt;

import Superhelt.Superhelte;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.FileInputStream;
public class Database {
    private ArrayList<Superhelte> superhelte;

    public Database() {
        superhelte = new ArrayList<>();
    }

    public void addSuperhelt(Superhelte superhelt) {
        superhelte.add(superhelt);
    }

    public ArrayList<Superhelte> getAllSuperhelte() {
        return superhelte;
    }

    public ArrayList<Superhelte> søgsuperhelt(String søgsuperhelt) {
        ArrayList<Superhelte> søgefunktion = new ArrayList<>();
        for (Superhelte søghelt : superhelte) {
            if (søghelt.getSuperheroName().contains(søgsuperhelt)){
                søgefunktion.add(søghelt);
            }
        }
        return søgefunktion;
    }

    public Superhelte getSuperhero(String name){
        for(Superhelte s : superhelte) {
            if(s.getSuperheroName().equals(name)) {
                return s;
            }
        }
        return null;
    }

    public void updateHero(Superhelte hero) {
        for(int i = 0; i< superhelte.size() ; i++) {
            if(superhelte.get(i).getSuperheroName().equals(hero.getSuperheroName())) {
                superhelte.set(i, hero);
            }
        }
    }
    public void gemSuperhelteTilFil() throws IOException {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("superhelte.ser"))) {
            outputStream.writeObject(superhelte);
            System.out.println("Superhelte gemt til fil.");
        } catch (IOException e) {
            System.out.println("Fejl ved gemSuperhelteTilFil: " + e.getMessage());
            throw e;
        }
    }


    public void indlæsSuperhelteFraFil() {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("superhelte.txt"))) {
            superhelte = (ArrayList<Superhelte>) inputStream.readObject();
            System.out.println("Superhelte indlæst fra fil.");
        } catch (FileNotFoundException e) {
            System.out.println("Filen 'superhelte.txt' blev ikke fundet. En ny fil vil blive oprettet ved næste gemSuperhelteTilFil.");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("Fejl ved indlæsSuperhelteFraFil: " + e.getMessage());
        }
    }
}
