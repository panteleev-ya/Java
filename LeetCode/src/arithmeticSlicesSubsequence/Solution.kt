package arithmeticSlicesSubsequence

class Solution {
    fun numberOfArithmeticSlices(nums: IntArray): Int {
        val dp = mutableMapOf<Pair<Int, Int>, Int>()
        fun dfs(i: Int, k: Int): Int = dp.getOrPut(i to k) {
            var count = 0
            for (j in i + 1..<nums.size)
                if (nums[i].toLong() - nums[k] == nums[j].toLong() - nums[i])
                    count += 1 + dfs(j, i)
            count
        }

        var count = 0
        for (i in nums.indices)
            for (j in i + 1..<nums.size)
                count += dfs(j, i)
        return count
    }
}

fun main() {
//    println(Solution().numberOfArithmeticSlices(intArrayOf(1, 2, 4, 6, 7, 8, 10, 12)))
    println(Solution().numberOfArithmeticSlices(intArrayOf(2, 4, 6, 8, 10)))
    println(Solution().numberOfArithmeticSlices(intArrayOf(7, 7, 7, 7, 7)))
}
