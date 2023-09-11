package Day21;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().reverseBetween(
                new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5))))), 2, 4
        ));
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
