package iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/*
Deze klasse maakt gebruik van een interne klasse waarin de zelfgemaakte implementatie van de Iterator<T>
wordt gegeven.
 */


public class NewStack<T> implements Iterable<T> {
    private final List<T> data = new ArrayList<>();

    public void push(T o) {
        data.add(o);
    }

    public T pop() {
        return data.remove(data.size() - 1);
    }

    public boolean isEmpty() {
        return data.size() == 0;
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
            return this.cursor < NewStack.this.data.size();
        }

        public T next() {
            if (this.hasNext()) {
                return NewStack.this.data.get(cursor++);
            }
            throw new NoSuchElementException();
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}
