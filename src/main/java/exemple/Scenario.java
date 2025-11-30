package exemple;


import java.util.ArrayList;
import java.util.List;

public class Scenario {

    private static class Entree {
        final Effet effet;
        final int repetitions;

        Entree(Effet e, int r) {
            this.effet = e;
            this.repetitions = r;
        }
    }

    private final List<Entree> entrees = new ArrayList<>();

    public void ajouterEffet(Effet e, int repetitions) {
        if (repetitions < 1)
            throw new IllegalArgumentException("Le nombre de répétitions doit être >= 1");
        entrees.add(new Entree(e, repetitions));
    }

    public void jouer(bandeau.Bandeau b) {
        for (Entree ent : entrees) {
            for (int i = 0; i < ent.repetitions; i++) {
                ent.effet.jouer(b);
            }
        }
    }
}