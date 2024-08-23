package strangePrinter

import kotlin.math.min

class Solution {
    fun strangePrinter(s: String): Int {
        // Preprocess the string to remove consecutive duplicate characters
        var s1 = s
        s1 = removeDuplicates(s1)
        val n = s1.length
        // Initialize memoization array
        val memo = Array(n) { arrayOfNulls<Int>(n) }
        // Start the recursive process
        return minimumTurns(0, n - 1, s1, memo)
    }

    private fun minimumTurns(start: Int, end: Int, s: String, memo: Array<Array<Int?>>): Int {
        // Base case: empty string requires 0 turns
        if (start > end) {
            return 0
        }

        // If result is memoized, return it
        if (memo[start][end] != null) {
            return memo[start][end]!!
        }

        // Initialize with worst case: print each character separately
        var minTurns = 1 + minimumTurns(start + 1, end, s, memo)

        // Try to optimize by finding matching characters
        for (k in start + 1..end) {
            if (s[k] == s[start]) {
                // If match found, try splitting the problem
                val turnsWithMatch =
                    minimumTurns(start, k - 1, s, memo) +
                            minimumTurns(k + 1, end, s, memo)
                minTurns = min(minTurns.toDouble(), turnsWithMatch.toDouble()).toInt()
            }
        }

        // Memoize and return the result
        return minTurns.also { memo[start][end] = it }
    }

    private fun removeDuplicates(s: String): String {
        val uniqueChars = StringBuilder()
        var i = 0
        while (i < s.length) {
            val currentChar = s[i]
            uniqueChars.append(currentChar)
            // Skip all consecutive occurrences of the current character
            while (i < s.length && s[i] == currentChar) {
                i++
            }
        }
        return uniqueChars.toString()
    }
}

fun main() {
    println(Solution().strangePrinter("aaabbb"))
    println(Solution().strangePrinter("aba"))
    println(Solution().strangePrinter("tbgtgb"))
}