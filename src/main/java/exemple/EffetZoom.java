package exemple;

import java.awt.Font;

import bandeau.Bandeau;

public class EffetZoom implements Effet {

    private final String message;
    private final int minSize;
    private final int maxSize;
    private final int step;
    private final int delayMillis;

    public EffetZoom(String message) {
        this(message, 10, 60, 2, 50);
    }

    public EffetZoom(String message, int minSize, int maxSize, int step, int delayMillis) {
        this.message = message;
        this.minSize = minSize;
        this.maxSize = maxSize;
        this.step = step;
        this.delayMillis = delayMillis;
    }

    @Override
    public void jouer(Bandeau b) {
        Font original = b.getFont();
        b.setMessage(message);
        for (int size = minSize; size <= maxSize; size += step) {
            b.setFont(new Font(original.getName(), original.getStyle(), size));
            b.sleep(delayMillis);
        }
        for (int size = maxSize; size >= minSize; size -= step) {
            b.setFont(new Font(original.getName(), original.getStyle(), size));
            b.sleep(delayMillis);
        }
        b.setFont(original);
    }
}
