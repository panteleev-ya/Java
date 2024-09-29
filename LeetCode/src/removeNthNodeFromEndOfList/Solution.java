package removeNthNodeFromEndOfList;

public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return null;
        }
        ListNode preHead = new ListNode(-1, head);
        ListNode left = preHead;
        ListNode right = preHead;
        while (n > 0) {
            right = right.next;
            n--;
        }

        while (right.next != null) {
            left = left.next;
            right = right.next;
        }

        left.next = left.next.next;

        return preHead.next;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }

        ListNode(int x, ListNode nxt) {
            val = x;
            next = nxt;
        }
    }
}
