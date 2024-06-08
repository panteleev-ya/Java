package continuousSubarraySum

class Solution {
    fun checkSubarraySum(nums: IntArray, k: Int): Boolean {
        val prefixSumModKs = mutableSetOf<Int>()
        var prevPrefixSumModK = 0

        for (num in nums) {
            val prefixSumModK = (prevPrefixSumModK + num) % k
            if (prefixSumModK in prefixSumModKs) {
                return true
            }

            prefixSumModKs.add(prevPrefixSumModK)
            prevPrefixSumModK = prefixSumModK
        }
        return false
    }
}

fun main() {
    println(Solution().checkSubarraySum(intArrayOf(23, 2, 4, 6, 7), 6))
}