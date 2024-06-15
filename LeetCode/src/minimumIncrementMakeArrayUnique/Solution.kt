package minimumIncrementMakeArrayUnique

import java.util.*

class Solution {
    fun minIncrementForUnique(nums: IntArray): Int {
        if (nums.size < 2) {
            return 0
        }
        Arrays.sort(nums)
        var count = 0
        for (i in 1 until nums.size) {
            if (nums[i] <= nums[i - 1]) {
                val diff = nums[i - 1] - nums[i] + 1
                nums[i] += diff
                count += diff
            }
        }
        return count
    }
}

fun main() {
    println(Solution().minIncrementForUnique(intArrayOf(3, 2, 1, 2, 1, 7)))
}