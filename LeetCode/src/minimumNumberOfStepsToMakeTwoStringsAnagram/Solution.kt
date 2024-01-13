package minimumNumberOfStepsToMakeTwoStringsAnagram

import kotlin.math.abs
import kotlin.math.min

class Solution {
    fun minSteps(s: String, t: String): Int {
        val charMapS = mutableMapOf<Char, Int>()
        val charMapT = mutableMapOf<Char, Int>()
        for (i in s.indices) {
            charMapS[s[i]] = charMapS.getOrDefault(s[i], 0) + 1
            charMapT[t[i]] = charMapT.getOrDefault(t[i], 0) + 1
        }
        var sameCharsCount = 0
        for ((c, count) in charMapT) {
            sameCharsCount += min(count, charMapS.getOrDefault(c, 0))
        }
        return t.length - sameCharsCount
    }
}

fun main() {
    println(Solution().minSteps("leetcode", "practice"))
}
