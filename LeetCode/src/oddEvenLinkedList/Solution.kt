package oddEvenLinkedList

class Solution {
    fun oddEvenList(head: ListNode?): ListNode? {
        val evenHead : ListNode? = head?.next
        var odd: ListNode? = head
        var even: ListNode? = head?.next

        while(even?.next != null){
            odd?.next = odd?.next?.next
            even.next = even.next?.next

            odd = odd?.next
            even = even.next
        }

        odd?.next = evenHead
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
//    println(Solution().oddEvenList(ListNode(1, ListNode(2, ListNode(3, ListNode(4, ListNode(5)))))))
    println(Solution().oddEvenList(ListNode(1, ListNode(2, ListNode(3, ListNode(4, ListNode(5, ListNode(6))))))))
}