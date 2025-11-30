package exemple;


import java.awt.Color;

import bandeau.Bandeau;

public class EffetClignotant implements Effet {

    private final String message;
    private final int flashCount;
    private final int delayMillis;

    public EffetClignotant(String message) {
        this(message, 6, 200);
    }

    public EffetClignotant(String message, int flashCount, int delayMillis) {
        this.message = message;
        this.flashCount = flashCount;
        this.delayMillis = delayMillis;
    }

    @Override
    public void jouer(Bandeau b) {
        Color orig = b.getForeground();
        for (int i = 0; i < flashCount; i++) {
            b.setForeground(Color.BLACK);
            b.setMessage("");
            b.sleep(delayMillis);
            b.setForeground(Color.RED);
            b.setMessage(message);
            b.sleep(delayMillis);
        }
        b.setForeground(orig);
    }
}
