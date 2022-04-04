package Day4;

public class Solution {
    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode swap = swapNodes(head, 2);
        System.out.println(swap);
    }
    public static ListNode swapNodes(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }

        int maxDepth = 0;
        ListNode current = head;
        while (current != null) {
            maxDepth++;
            current = current.next;
        }

        ListNode left = head;
        ListNode right = head;
        for (int i = 0; i < k - 1 && left.next != null; i++) {
            left = left.next;
        }
        for (int i = 0; i < maxDepth - k && right.next != null; i++) {
            right = right.next;
        }

        int tmp = left.val;
        left.val = right.val;
        right.val = tmp;
        return head;
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
