package jumpGameVIII

class Solution {
    fun minCost(nums: IntArray, costs: IntArray): Long {
        val dp = LongArray(nums.size) { Long.MAX_VALUE }
        dp[0] = 0
        helper(nums, costs, dp, 0)
        return dp[nums.size - 1]
    }

    private fun helper(nums: IntArray, costs: IntArray, dp: LongArray, i: Int) {
        if (i == nums.size - 1) {
            return
        }
        var maxValueCanJump = true
        var minValueCanJump = true
        for (j in i + 1 until nums.size) {
            if (nums[i] <= nums[j]) {
                if (maxValueCanJump) {
                    val newCost = dp[i] + costs[j]
                    if (dp[j] > newCost && newCost < dp[nums.size - 1]) {
                        dp[j] = newCost
                        helper(nums, costs, dp, j)
                    }
                    maxValueCanJump = false
                }
            }
            if (nums[i] > nums[j]) {
                if (minValueCanJump) {
                    val newCost = dp[i] + costs[j]
                    if (dp[j] > newCost && newCost < dp[nums.size - 1]) {
                        dp[j] = newCost
                        helper(nums, costs, dp, j)
                    }
                    minValueCanJump = false
                }
            }
        }
    }
}

fun main() {
    println(Solution().minCost(intArrayOf(3, 2, 4, 4, 1), intArrayOf(3, 7, 6, 4, 2)))
}