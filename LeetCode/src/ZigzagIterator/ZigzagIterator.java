package ZigzagIterator;

import java.util.ArrayList;
import java.util.List;

public class ZigzagIterator {
    ArrayList<Integer> v1;
    ArrayList<Integer> v2;
    int v1Ptr, v2Ptr;
    boolean useFirst;

    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        this.v1 = new ArrayList<>(v1);
        this.v2 = new ArrayList<>(v2);
        v1Ptr = 0;
        v2Ptr = 0;
        useFirst = true;
    }
    public int next() {
        if (useFirst && v1Ptr < v1.size() || v2Ptr >= v2.size()) {
            useFirst = false;
            return v1.get(v1Ptr++);
        } else {
            useFirst = true;
            return v2.get(v2Ptr++);
        }
    }

    public boolean hasNext() {
        return v1Ptr < v1.size() || v2Ptr < v2.size();
    }
}
