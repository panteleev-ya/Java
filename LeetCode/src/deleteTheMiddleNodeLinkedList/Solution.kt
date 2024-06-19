package deleteTheMiddleNodeLinkedList

class Solution {
    fun deleteMiddle(head: ListNode?): ListNode? {
        if (head?.next == null) {
            return null
        }

        var slow = head
        var fast = head.next!!.next

        // While slow moves by 1, fast moves by 2, so slow.next is always between start and fast
        // That means when fast will reach end, slow will reach middle
        while (fast?.next != null) {
            slow = slow?.next
            fast = fast.next?.next
        }
        slow?.next = slow?.next?.next
        return head
    }
}

class ListNode(var `val`: Int) {
    var next: ListNode? = null

    constructor(`val`: Int, next: ListNode?) : this(`val`) {
        this.next = next
    }
}

fun main() {
    // 1,3,4,7,1,2,6
//    val head = ListNode(1, ListNode(3, ListNode(4, ListNode(7, ListNode(1, ListNode(2, ListNode(6)))))))
//    println(Solution().deleteMiddle(head))
//    println(Solution().deleteMiddle(ListNode(1)))
    println(Solution().deleteMiddle(ListNode(1, ListNode(2))))
//    println(Solution().deleteMiddle(ListNode(1, ListNode(2, ListNode(3)))))
}