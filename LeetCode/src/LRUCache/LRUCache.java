package LRUCache;

import java.util.HashMap;

class LRUCache {
    private static class ListNode {
        int key;
        int value;
        ListNode previous;
        ListNode next;

        public ListNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private static class DoublyLinkedList {

        //Initially, head and tail is set to null
        ListNode head, tail = null;

        public ListNode updateAndMoveToFront(ListNode node, ListNode item) {

            if (node != head && node != tail) {
                // Было: prev <-> node <-> next
                // Стало: prev <-> next
                node.next.previous = node.previous;
                node.previous.next = node.next;
            } else if (node == head) {
                // Было: head <-> head.next
                // Стало: head.next
                if (head.next != null) {
                    head.next.previous = null;
                }
                head = head.next;
            } else { // node == tail
                // Было: tail.previous <-> tail
                // Стало: tail.previous
                tail = node.previous;
                tail.next = null;
            }

            return pushFront(item);
        }

        public int popBack() {
            int deletableKey = tail.key;
            // Было: tail.previous <-> tail
            // Стало: tail.previous
            if (head == tail) {
                head = tail = null;
            } else {
                tail.previous.next = null;
                tail = tail.previous;
            }
            return deletableKey;
        }

        public ListNode pushFront(ListNode item) {
            if (head == null || tail == null) {
                head = item;
                tail = item;
            } else {
                // Было: head <-> head.next
                // Стало: item <-> head <-> head.next
                head.previous = item;
                item.next = head;
                head = item;
            }

            return head;
        }
    }

    private final int capacity;
    private int size;
    private HashMap<Integer, ListNode> linkedListNodeMap;
    private DoublyLinkedList doublyLinkedList;

    public LRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        this.linkedListNodeMap = new HashMap<>(capacity);
        this.doublyLinkedList = new DoublyLinkedList();
    }

    public int get(int key) {
        ListNode getNode = this.linkedListNodeMap.get(key);
        if (getNode == null) {
            return -1;
        }
        ListNode newNodeSameData = doublyLinkedList.updateAndMoveToFront(getNode, getNode);
        this.linkedListNodeMap.put(key, newNodeSameData);
        return newNodeSameData.value;
    }

    public void put(int key, int value) {
        ListNode item = new ListNode(key, value);
        ListNode newNode;
        if (this.linkedListNodeMap.containsKey(key)) {
            ListNode node = this.linkedListNodeMap.get(key);
            newNode = doublyLinkedList.updateAndMoveToFront(node, item);
        } else {
            if (this.size >= this.capacity) {
                int deletedKey = this.doublyLinkedList.popBack();
                this.linkedListNodeMap.remove(deletedKey);
            } else {
                this.size += 1;
            }
            newNode = this.doublyLinkedList.pushFront(item);
        }
        this.linkedListNodeMap.put(key, newNode);
    }
}

