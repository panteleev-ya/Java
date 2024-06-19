package sortColors

class Solution {
    fun sortColors(nums: IntArray) {
        val counts = IntArray(3)
        nums.forEach {
            counts[it] += 1
        }
        var i = 0
        for (color in counts.indices) {
            while (counts[color] > 0) {
                nums[i++] = color
                counts[color] -= 1
            }
        }
    }
}