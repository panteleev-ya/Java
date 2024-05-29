package theKthFactorOfN

import kotlin.math.sqrt


class Solution {
    fun kthFactor(n: Int, k: Int): Int {
        var counter = k
        val divisors: MutableList<Int> = ArrayList()
        val sqrtN = sqrt(n.toDouble()).toInt()
        for (divisor in 1..sqrtN) {
            if (n % divisor == 0) {
                --counter
                divisors.add(divisor)
                if (counter == 0) {
                    return divisor
                }
            }
        }

        if (sqrtN * sqrtN == n) {
            counter++
        }

        val nDiv = divisors.size
        return if ((counter <= nDiv)) n / divisors[nDiv - counter] else -1
    }
}

fun main() {
    println(Solution().kthFactor(2, 2))
}
