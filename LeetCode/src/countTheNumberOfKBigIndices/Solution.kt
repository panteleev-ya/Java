package countTheNumberOfKBigIndices

import java.util.*
import kotlin.Comparator

class Solution {
    fun kBigIndices(nums: IntArray, k: Int): Int {
        if (nums.size < k || k == 0) return 0

        // Create and add the initial needed values to both heaps
        val maxHeap1 = PriorityQueue<Int>(k, Comparator.reverseOrder()).apply { addAll(nums.take(k)) }
        val maxHeap2 = PriorityQueue<Int>(k, Comparator.reverseOrder()).apply { addAll(nums.takeLast(k)) }

        val isBiggerArray1 = BooleanArray(nums.size)
        val isBiggerArray2 = BooleanArray(nums.size)

        var forward = k
        var backward = nums.size - k - 1
        while (forward <= nums.size - k - 1 && backward >= k) {
            val forwardVal = nums[forward]
            val backwardVal = nums[backward]
            // when both indexes point to the same location
            if (forward == backward) {
                val isBigger = forwardVal > maxHeap2.peek() && forwardVal > maxHeap1.peek()
                isBiggerArray1[forward] = isBigger
                isBiggerArray2[forward] = isBigger
            } else {
                if (forwardVal > maxHeap1.peek())
                    isBiggerArray1[forward] = true
                else {
                    maxHeap1.poll()
                    maxHeap1.add(forwardVal)
                }

                if (backwardVal > maxHeap2.peek())
                    isBiggerArray2[backward] = true
                else {
                    maxHeap2.poll()
                    maxHeap2.add(backwardVal)
                }
            }

            backward--
            forward++
        }

        val andResult = isBiggerArray1.mapIndexed { i, v -> v && isBiggerArray2[i] }
        return andResult.count { it }
    }
}

fun main() {
    println(Solution().kBigIndices(intArrayOf(2, 3, 6, 5, 2, 3), 2))
}
