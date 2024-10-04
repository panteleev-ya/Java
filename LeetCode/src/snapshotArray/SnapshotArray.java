package snapshotArray;

import java.util.TreeMap;

public class SnapshotArray {
    private int snapId;
    private final TreeMap<Integer, Integer>[] historyRecords;

    public SnapshotArray(int length) {
        snapId = 0;
        historyRecords = new TreeMap[length];
        for (int i = 0; i < length; i++) {
            historyRecords[i] = new TreeMap<>();
            historyRecords[i].put(0, 0);
        }
    }

    public void set(int index, int val) {
        historyRecords[index].put(snapId, val);
    }

    public int snap() {
        return snapId++;
    }

    public int get(int index, int snapId) {
        return historyRecords[index].floorEntry(snapId).getValue();
    }
}
