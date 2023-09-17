package Superhelt;

import java.util.ArrayList;
import java.util.Scanner;

public class ConsoleUI {
    public static void consoleUi() {
        Scanner scanner = new Scanner(System.in);
        Database database = new Database();
        Controller controller = new Controller(database);
        boolean fortsæt = true;

        while (fortsæt) {

            System.out.print("Velkommen Til superhelte universet");
            System.out.println("\nMENU: ");
            System.out.println("1: Opret en superhelt");
            System.out.println("2: Vis aktuelle superhelte");
            System.out.println("3: Søg efter en specefik superhelt");
            System.out.println("4: Rediger superhelt");
            System.out.println("5: forlad menu");

            System.out.println("Vælg en valgmulighed: ");
            int menuValg = scanner.nextInt();

            scanner.nextLine();

            switch (menuValg) {
                case 1:
                    while( true) {
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
                    System.out.print("Which superhero u wanna edit??? type name\n");
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

                    Superhelte hero = new Superhelte(name, human, power, year, strength);
                    database.updateHero(hero);
                    break;
                case 5:
                    System.out.println("Forlader menu");
                    fortsæt = false;
                    scanner.close();
                    return;
            }
        }
    }
}
