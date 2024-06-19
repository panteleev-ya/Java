package maximumTwinSumLinkedList

import java.util.*
import kotlin.math.max

class Solution {
    fun pairSum(head: ListNode?): Int {
        val stack = Stack<Int>()
        var current = head
        while (current != null) {
            stack.add(current.`val`)
            current = current.next
        }
        current = head
        var maxSum = 0
        while (stack.isNotEmpty()) {
            maxSum = max(maxSum, current!!.`val` + stack.pop())
            current = current.next
        }
        return maxSum
    }
}

class ListNode(var `val`: Int) {
    var next: ListNode? = null

    constructor(`val`: Int, next: ListNode) : this(`val`) {
        this.next = next
    }
}

fun main() {
    println(Solution().pairSum(ListNode(4, ListNode(2, ListNode(2, ListNode(3))))))
}