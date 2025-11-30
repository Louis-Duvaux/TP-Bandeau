package exemple;


import bandeau.Bandeau;

public class EffetRotation implements Effet {

    private final String message;
    private final int steps;
    private final int delayMillis;

    public EffetRotation(String message) {
        this(message, 36, 50);
    }

    public EffetRotation(String message, int steps, int delayMillis) {
        this.message = message;
        this.steps = steps;
        this.delayMillis = delayMillis;
    }

    @Override
    public void jouer(Bandeau b) {
        b.setMessage(message);
        for (int i = 0; i < steps; i++) {
            double angle = (2.0 * Math.PI * i) / steps;
            b.setRotation(angle);
            b.sleep(delayMillis);
        }
        b.setRotation(0.0);
    }
}
