package Day8;

import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;

public class NestedIterator implements Iterator<Integer> {
    Queue<Integer> data;
    public NestedIterator(List<NestedInteger> nestedList) {
        data = new ArrayDeque<>();
        fillData(nestedList);
    }

    private void fillData(List<NestedInteger> nestedList) {
        for (NestedInteger i: nestedList) {
            if (i.isInteger()) {
                data.add(i.getInteger());
            } else {
                fillData(i.getList());
            }
        }
    }

    @Override
    public Integer next() {
        return data.poll();
    }

    @Override
    public boolean hasNext() {
        return !data.isEmpty();
    }
}
