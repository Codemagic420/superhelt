package Superhelt;

import Superhelt.Superhelte;

import java.util.ArrayList;

public class Controller {
    private Database database;

    public Controller(Database database) {
        this.database = database;
    }

    public ArrayList<Superhelte> hentAlleSuperhelte() {
        return database.getAllSuperhelte();
    }
}
