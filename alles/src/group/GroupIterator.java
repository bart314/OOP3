package group;

import java.util.Iterator;
import java.util.List;

public class GroupIterator<T> implements Iterator<T> {
    private int cursor;
    private final List<T> data;

    public GroupIterator(List<T> data) {
        this.data = data;
        this.cursor = -1;
    }

    @Override
    public boolean hasNext() {
        return this.data.size() > this.cursor;
    }

    @Override
    public T next() {
        if (this.hasNext()) {
            this.cursor++;
            return this.data.get(this.cursor);
        } else {
            throw new ArrayIndexOutOfBoundsException("No more bananas...");
        }
    }

}
