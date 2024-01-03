package Day4;

public class Solution {
    public static void main(String[] args) {
        MyHashMap map = new MyHashMap();
        System.out.println(map.get(1)); // -1
        map.put(1, 1);
        System.out.println(map.get(1)); // 1
        map.put(1, 2);
        System.out.println(map.get(1)); // 2
        map.remove(1);
        System.out.println(map.get(1)); // -1
    }

    private static class MyHashMap {
        private final Node[] nodes;

        public MyHashMap() {
            nodes = new Node[10006];
        }

        public void put(int key, int value) {
            int index = getIndex(key);
            Node current = nodes[index];
            if (current == null) {
                Node item = new Node(key, value);
                nodes[index] = item;
                return;
            }

            Node previous = null;
            while (current != null && current.key != key) {
                previous = current;
                current = current.next;
            }

            if (current != null) {
                current.value = value;
                return;
            }

            previous.next = new Node(key, value);
        }

        public int get(int key) {
            int index = getIndex(key);
            Node current = nodes[index];
            while (current != null) {
                if (current.key == key) {
                    return current.value;
                }
                current = current.next;
            }
            return -1;
        }

        public void remove(int key) {
            int index = getIndex(key);
            if (nodes[index] == null) {
                return;
            }

            Node previous = null;
            Node current = nodes[index];
            while (current != null && current.key != key) {
                previous = current;
                current = current.next;
            }

            if (current == null) {
                return;
            }

            if (previous != null) {
                previous.next = current.next;
                return;
            }

            // Удаляется первый элемент
            nodes[index] = current.next;
        }

        private int getIndex(int key) {
            return key % nodes.length;
        }

        static class Node {
            private final int key;
            private int value;
            private Node next;

            public Node(int key, int value) {
                this.key = key;
                this.value = value;
            }
        }
    }
}
