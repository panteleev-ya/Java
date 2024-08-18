package uglyNumberII

import java.util.*


class Solution {
    fun nthUglyNumber(n: Int): Int {
        val set = TreeSet<Long>()
        set.add(1L)

        var currentUgly = 1L
        repeat (n) {
            currentUgly = set.pollFirst()!!
            set.add(currentUgly * 2)
            set.add(currentUgly * 3)
            set.add(currentUgly * 5)
        }

        return currentUgly.toInt()
    }
}

fun main() {
    println(Solution().nthUglyNumber(10))
}