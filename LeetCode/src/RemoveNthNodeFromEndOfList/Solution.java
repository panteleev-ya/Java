package RemoveNthNodeFromEndOfList;

public class Solution {

    public static void main(String[] args) {
//        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode head = new ListNode(1);
        int n = 1;
        head = removeNthFromEnd(head, n);
        System.out.println(head);
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return null;
        }
        IntegerPointer depth = new IntegerPointer(-1);
        removeNode(head, n, depth);
        if (depth.getValue() + 1 == n) {
            return head.next;
        }
        return head;
    }

    private static void removeNode(ListNode current, int n, IntegerPointer depth) {
        if (current.next != null) {
            removeNode(current.next, n, depth);
        }
        depth.setValue(depth.getValue() + 1);
        if (depth.getValue() == n) {
            current.next = current.next.next;
        }
    }
}
