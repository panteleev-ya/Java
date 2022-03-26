package LRUCache;

public class Solution {
    public static void main(String[] args) {
        LRUCache lRUCache = new LRUCache(1);
        lRUCache.put(2, 1);
        lRUCache.get(2);
        lRUCache.put(3, 2);
        lRUCache.get(2);
        lRUCache.get(3);
    }
}
