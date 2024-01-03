package convertAnArrayInto2DArrayWithConditions

class Solution {
    fun findMatrix(nums: IntArray): List<List<Int>> {
        nums.sort()
        var lastNum = nums[0]
        var equalNumsCount = -1
        val matrix = mutableListOf<MutableList<Int>>()
        for (num in nums) {
            if (num == lastNum) {
                equalNumsCount++
                if (matrix.size < equalNumsCount + 1) {
                    matrix.add(mutableListOf())
                }
                matrix[equalNumsCount].add(num)
            } else {
                equalNumsCount = 0
                matrix[0].add(num)
            }
            lastNum = num
        }
        return matrix
    }
}

fun main() {
    val solution = Solution()
    val nums = intArrayOf(1, 3, 4, 1, 2, 3, 1)
    val matrix = solution.findMatrix(nums)
    for (line in matrix) {
        println(line)
    }
}
