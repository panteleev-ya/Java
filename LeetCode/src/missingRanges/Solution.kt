package missingRanges

class Solution {
    fun findMissingRanges(nums: IntArray, lower: Int, upper: Int): List<List<Int>> {
        if (nums.isEmpty()) {
            return listOf(listOf(lower, upper))
        }
        var current = lower
        val missing = mutableListOf<List<Int>>()
        if (current < nums[0]) {
            missing.add(listOf(current, nums[0] - 1))
            current = nums[0]
        }
        var i = 0
        while (i < nums.size && nums[i] < current) {
            i++
        }
        while (i < nums.size && current < upper) {
            if (nums[i] - current > 1) {
                missing.add(listOf(current + 1, nums[i] - 1))
            }
            current = nums[i]
            i++
        }
        if (current != upper) {
            missing.add(listOf(current + 1, upper))
        }
        return missing
    }
}

fun main() {
    println(Solution().findMissingRanges(intArrayOf(0, 1, 3, 50, 75), 0, 99))
}