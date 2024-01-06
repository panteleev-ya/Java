package longestIncreasingSubsequence

import kotlin.math.max

class Solution {
    fun lengthOfLIS(nums: IntArray): Int {
        val lengths = IntArray(nums.size)
        lengths[lengths.size - 1] = 0
        for (i in lengths.size - 2 downTo 0) {
            for (j in i + 1 until lengths.size) {
                if (nums[j] > nums[i]) {
                    lengths[i] = max(lengths[i], lengths[j] + 1)
                }
            }
        }
        return lengths.max() + 1
    }
}

fun main() {
    println(Solution().lengthOfLIS(intArrayOf(10, 9, 2, 5, 3, 7, 101, 18)))
//    val (a, b) = readln().split(" ")
}
