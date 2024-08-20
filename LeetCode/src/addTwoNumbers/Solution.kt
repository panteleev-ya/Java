package addTwoNumbers

class Solution {
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        val head = ListNode(0)
        var current = head
        var left = l1
        var right = l2
        var overflow = 0

        while (left != null || right != null) {
            val sum = (left?.`val` ?: 0) + (right?.`val` ?: 0) + overflow
            overflow = sum / 10

            current.next = ListNode(sum % 10)
            current = current.next!!

            if (left != null) {
                left = left.next
            }
            if (right != null) {
                right = right.next
            }
        }
        if (overflow > 0) {
            current.next = ListNode(overflow)
        }

        return head.next
    }
}

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}