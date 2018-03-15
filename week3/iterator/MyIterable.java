package iterator;

import java.util.Iterator;

/*
Deze interface maakt gebruik van een generic <T>; hierdoor kan hij alle datatypen bevatten: de
gebruiker van de klassen die deze interface implementeren geven bij het aanmaken hiervan de
concrete waarde van T mee.
 */

public interface MyIterable<T> extends Iterator<T> {

    public Iterator<T> iterator();
    public boolean hasNext();
    public T next();

}
