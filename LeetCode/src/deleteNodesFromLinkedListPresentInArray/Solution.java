package deleteNodesFromLinkedListPresentInArray;

import java.util.HashSet;
import java.util.Set;

public class Solution {
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

    public ListNode modifiedList(int[] nums, ListNode head) {
        Set<Integer> numsSet = new HashSet<>();
        for (int num : nums) {
            numsSet.add(num);
        }
        while (numsSet.contains(head.val)) {
            head = head.next;
        }
        ListNode current = head;
        while (current != null) {
            while (current.next != null && numsSet.contains(current.next.val)) {
                current.next = current.next.next;
            }
            current = current.next;
        }
        return head;
    }
}
