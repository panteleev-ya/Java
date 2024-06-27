package minimumNumberOfKConsecutiveBitFlips


class Solution {
    fun minKBitFlips(nums: IntArray, k: Int): Int {
        var count = 0
        for (i in 0 until nums.size - k + 1) {
            if (nums[i] == 0) {
                count++
                for (j in i until i + k) {
                    nums[j] = if (nums[j] == 0) 1 else 0
                }
            }
        }
        return if (nums.any { it == 0 }) -1 else count
    }
}