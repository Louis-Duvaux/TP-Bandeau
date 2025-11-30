package exemple;


import bandeau.Bandeau;

public class EffetPendu implements Effet {

    private final String message;
    private final int delayMillis;
    private final boolean randomReveal;

    public EffetPendu(String message) {
        this(message, 150, false);
    }

    public EffetPendu(String message, int delayMillis, boolean randomReveal) {
        this.message = message;
        this.delayMillis = delayMillis;
        this.randomReveal = randomReveal;
    }

    @Override
    public void jouer(Bandeau b) {
        b.setMessage(formattedWithUnderscores());
        b.sleep(delayMillis);

        int length = message.length();
        int[] order = new int[length];
        for (int i = 0; i < length; i++)
            order[i] = i;

        if (randomReveal) {
            // shuffle order
            for (int i = length - 1; i > 0; i--) {
                int j = (int) (Math.random() * (i + 1));
                int tmp = order[i];
                order[i] = order[j];
                order[j] = tmp;
            }
        }

        StringBuilder current = new StringBuilder(formattedWithUnderscores());
        for (int idx : order) {
            char c = message.charAt(idx);
            if (c == ' ') {
                // keep spaces
                current.setCharAt(idx, ' ');
            } else {
                current.setCharAt(idx, c);
            }
            b.setMessage(current.toString());
            b.sleep(delayMillis);
        }
    }

    private String formattedWithUnderscores() {
        StringBuilder out = new StringBuilder();
        for (char c : message.toCharArray()) {
            if (Character.isWhitespace(c))
                out.append(' ');
            else
                out.append('_');
        }
        return out.toString();
    }
}
