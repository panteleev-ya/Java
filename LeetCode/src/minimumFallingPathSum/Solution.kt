package minimumFallingPathSum

import kotlin.math.min

class Solution {
    fun minFallingPathSum(matrix: Array<IntArray>): Int {
        val dp: Array<IntArray> = Array(matrix.size) { IntArray(matrix[0].size) { Int.MAX_VALUE } }
        for (j in dp[0].indices) {
            dp[0][j] = matrix[0][j]
        }
        for (i in 1..dp.lastIndex) {
            for (j in dp[i].indices) {
                var minPrev = dp[i - 1][j]
                if (j > 0) {
                    minPrev = min(minPrev, dp[i - 1][j - 1])
                }
                if (j < dp[i].lastIndex) {
                    minPrev = min(minPrev, dp[i - 1][j + 1])
                }
                dp[i][j] = matrix[i][j] + minPrev
            }
        }
        return dp.last().min()
    }
}

fun main() {
    println(
        Solution().minFallingPathSum(
            arrayOf(
                intArrayOf(10, -98, 44),
                intArrayOf(-20, 65, 34),
                intArrayOf(-100, -1, 74)
            )
        )
    )
}
