package lruCache;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    private static class ListNode {
        int key;
        int val;
        ListNode next;
        ListNode prev;

        public ListNode(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    private final int capacity;
    private final Map<Integer, ListNode> nodesMap;
    private final ListNode head;
    private final ListNode tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.nodesMap = new HashMap<>();
        head = new ListNode(-1, -1);
        tail = new ListNode(-1, -1);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        ListNode node = nodesMap.get(key);
        if (node == null) {
            return -1;
        }

        // put current node to the end of doubly-linked list
        // to mark it as most recently used
        removeNode(node);
        addNode(node);

        return node.val;
    }

    public void put(int key, int value) {
        if (nodesMap.containsKey(key)) {
            removeNode(nodesMap.get(key)); // remove node with previous value
        }

        ListNode node = new ListNode(key, value);

        nodesMap.put(key, node);
        addNode(node);

        if (nodesMap.size() > capacity) {
            ListNode lru = head.next;
            removeNode(lru);
            nodesMap.remove(lru.key);
        }
    }

    private void addNode(ListNode node) {
        ListNode previousEnd = tail.prev;

        previousEnd.next = node;
        node.prev = previousEnd;

        node.next = tail;
        tail.prev = node;
    }

    private void removeNode(ListNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
}
