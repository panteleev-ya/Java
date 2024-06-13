package substringsThatBeginAndEndWithTheSameLetter

class Solution {
    fun numberOfSubstrings(s: String): Long {
        val counter = IntArray(26)
        var count = 0L
        for (c in s) {
            val index = c - 'a'
            counter[index]++
            count += counter[index]
        }
        return count
    }
}

fun main() {
    println(Solution().numberOfSubstrings("abcaabbc"))
}