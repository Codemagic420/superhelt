package Superhelt;

import java.util.Comparator;


public class SuperhelteComparator implements Comparator<Superhelte> {
    private Sorteringsvalg sorteringsvalg;
    private Sorteringsvalg primærSortering;
    private Sorteringsvalg sekundærSortering;

    public SuperhelteComparator(Sorteringsvalg primærSortering, Sorteringsvalg sekundærSortering) {
        this.primærSortering = primærSortering;
        this.sekundærSortering = sekundærSortering;
        sorteringsvalg = Sorteringsvalg.NAVN; // Korrekt initialisering her
    }

    @Override
    public int compare(Superhelte a, Superhelte b) {
        int primærSammenligning = sammenlign(a, b, primærSortering);
        if (primærSammenligning != 0) {
            return primærSammenligning;
        } else {
            return sammenlign(a, b, sekundærSortering);
        }
    }

    private int sammenlign(Superhelte a, Superhelte b, Sorteringsvalg sorteringsvalg) {
        switch (sorteringsvalg) {
            case NAVN:
                return a.getSuperheroName().compareTo(b.getSuperheroName());
            case STYRKE:
                return Integer.compare(a.getStyrke(), b.getStyrke());
            case FØDSELSÅR:
                return Integer.compare(a.getCreationYear(), b.getCreationYear());

            default:
                return 0; //
        }
    }

    public void setSorteringsvalg(Sorteringsvalg sorteringsvalg) {
        this.sorteringsvalg = sorteringsvalg;
    }
}

