package LinkedListCycle;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {

    }

    public boolean hasCycle(ListNode head) {
        Set<ListNode> uniqueNodes = new HashSet<>();
        ListNode node = head;
        while (node != null && !uniqueNodes.contains(node)) {
            uniqueNodes.add(node);
            node = node.next;
        }
        return node != null;
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
