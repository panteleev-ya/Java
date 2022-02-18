package MergeTwoSortedLists;

public class Solution {
    public static void main(String[] args) {

    }
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // Если один (или оба) из списков пустой - возвращаем другой
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }

        // Задаем корень нового списка
        ListNode mergedList;
        if (list1.val < list2.val) {
            mergedList = new ListNode(list1.val);
            list1 = list1.next;
        } else {
            mergedList = new ListNode(list2.val);
            list2 = list2.next;
        }

        ListNode ptr = mergedList;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                ptr.next = new ListNode(list1.val);
                list1 = list1.next;
            } else {
                ptr.next = new ListNode(list2.val);
                list2 = list2.next;
            }
            ptr = ptr.next;
        }

        // Если длина списков не одинаковая
        while (list1 != null) {
            ptr.next = new ListNode(list1.val);
            list1 = list1.next;
            ptr = ptr.next;
        }
        while (list2 != null) {
            ptr.next = new ListNode(list2.val);
            list2 = list2.next;
            ptr = ptr.next;
        }
        return mergedList;
    }
}

