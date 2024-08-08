package minimumSwapsToGroupAll1sTogetherII

import kotlin.math.max

class Solution {
    fun minSwaps(nums: IntArray): Int {
        val onesCount = nums.sum()
        var count = 0
        for (i in 0 until onesCount) {
            count += nums[i]
        }
        var maxCount = count
        var left = 0
        var right = onesCount - 1
        while (left < nums.size) {
            count -= nums[left]
            left++
            right = (right + 1) % nums.size
            count += nums[right]
            maxCount = max(maxCount, count)
        }
        return onesCount - maxCount
    }
}