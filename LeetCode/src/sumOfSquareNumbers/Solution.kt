package sumOfSquareNumbers

import kotlin.math.sqrt

class Solution {
    fun judgeSquareSum(c: Int): Boolean {
        var a = 0L
        while (a * a <= c) {
            val b: Double = sqrt((c - a * a).toDouble())
            if (b == b.toInt().toDouble()) {
                return true
            }
            a++
        }
        return false
    }
}