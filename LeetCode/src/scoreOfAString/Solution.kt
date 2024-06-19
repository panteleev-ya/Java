package scoreOfAString

import kotlin.math.abs

class Solution {
    fun scoreOfString(s: String): Int {
        var score = 0
        for (i in 1 until s.length) {
            score += (abs(s[i].code - s[i - 1].code))
        }
        return score
    }
}
