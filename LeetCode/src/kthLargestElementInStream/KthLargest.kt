package kthLargestElementInStream

import java.util.*

class KthLargest(var k: Int, nums: IntArray) {
    private var stream = ArrayList<Int>(nums.size)

    init {
        for (num in nums) {
            stream.add(num)
        }
        stream.sort()
    }

    fun add(`val`: Int): Int {
        val index = getIndex(`val`)
        // Add val to correct position
        stream.add(index, `val`)
        return stream[stream.size - k]
    }

    private fun getIndex(`val`: Int): Int {
        var left = 0
        var right = stream.size - 1
        while (left <= right) {
            val mid = (left + right) / 2
            val midElement = stream[mid]
            if (midElement == `val`) {
                return mid
            }
            if (midElement > `val`) {
                // Go to left half
                right = mid - 1
            } else {
                // Go to right half
                left = mid + 1
            }
        }
        return left
    }
}

fun main() {
    val a = KthLargest(3, intArrayOf(4, 5, 8, 2))
    println(a.add(3))
    println(a.add(5))
    println(a.add(10))
    println(a.add(9))
    println(a.add(4))
}