package Superhelt;

import Superhelt.Superhelte;

import java.util.ArrayList;

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
}
