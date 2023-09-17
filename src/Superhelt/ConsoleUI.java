package Superhelt;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.Comparator;

public class ConsoleUI {
    private static Scanner scanner = new Scanner(System.in);
    private static Database database = new Database();
    private static Controller controller = new Controller(database);
    public static void consoleUi() {
        boolean fortsæt = true;
        while (fortsæt) {

            System.out.print("Velkommen Til superhelte universet");
            System.out.println("\nMENU: ");
            System.out.println("1: Opret en superhelt");
            System.out.println("2: Vis aktuelle superhelte");
            System.out.println("3: Søg efter en specefik superhelt");
            System.out.println("4: Rediger superhelt");
            System.out.println("5: sorter og vis superhelte");
            System.out.println("6: forlad menu");

            System.out.println("Vælg en valgmulighed: ");
            int menuValg = scanner.nextInt();

            scanner.nextLine();

            switch (menuValg) {
                case 1:
                    while (true) {
                        System.out.print("\nIndtast superheltenavn: ");
                        String navn = scanner.nextLine();

                        System.out.print("Er superhelten et menneske? (ja/nej): ");
                        boolean menneske = scanner.nextLine().equalsIgnoreCase("ja");

                        System.out.print("Hvilken superkraft har superhelten: ");
                        String superkraft = scanner.nextLine();
                        int fødselssår = 0;

                        while (true) {
                            System.out.print("Indtast fødselssår (fire cifre): ");
                            String input = scanner.nextLine();

                            if (input.length() == 4 && input.matches("\\d+")) {
                                fødselssår = Integer.parseInt(input);
                                break;
                            } else {
                                System.out.print("Ugyldigt input. ");
                            }

                        }
                        System.out.print("Hvor meget styrke har superhelten: ");
                        int styrke = Integer.parseInt(scanner.nextLine());
                        try {
                            database.gemSuperhelteTilFil();
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }

                        Superhelte superhelt = new Superhelte(navn, menneske, superkraft, fødselssår, styrke);

                        database.addSuperhelt(superhelt);

                        System.out.println("Vil du oprette en ny superhelt? (ja/nej): ");
                        String igen = scanner.nextLine();
                        if (!igen.equalsIgnoreCase("ja")) {
                            break;
                        }
                    }
                    break;
                case 2:
                    ArrayList<Superhelte> alleSuperhelte = controller.hentAlleSuperhelte();
                    for (Superhelte superhel : alleSuperhelte) {
                        System.out.println(superhel);
                    }
                    fortsæt = false;
                    break;
                case 3:
                    System.out.println("Søg efter hvilken helt du vil have frem");
                    String søgsuperhelt = scanner.nextLine();
                    ArrayList<Superhelte> foundHeroes = database.søgsuperhelt(søgsuperhelt);
                    if (foundHeroes.isEmpty()) {
                        System.out.println("No heroes with that name found.");
                    }
                    for (Superhelte a : foundHeroes) {
                        System.out.println(a);
                    }
                    break;
                case 4:
                    System.out.print("hvilken superhelt vil du redigere? indtast navn\n");
                    String name = scanner.nextLine();

                    System.out.print("Er superhelten et menneske? (ja/nej): \n");
                    boolean human = scanner.nextLine().equalsIgnoreCase("ja\n");

                    System.out.print("Hvilken superkraft har superhelten: ");
                    String power = scanner.nextLine();
                    int year = 0;

                    while (true) {
                        System.out.print("Indtast fødselssår (fire cifre): ");
                        String input = scanner.nextLine();

                        if (input.length() == 4 && input.matches("\\d+")) {
                            year = Integer.parseInt(input);

                            break;
                        } else {
                            System.out.print("Ugyldigt input. ");
                        }

                    }
                    System.out.print("Hvor meget styrke har superhelten: ");
                    int strength = Integer.parseInt(scanner.nextLine());
                    try {
                    database.gemSuperhelteTilFil();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                    Superhelte hero = new Superhelte(name, human, power, year, strength);
                    database.updateHero(hero);
                    break;

                case 5:
                    visSorteredeSuperhelte();
                    break;
                    case 6:
                    System.out.println("Forlader menu");
                        try {
                            database.gemSuperhelteTilFil();
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                        fortsæt = false;
                    scanner.close();
                    return;
            }
        }
    }


    private static void visSorteredeSuperhelte() {
        System.out.println("Vælg primær sortering (Navn/Styrke/Fødselsår): ");
        String primærSorteringValg = scanner.nextLine();

        System.out.println("Vælg sekundær sortering (Navn/Styrke/Fødselsår): ");
        String sekundærSorteringValg = scanner.nextLine();

        Sorteringsvalg primærSortering = mapSorteringsvalg(primærSorteringValg);
        Sorteringsvalg sekundærSortering = mapSorteringsvalg(sekundærSorteringValg);

        if (primærSortering != null && sekundærSortering != null) {
            SuperhelteComparator comparator = new SuperhelteComparator(primærSortering, sekundærSortering);
            ArrayList<Superhelte> foundHeroes = Controller.hentAlleSuperhelte();
            Collections.sort(foundHeroes, comparator);

            for (Superhelte superhelt : foundHeroes) {
                System.out.println(superhelt);
            }
        } else {
            System.out.println("Ugyldigt valg. Sortering annulleret.");
        }
    }

    private static Sorteringsvalg mapSorteringsvalg(String valg) {
        switch (valg.toUpperCase()) {
            case "NAVN":
                return Sorteringsvalg.NAVN;
            case "STYRKE":
                return Sorteringsvalg.STYRKE;
            case "FØDSELSÅR":
                return Sorteringsvalg.FØDSELSÅR;
            default:
                return null;
        }
    }
}






