package reverseLinkedList;

public class Solution {
    public ListNode reverseList(ListNode head) {
        // 1->2->3->4->5
        // save next to var:
        //  2->3->4->5
        // link current's next to previous:
        //  1->null
        // move 1 step (prev = curr; curr = next)
        //  1->null
        //  2->3->4->5
        // repeat

        ListNode previous = null;
        ListNode current = head;

        while (current != null) {
            ListNode next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }

        return previous;
    }

    public static class ListNode {
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