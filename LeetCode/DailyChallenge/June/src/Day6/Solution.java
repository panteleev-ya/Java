package Day6;

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // Getting length of listA
        int lengthA = 0;
        ListNode listA = headA;
        while (listA != null) {
            lengthA++;
            listA = listA.next;
        }

        // Getting length of listB
        int lengthB = 0;
        ListNode listB = headB;
        while (listB != null) {
            lengthB++;
            listB = listB.next;
        }
        listA = headA;
        listB = headB;

        while (lengthA > lengthB) {
            listA = listA.next;
            lengthA--;
        }

        while (lengthB > lengthA) {
            listB = listB.next;
            lengthB--;
        }

        while (listA != listB) {
            listA = listA.next;
            listB = listB.next;
        }

        return listA;
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
