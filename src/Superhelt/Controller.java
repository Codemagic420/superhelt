package Superhelt;
import java.util.Collections;
import java.util.Comparator;

import Superhelt.Superhelte;

import java.util.ArrayList;

public class Controller {
    private static Database database;

    public Controller(Database database) {
        this.database = database;
    }

    public static ArrayList<Superhelte> hentAlleSuperhelte() {
        return database.getAllSuperhelte();
    }
}
