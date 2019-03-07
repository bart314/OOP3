package iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

/*
Deze klasse maakt gebruik van een interne klasse waarin de zelfgemaakte implementatie van de Iterator<T>
wordt gegeven.
 */


public class NewStack<T> implements Iterable<T> {
    private final ArrayList<T> _data = new ArrayList<>();

    public void push(T o) {
        _data.add(o);
    }

    public T pop() {
        return _data.remove(_data.size() - 1);
    }

    public boolean isEmpty() {
        return _data.size() == 0;
    }

    @Override
    public Iterator<T> iterator() {
        return new NewStackIterator();
    }

    private class NewStackIterator implements Iterator<T> {
        private int cursor;

        public NewStackIterator() {
            this.cursor = 0;
        }

        public boolean hasNext() {
            return this.cursor < NewStack.this._data.size();
        }

        public T next() {
            if (this.hasNext()) {
                int current = cursor;
                cursor++;
                return NewStack.this._data.get(current);
            }
            throw new NoSuchElementException();
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}
