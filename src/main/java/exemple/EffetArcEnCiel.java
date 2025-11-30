package exemple;

import java.awt.Color;

import bandeau.Bandeau;

public class EffetArcEnCiel implements Effet {

    private final String message;
    private final int steps;
    private final int delayMillis;

    public EffetArcEnCiel(String message) {
        this(message, 50, 60);
    }

    public EffetArcEnCiel(String message, int steps, int delayMillis) {
        this.message = message;
        this.steps = steps;
        this.delayMillis = delayMillis;
    }

    @Override
    public void jouer(Bandeau b) {
        b.setMessage(message);
        Color orig = b.getForeground();
        for (int i = 0; i < steps; i++) {
            float hue = (float) i / steps;
            Color c = Color.getHSBColor(hue, 0.9f, 0.9f);
            b.setForeground(c);
            b.sleep(delayMillis);
        }
        b.setForeground(orig);
    }
}
