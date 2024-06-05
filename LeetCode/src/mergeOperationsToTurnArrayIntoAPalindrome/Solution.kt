package mergeOperationsToTurnArrayIntoAPalindrome

class Solution {
    fun minimumOperations(nums: IntArray): Int {
        if (nums.size < 2) {
            return 0
        }
        var left = 0
        var right = nums.size - 1
        var sum = nums[left] - nums[right]
        var movesCounter = 0
        while (left < right) {
            if (sum == 0) {
                left++
                right--
                sum += nums[left]
                sum -= nums[right]
                continue
            }
            if (sum < 0) {
                left++
                sum += nums[left]
                movesCounter++
                continue
            }
            right--
            sum -= nums[right]
            movesCounter++
        }
        return movesCounter
    }
}

fun main() {
//    println(Solution().minimumOperations(intArrayOf(4, 3, 2, 1, 2, 3, 1)))
    println(Solution().minimumOperations(intArrayOf(1, 2, 3, 4)))
}
