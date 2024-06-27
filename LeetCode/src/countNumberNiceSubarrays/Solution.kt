package countNumberNiceSubarrays

import java.util.*

class Solution {
    fun numberOfSubarrays(nums: IntArray, k: Int): Int {
        var niceCount = 0
        var left = 0
        var right = 0
        val indexesOfOddsQueue: Queue<Int> = LinkedList()
        while (right < nums.size) {
            if (nums[right] % 2 == 1) {
                indexesOfOddsQueue.add(right)
                if (indexesOfOddsQueue.size > k) {
                    left = indexesOfOddsQueue.poll() + 1
                }
            }
            if (indexesOfOddsQueue.size == k) {
                niceCount += indexesOfOddsQueue.peek() - left + 1
            }
            right++
        }
        return niceCount
    }
}

fun main() {
//    println(Solution().numberOfSubarrays(intArrayOf(1, 1, 2, 1, 1), 3))
//    println(Solution().numberOfSubarrays(intArrayOf(1, 1, 2, 1, 1), 1))
//    println(Solution().numberOfSubarrays(intArrayOf(2, 4, 6), 1))
    println(Solution().numberOfSubarrays(intArrayOf(2, 2, 2, 1, 2, 2, 1, 2, 2, 2), 2))
}