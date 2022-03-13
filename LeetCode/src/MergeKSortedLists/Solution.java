package MergeKSortedLists;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {
    public static void main(String[] args) {
//        ListNode[] lists = {};
//        ListNode[] lists = {null};
        ListNode[] lists = {
                new ListNode(1, new ListNode(4, new ListNode(5))),
                new ListNode(1, new ListNode(3, new ListNode(4))),
                new ListNode(2, new ListNode(6))
        };
        mergeKLists(lists);
        System.out.println("Done!");
    }
    public static ListNode mergeKLists(ListNode[] lists) {
        if (lists == null) {
            return null;
        }

        PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>(11, Comparator.comparingInt(ln -> ln.val));
        for (var list: lists) {
            if (list != null) {
                priorityQueue.add(list);
            }
        }

        ListNode current;
        ListNode result = new ListNode(-1);
        ListNode resultCurrent = result;
        while (!priorityQueue.isEmpty()) {
            current = priorityQueue.poll();
            resultCurrent.next = new ListNode(current.val);
            resultCurrent = resultCurrent.next;
            current = current.next;

            if (current != null) {
                priorityQueue.add(current);
            }
        }
        return result.next;
    }
}
