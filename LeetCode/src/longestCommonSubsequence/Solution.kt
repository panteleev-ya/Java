package longestCommonSubsequence

class Solution {
    fun longestCommonSubsequence(text1: String, text2: String): Int {
        val dp = IntArray(text2.length + 1)

        for (i in text1.indices) {
            var upRowCur = 0
            for (j in text2.indices) {
                val upRow = dp[j + 1]
                if (text1[i] == text2[j]) {
                    dp[j+1] = upRowCur + 1
                } else {
                    dp[j+1] = maxOf(dp[j], dp[j + 1])
                }
                upRowCur = upRow
            }
        }
        return dp[text2.length]
    }
}

fun main() {
    println(Solution().longestCommonSubsequence("psnw", "vozsh"))
}
