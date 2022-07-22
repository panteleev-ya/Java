package Day22;

public class Solution {
    public static void main(String[] args) {

    }

    public ListNode partition(ListNode head, int x) {
        ListNode before = new ListNode(0);
        ListNode after = new ListNode(0);
        ListNode endOfBefore = before;
        ListNode endOfAfter = after;

        while (head != null) {
            if (head.val < x) {
                endOfBefore.next = new ListNode(head.val);
                endOfBefore = endOfBefore.next;
            } else {
                endOfAfter.next = new ListNode(head.val);
                endOfAfter = endOfAfter.next;
            }
            head = head.next;
        }

        endOfBefore.next = after.next;

        return before.next;
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
    }
}
