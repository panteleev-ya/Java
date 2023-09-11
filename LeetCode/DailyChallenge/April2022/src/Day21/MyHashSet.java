package Day21;

class MyHashSet {
    private static final int initialCapacity = 1000;
    private ListNode[] array;
    private final int capacity;
    public MyHashSet() {
        array = new ListNode[initialCapacity];
        capacity = initialCapacity;
    }

    public void add(int key) {
        int hashKey = hashFunction(key);
        ListNode node = array[hashKey];
        if (node == null) {
            array[hashKey] = new ListNode(key);
        } else {
            array[hashKey] = addOrSkipValue(node, key);
        }
    }

    public void remove(int key) {
        int hashKey = hashFunction(key);
        ListNode node = array[hashKey];
        if (node != null) {
            if (node.val == key) {
                array[hashKey] = node.next;
            } else {
                removeValue(node, key);
            }
        }
    }

    public boolean contains(int key) {
        int hashKey = hashFunction(key);
        ListNode node = array[hashKey];
        if (node == null) {
            return false;
        } else {
            if (node.val == key) {
                return true;
            }
            ListNode prev = findPrevByValue(node, key);
            return prev.next != null;
        }
    }

    private int hashFunction(int key) {
        return key % capacity;
    }
    private ListNode addOrSkipValue(ListNode root, int value) {
        if (root.val > value) {
            // value -> root -> root.next
            return new ListNode(value, root);
        }
        if (root.val == value) {
            return root;
        }

        ListNode current = root;
        while (current.next != null && current.next.val < value) {
            current = current.next;
        }
        if (current.next != null && current.next.val == value) {
            return root;
        }

        // current -> newNode -> current.next
        current.next = new ListNode(value, current.next);
        return root;
    }

    private void removeValue(ListNode root, int value) {
        ListNode prev = findPrevByValue(root, value);
        if (prev.next != null) {
            prev.next = prev.next.next;
        }
    }

    private ListNode findPrevByValue(ListNode root, int value) {
        ListNode current = root;
        while (current.next != null && current.next.val != value) {
            current = current.next;
        }
        return current;
    }

    private static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) {
            this.val = val;
        }
        ListNode(int val, ListNode next) {
            this.val = val; this.next = next;
        }
    }
}
