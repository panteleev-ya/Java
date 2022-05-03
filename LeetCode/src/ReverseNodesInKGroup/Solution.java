package ReverseNodesInKGroup;

import java.util.ArrayDeque;
import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
//        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6))))));
//        ListNode head = new ListNode(1, new ListNode(2));
//        System.out.println(reverseKGroup(head, 2));
//        System.out.println(reverseKGroup(head, 2));
        System.out.println(reverseKGroup(head, 4));
    }

    public static ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null || k == 1) {
            return head;
        }
        ListNode node = head;
        ArrayDeque<ListNode> firstHalfOfGroup = new ArrayDeque<>();
        Stack<ListNode> secondHalfOfGroup = new Stack<>();
        while (node != null && node.next != null) {
            // Form first group for swaps
            ListNode start = node;
            for (int i = 0; i < k / 2; i++) {
                if (start == null) {
                    return head;
                }
                firstHalfOfGroup.addLast(start);
                if (start.next == null && i + 1 < k / 2) {
                    return head;
                }
                start = start.next;
            }

            // Form second group for swaps
            ListNode end = start;
            if (k % 2 == 1) {
                if (end == null || end.next == null) {
                    return head;
                }
                end = end.next;
            }
            for (int i = 0; i < k / 2; i++) {
                if (end == null) {
                    return head;
                }
                secondHalfOfGroup.add(end);
                if (end.next == null && i + 1 < k / 2) {
                    return head;
                }
                end = end.next;
            }

            // Set node to the next of k-Group
            node = end;

            // Do the swaps
            while (!firstHalfOfGroup.isEmpty() && !secondHalfOfGroup.isEmpty()) {
                start = firstHalfOfGroup.pollFirst();
                end = secondHalfOfGroup.pop();
                int tmp = start.val;
                start.val = end.val;
                end.val = tmp;
            }
            firstHalfOfGroup.clear();
            secondHalfOfGroup.clear();
        }
        return head;
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        @Override
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            ListNode node = this;
            while (node.next != null) {
                stringBuilder.append(node.val).append(" -> ");
                node = node.next;
            }
            stringBuilder.append(node.val);
            return stringBuilder.toString();
        }
    }
}
