package generics;

/*
Deze klasse demonstreert de werking met meer dan één generic. Hij doet een beetje denken aan de
HashMap<String, Integer> of iets dergelijks. Bestudeer het commentaar en de code bij de klasse
SimpleKrat voor meer informatie hierover.
 */

public class BetterKrat<T, U> {
    private T kratinhoud;
    private U maxSize;

    public BetterKrat(T contents, U maxSize) {
        this.kratinhoud = contents;
        this.maxSize = maxSize;
    }

    public T leeg() {
        return this.kratinhoud;
    }

    public void vullen(T t) {
        kratinhoud = t;
    }

    public U getMaxSize() { return this.maxSize; }
    public void setMaxSize(U value) { this.maxSize = value; }
}
