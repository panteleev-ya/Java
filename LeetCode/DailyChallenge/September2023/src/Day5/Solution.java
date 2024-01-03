package Day5;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        Node node1 = new Node(7);
        Node node2 = new Node(13);
        Node node3 = new Node(11);
        Node node4 = new Node(10);
        Node node5 = new Node(1);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        node1.random = null;
        node2.random = node1;
        node3.random = node5;
        node4.random = node3;
        node5.random = node1;

        System.out.println(new Solution().copyRandomList(node1));
    }

    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }

        Map<Node, Node> oldToNew = new HashMap<>();

        Node current = head;
        while (current != null) {
            oldToNew.put(current, new Node(current.val));
            current = current.next;
        }

        current = head;
        while (current != null) {
            Node newCurrent = oldToNew.get(current);
            Node newCurrentNext = oldToNew.get(current.next);
            Node newCurrentRandom = oldToNew.get(current.random);
            newCurrent.next = newCurrentNext;
            newCurrent.random = newCurrentRandom;
            current = current.next;
        }

        return oldToNew.get(head);
    }

    private static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}
