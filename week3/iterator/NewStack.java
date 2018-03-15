package iterator;

import java.util.ArrayList;
import java.util.Iterator;

/*
Deze klasse implementeert de interface MyIterable, waarbij gebruik gemaakt wordt van een generic <T>.
Deze <T> wordt doorgegeven aan de ArrayList die de interne waarden van de Stack bijhoudt. Uiteraard
komt dit T weer terug bij de push()- en de pop()-methoden, alsmede bij de verschillende iterator-
methoden.
 */


public class NewStack<T> implements MyIterable {
    private final ArrayList<T> _data = new ArrayList<>();

    public NewStack() {

    }

    public void push(T o) {
        _data.add(o);
    }

    public T pop() {
        return _data.remove(_data.size()-1);
    }

    public boolean isEmpty() {
        return !hasNext();
    }

    @Override
    public Iterator<T> iterator() {
        return _data.iterator();
    }

    @Override
    public boolean hasNext() {
        return _data.size()>0;
    }

    @Override
    public T next() {
        return pop();
    }
}
