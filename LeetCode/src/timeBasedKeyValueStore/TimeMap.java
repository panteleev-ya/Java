package timeBasedKeyValueStore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TimeMap {
    private final Map<String, List<Pair<Integer, String>>> storage;

    public TimeMap() {
        storage = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        if (!storage.containsKey(key)) {
            storage.put(key, new ArrayList<>());
        }
        storage.get(key).add(new Pair<>(timestamp, value));
    }

    public String get(String key, int timestamp) {
        if (!storage.containsKey(key)) {
            return "";
        }
        List<Pair<Integer, String>> bucket = storage.get(key);

        // looking for a timestamp `t` where `t` <= `timestamp` and `t` is maximized
        Pair<Integer, String> earliestPair = bucket.get(0);
        if (earliestPair.getKey() > timestamp) {
            return "";
        }

        int left = 0;
        int right = bucket.size() - 1;
        while (left < right) {
            int middle = (left + right + 1) / 2;
            int t = bucket.get(middle).getKey();
            if (t > timestamp) {
                right = middle - 1; // middle doesn't meet requirements
            } else {
                left = middle; // could be the maximum
            }
        }

        return bucket.get(left).getValue();
    }

    private static class Pair<K, V> {
        K key;
        V value;

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
    }
}
