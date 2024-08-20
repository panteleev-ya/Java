package mergeTwoSortedLists

class Solution {
    fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
        val head = ListNode(0)
        var left = list1
        var right = list2
        var current = head
        while (left != null && right != null) {
            if (left.`val` <= right.`val`) {
                current.next = ListNode(left.`val`)
                current = current.next!!
                left = left.next
            } else {
                current.next = ListNode(right.`val`)
                current = current.next!!
                right = right.next
            }
        }
        current.next = left ?: right
        return head.next
    }
}

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}