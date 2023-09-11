package Day22;

public class MyHashMap {
    private static final int initialCapacity = 1000;
    private ListNode[] array;
    private final int capacity;
    public MyHashMap() {
        array = new ListNode[initialCapacity];
        capacity = initialCapacity;
    }

    public void put(int key, int value) {
        int hashKey = hashFunction(key);
        if (array[hashKey] == null) {
            // If list is empty -> create list
            array[hashKey] = new ListNode(key, value);
        } else {
            if (array[hashKey].key == key) {
                // If head of the list contains key -> update value
                array[hashKey].val = value;
            } else {
                // Looking for node, that node.next.key == key
                ListNode prevNode = nextNodeWithKey(array[hashKey], key);
                if (prevNode.next == null) {
                    // If this node doesn't exist (node.next == null) -> we create new one in front of the list with (key, value)
                    // (root -> ...) => (value -> root -> ...)
                    array[hashKey] = new ListNode(key, value, array[hashKey]);
                } else {
                    // If this node exists (node.next.key == key) -> update node.next.value to value
                    prevNode.next.val = value;
                }
            }
        }
    }

    public int get(int key) {
        int hashKey = hashFunction(key);
        // If list not empty
        if (array[hashKey] != null) {
            ListNode node = nodeWithKey(array[hashKey], key);
            // If node with key exists
            if (node != null) {
                return node.val;
            }
        }
        return -1;
    }

    public void remove(int key) {
        int hashKey = hashFunction(key);
        // If list not empty
        if (array[hashKey] != null) {
            if (array[hashKey].key == key) {
                // If head of the list contains key -> remove head
                array[hashKey] = array[hashKey].next;
            } else {
                // Looking for node, that node.next.key == key
                ListNode prevNode = nextNodeWithKey(array[hashKey], key);
                // If this node exists (node.next.key == key) -> remove node.next
                if (prevNode.next != null) {
                    prevNode.next = prevNode.next.next;
                }
            }
        }
    }

    private ListNode nodeWithKey(ListNode root, int key) {
        if (root.key == key) {
            return root;
        } else {
            return nextNodeWithKey(root, key).next;
        }
    }
    private ListNode nextNodeWithKey(ListNode root, int key) {
        ListNode current = root;
        while (current.next != null && current.next.key != key) {
            current = current.next;
        }
        return current;
    }

    private int hashFunction(int key) {
        return key % capacity;
    }

    private static class ListNode {
        int key;
        int val;
        ListNode next;
        ListNode(int key, int val) {
            this(key, val, null);
        }
        ListNode(int key, int val, ListNode next) {
            this.key = key;
            this.val = val;
            this.next = next;
        }
    }
}
