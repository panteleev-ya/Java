package Day7;

public class Solution {
    public static void main(String[] args) {

    }

    static class ListNode {
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

    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode reversed = new ListNode(0);
        ListNode prev = reversed;
        ListNode current;
        reversed.next = head;
        for (int i = 0; i < left - 1; i++) {
            prev = prev.next;
        }
        current = prev.next;
        for (int i = 0; i < right - left; i++) {
            ListNode temp = prev.next;
            prev.next = current.next;
            current.next = current.next.next;
            prev.next.next = temp;
        }
        return reversed.next;
    }
}
