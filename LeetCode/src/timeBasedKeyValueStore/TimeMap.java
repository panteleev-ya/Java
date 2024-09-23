package timeBasedKeyValueStore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TimeMap {
    private final Map<String, List<TimedValue>> map;

    public TimeMap() {
        map = new HashMap<>();
    }

    // Stores the key `key` with the value `value` at the given time `timestamp`.
    public void set(String key, String value, int timestamp) {
        List<TimedValue> values = map.getOrDefault(key, new ArrayList<>());
        int index = binarySearchForIndex(values, timestamp);
        values.add(index, new TimedValue(timestamp, value));
        map.put(key, values);
    }

    // Returns the most recent value associated with key `key` before timestamp `timestamp`
    public String get(String key, int timestamp) {
        List<TimedValue> values = map.getOrDefault(key, new ArrayList<>());
        int index = binarySearchForIndex(values, timestamp);
        if (index >= values.size()) {
            return "";
        }
        return values.get(index).value;
    }

    private int binarySearchForIndex(List<TimedValue> values, int timestamp) {
        int left = 0;
        int right = values.size() - 1;
        if (values.isEmpty() || timestamp < values.get(right).timestamp) {
            return right + 1;
        }

        while (left < right) {
            int middle = (left + right) / 2;
            if (timestamp < values.get(middle).timestamp) {
                left = middle + 1;
            } else {
                right = middle;
            }
        }

        return left;
    }

    private static class TimedValue {
        int timestamp;
        String value;

        public TimedValue(int timestamp, String value) {
            this.timestamp = timestamp;
            this.value = value;
        }
    }
}
