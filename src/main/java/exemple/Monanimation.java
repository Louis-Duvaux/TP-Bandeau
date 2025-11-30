package exemple;

import java.awt.Color;
import java.awt.Font;

import bandeau.Bandeau;

public class Monanimation {

    public static void main(String[] args) {
        Bandeau bandeau = new Bandeau();

        Font originalFont = bandeau.getFont();
        Color originalBack = bandeau.getBackground();
        Color originalFore = bandeau.getForeground();

        Scenario scenario = new Scenario();

        scenario.ajouterEffet(new EffetTeletype("Bienvenue sur le Bandeau!"), 1);
        scenario.ajouterEffet(new EffetClignotant("Clignote..."), 2);
        scenario.ajouterEffet(new EffetZoom("Zoom..."), 2);
        scenario.ajouterEffet(new EffetRotation("On Tourne..."), 1);
        scenario.ajouterEffet(new EffetPendu("Pendu demo"), 1);
        scenario.ajouterEffet(new EffetArcEnCiel("Arc-en-ciel!"), 1);
        scenario.ajouterEffet(new EffetMarquee(">>> Ceci est un test de marquee <<<"), 2);
        scenario.ajouterEffet(new EffetApparition("Terminé."), 1);

        scenario.jouer(bandeau);

        bandeau.setFont(originalFont);
        bandeau.setBackground(originalBack);
        bandeau.setForeground(originalFore);
        bandeau.sleep(1000);
        bandeau.close();
    }
}
