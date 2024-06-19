package minimumAdjacentSwapsToMakeValidArray

class Solution {
    fun minimumSwaps(nums: IntArray): Int {
        var mostLeftMinIndex = 0
        var mostRightMaxIndex = 0
        var minValue = nums[0]
        var maxValue = nums[0]
        for (i in nums.indices) {
            if (nums[i] < minValue) {
                minValue = nums[i]
                mostLeftMinIndex = i
            }
            if (nums[i] >= maxValue) {
                maxValue = nums[i]
                mostRightMaxIndex = i
            }
        }
        var count = (nums.size - 1 - mostRightMaxIndex) + (mostLeftMinIndex - 0)
        if (mostRightMaxIndex < mostLeftMinIndex) {
            count--
        }
        return count
    }
}
