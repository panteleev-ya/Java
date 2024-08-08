package removeElement

class Solution {
    fun removeElement(nums: IntArray, `val`: Int): Int {
        var left = 0
        for (i in nums.indices) {
            if (nums[i] != `val`) {
                nums[left] = nums[i]
                left++
            }
        }
        return left
    }
}

fun main() {
    println(Solution().removeElement(intArrayOf(3, 2, 2, 3), 3))
}