package setMismatch

class Solution {
    fun findErrorNums(nums: IntArray): IntArray {
        val targetSum = (1 + nums.size) * nums.size / 2
        val actualSum = nums.sum()
        val diff = targetSum - actualSum
        val contains = BooleanArray(nums.size + 1) { false }
        for (num in nums) {
            if (contains[num]) {
                return intArrayOf(num, num + diff)
            }
            contains[num] = true
        }
        return intArrayOf(-1, -1)
    }
}
