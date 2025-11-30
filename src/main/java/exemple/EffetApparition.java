package exemple;

import bandeau.Bandeau;

public class EffetApparition implements Effet {

    private final String message;
    private final int delayMillis;

    public EffetApparition(String message) {
        this(message, 120);
    }

    public EffetApparition(String message, int delayMillis) {
        this.message = message;
        this.delayMillis = delayMillis;
    }

    @Override
    public void jouer(Bandeau b) {
        StringBuilder current = new StringBuilder();
        for (int i = 0; i < message.length(); i++) {
            current.append(message.charAt(i));
            b.setMessage(current.toString());
            b.sleep(delayMillis);
        }
    }
}