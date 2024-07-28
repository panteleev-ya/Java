package removeDuplicatesFromSortedArrayII

class Solution {
    fun removeDuplicates(nums: IntArray): Int {
        var left = 0
        var right = 0
        var counter = 0
        var last = nums[0]
        val k = 2
        while (right < nums.size) {
            if (nums[right] != last) {
                nums[left] = nums[right]
                last = nums[right]
                counter = 1
                left++
            } else if (counter < k) {
                nums[left] = nums[right]
                counter++
                left++
            }
            right++
        }
        return left
    }
}

fun main() {
    println(Solution().removeDuplicates(intArrayOf(0, 0, 0, 0, 1, 1, 1, 2, 2, 3)))
}
