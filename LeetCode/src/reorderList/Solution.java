package reorderList;

public class Solution {

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
        new Solution().reorderList(head);
        System.out.println("end");
    }

    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }

        // finding second half with slow and fast pointers
        // second half will start with `slow.next`
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode secondHalf = slow.next; // saving start of second half
        slow.next = null; // disconnect first and second halves

        // reversing second half, now it points to the end of it and links are reversed
        secondHalf = reverseLinkedList(secondHalf);

        ListNode firstHalf = head;
        while (secondHalf != null) {
            ListNode firstHalfNext = firstHalf.next;
            ListNode secondHalfNext = secondHalf.next;

            firstHalf.next = secondHalf;
            secondHalf.next = firstHalfNext;

            firstHalf = firstHalfNext;
            secondHalf = secondHalfNext;
        }
    }

    private ListNode reverseLinkedList(ListNode head) {
        ListNode prev = null;
        ListNode current = head;

        while (current != null) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        return prev;
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
