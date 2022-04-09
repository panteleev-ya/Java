package RemoveDuplicatesFromSortedList;

import java.util.ArrayDeque;

public class Solution {
    public static void main(String[] args) {

    }
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }

        // Заполняем ими nums, возвращаем их количество
        ListNode uniqueNodes = new ListNode(head.val);
        for (ListNode currentUnique = uniqueNodes, currentHead = head.next;
             currentHead != null;
             currentHead = currentHead.next) {
            if (currentUnique.val != currentHead.val) {
                currentUnique.next = new ListNode(currentHead.val);
                currentUnique = currentUnique.next;
            }
        }

        return uniqueNodes;
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
