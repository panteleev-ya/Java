package findKthSmallestPairDistance

class Solution {
    fun smallestDistancePair(nums: IntArray, k: Int): Int {
        nums.sort()
        var left = 0
        var right = nums[nums.size - 1] - nums[0]

        while (left < right) {
            val mid = left + (right - left) / 2
            val countPair = countPairWithDistanceLessThanOrEqual(nums, mid)

            if (countPair >= k) {
                right = mid
            } else {
                left = mid + 1
            }
        }

        return left
    }

    private fun countPairWithDistanceLessThanOrEqual(nums: IntArray, mid: Int): Int {
        var count = 0
        var j = 0

        for (i in nums.indices) {
            while (j < nums.size && nums[j] - nums[i] <= mid) {
                j++
            }

            count += j - i - 1
        }

        return count
    }
}