package kInversePairsArray

class Solution {
    fun kInversePairs(n: Int, k: Int): Int {
        val dp = Array(n + 1) { IntArray(k + 1) }
        val module = 1000000007
        for (i in 1..n) {
            dp[i][0] = 1
            for (j in 1..k) {
                val `val` = (dp[i - 1][j] + module - (if ((j - i) >= 0) dp[i - 1][j - i] else 0)) % module
                dp[i][j] = (dp[i][j - 1] + `val`) % module
            }
        }
        return ((dp[n][k] + module - (if (k > 0) dp[n][k - 1] else 0)) % module)
    }
}
