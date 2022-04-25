package Day25;

import java.util.ArrayList;
import java.util.Iterator;

class PeekingIterator implements Iterator<Integer> {
    ArrayList<Integer> data;
    int at;
    int size;
    public PeekingIterator(Iterator<Integer> iterator) {
        data = new ArrayList<>(1000);
        at = 0;
        while (iterator.hasNext()) {
            data.add(iterator.next());
        }
        size = data.size();
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        return data.get(at);
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        return data.get(at++);
    }

    @Override
    public boolean hasNext() {
        return at < size;
    }
}
