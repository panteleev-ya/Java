package Day6;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5,
                new ListNode(6, new ListNode(7, new ListNode(8, new ListNode(9, new ListNode(10))))))))));
        int k = 3;
        System.out.println(Arrays.toString(new Solution().splitListToParts(listNode, k)));
    }

    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode[] listNodeParts = new ListNode[k];
        if (head == null) {
            return listNodeParts;
        }
        int listLength = 1;
        ListNode current = head;
        while (current.next != null) {
            listLength++;
            current = current.next;
        }
        int partLength = listLength / k;
        int overLengthPartsCount = listLength % k;

        current = head;
        for (int i = 0; i < k && current != null; i++) {
            int currentPartLength = partLength;
            if (overLengthPartsCount > 0) {
                currentPartLength++;
                overLengthPartsCount--;
            }
            ListNode listNodePartHead = new ListNode(current.val);
            current = current.next;
            ListNode listNodePart = listNodePartHead;
            for (int j = 1; j < currentPartLength && current != null; j++) {
                listNodePart.next = new ListNode(current.val);
                current = current.next;
                listNodePart = listNodePart.next;
            }
            listNodeParts[i] = listNodePartHead;
        }
        return listNodeParts;
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

        @Override
        public String toString() {
            if (next == null) {
                return val + "";
            }
            return val + "->" + next;
        }
    }
}
