package exemple;


import bandeau.Bandeau;

public class EffetMarquee implements Effet {

    private final String message;
    private final int windowSize;
    private final int delayMillis;
    private final int repetitions;

    public EffetMarquee(String message) {
        this(message, 30, 60, 1);
    }

    public EffetMarquee(String message, int windowSize, int delayMillis, int repetitions) {
        this.message = message;
        this.windowSize = windowSize;
        this.delayMillis = delayMillis;
        this.repetitions = repetitions;
    }

    @Override
    public void jouer(Bandeau b) {
        String pad = "";
        for (int i = 0; i < windowSize; i++)
            pad += ' ';
        String src = pad + message + pad;

        for (int rep = 0; rep < repetitions; rep++) {
            for (int start = 0; start + windowSize <= src.length(); start++) {
                String part = src.substring(start, Math.min(start + windowSize, src.length()));
                b.setMessage(part);
                b.sleep(delayMillis);
            }
        }
    }
}
