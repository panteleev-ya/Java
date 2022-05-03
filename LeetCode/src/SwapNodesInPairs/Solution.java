package SwapNodesInPairs;

public class Solution {
    public static void main(String[] args) {

    }

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode current = head;
        ListNode currentNext = current.next;
        while (true) {
            int tmp = current.val;
            current.val = currentNext.val;
            currentNext.val = tmp;
            if (currentNext.next != null && currentNext.next.next != null) {
                current = currentNext.next;
                currentNext = current.next;
            } else {
                break;
            }
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
    }
}
