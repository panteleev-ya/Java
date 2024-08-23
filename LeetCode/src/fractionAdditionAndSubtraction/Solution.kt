package fractionAdditionAndSubtraction

import kotlin.math.abs

class Solution {
    fun fractionAddition(expression: String): String {
        var top = 0
        var bottom = 1
        val regex = Regex("(-?[0-9]+)/([0-9]+)")
        for (fraction in regex.findAll(expression)) {
            var fTop = fraction.groups[1]!!.value.toInt()
            val fBottom = fraction.groups[2]!!.value.toInt()
            val updatedBottom = lcm(bottom, fBottom)
            top *= (updatedBottom / bottom)
            fTop *= (updatedBottom / fBottom)
            top += fTop
            bottom = updatedBottom
        }
        val topBottomGcd = abs(gcd(top, bottom))
        top /= topBottomGcd
        bottom /= topBottomGcd
        return "$top/$bottom"
    }

    private fun gcd(a: Int, b: Int): Int {
        return if (b == 0) a else gcd(b, a % b)
    }

    private fun lcm(a: Int, b: Int): Int {
        return (a * b) / gcd(a, b)
    }
}

fun main() {
    println(Solution().fractionAddition("1/3-1/2"))
}