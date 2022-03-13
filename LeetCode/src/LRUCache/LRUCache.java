package LRUCache;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class LRUCache {
    private HashMap<Integer, Integer> data;
    // private HashMap<Integer, Integer> usages = new HashMap<>();
    private ArrayList<Integer> calls = new ArrayList<>(20_000);
    private final int capacity;
    private int size = 0;
    // private int timer = 0;
    private int LRU = 0;

    public LRUCache(int capacity) {
        this.data = new HashMap<>(capacity);
        this.capacity = capacity;
    }

    public int get(int key) {
        if (data.containsKey(key)) {
            // usages.replace(key, ++timer); // потрогали

            // Записываем действие в ленту
            calls.add(key);
            return data.get(key);
        }
        return -1;
    }

    public void put(int key, int value) {
        // Обновить существующий
        if (data.containsKey(key)) {
            updateValue(key, value);
            return;
        }

        // Удалить неиспользуемый
        if (size >= capacity) {
            deleteLRU(key, value);
        }

        // Добавить новый
        addNewValue(key, value);
    }
    private void updateValue(int key, int value) {
        data.replace(key, value);
        // usages.replace(key, ++timer);

        // Записываем действие в ленту
        calls.add(key);

        // Если сейчас LRU считается то, что мы обновляем - двигаем указатель LRU
        if (calls.get(LRU) == key) {
            LRU++;
        }
    }
    private void deleteLRU(int key, int value) {

        return;
//            int leastUsedCount = timer + 1; // остальные точно меньше, чем это
//            int leastUsedKey = 0;
//
//            // Ищем неиспользуемый ключ
//
//            int currentCount;
//            for (var dataKey : usages.keySet()) {
//                currentCount = usages.get(dataKey);
//                if (leastUsedCount > currentCount) {
//                    leastUsedKey = dataKey;
//                    leastUsedCount = currentCount;
//                }
//            }
//
//            // Удаляем неиспользуемый ключ
//            data.remove(leastUsedKey);
//            usages.remove(leastUsedKey);
    }
    private void addNewValue(int key, int value) {
        data.put(key, value);
        size++;
        // usages.put(key, ++timer); // новый ключ

        // Записываем действие в ленту
        calls.add(key);
    }
}
