package longestPalindrome

class Solution {
    fun longestPalindrome(s: String): Int {
        val counts: MutableMap<Char, Int> = HashMap()
        var canBeOdd = true
        for (c in s) {
            counts.merge(c, 1) { a, b -> a + b }
        }
        var maxLength = 0
        for (entry in counts) {
            if (entry.value % 2 == 0) {
                maxLength += entry.value
            } else if (canBeOdd) {
                maxLength += entry.value
                canBeOdd = false
            } else {
                maxLength += entry.value - 1
            }
        }
        return maxLength
    }
}

fun main() {
    println(Solution().longestPalindrome("abccccdd"))
}