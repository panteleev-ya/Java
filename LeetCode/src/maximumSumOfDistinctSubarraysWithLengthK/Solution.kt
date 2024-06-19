package maximumSumOfDistinctSubarraysWithLengthK

import kotlin.math.max


class Solution {
    fun maximumSubarraySum(nums: IntArray, k: Int): Long {
        var maxSum: Long = 0
        var currentSum: Long = 0
        val set = HashSet<Int>()
        var right = 0
        for (left in nums.indices) {
            while (right < nums.size && !set.contains(nums[right]) && set.size < k) {
                set.add(nums[right])
                currentSum += nums[right]
                right++
            }
            if (set.size == k) {
                maxSum = max(currentSum.toDouble(), maxSum.toDouble()).toLong()
            }
            set.remove(nums[left])
            currentSum -= nums[left]
        }
        return maxSum
    }
}

fun main() {
//    println(Solution().maximumSubarraySum(intArrayOf(1, 5, 4, 2, 9, 9, 9), 3))
//    println(Solution().maximumSubarraySum(intArrayOf(4, 4, 4), 3))
    println(Solution().maximumSubarraySum(intArrayOf(9, 18, 10, 13, 17, 9, 19, 2, 1, 18), 5))
}