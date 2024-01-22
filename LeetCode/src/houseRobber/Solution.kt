package houseRobber

import kotlin.math.max

class Solution {
    fun rob(houseValues: IntArray): Int {
        val maxAmounts = IntArray(houseValues.size) { 0 }
        for (i in houseValues.lastIndex downTo 0) {
            maxAmounts[i] = max(maxAmounts[i], houseValues[i])
            for (j in i - 2 downTo 0) {
                maxAmounts[j] = max(maxAmounts[j], maxAmounts[i] + houseValues[j])
            }
        }
        return maxAmounts.max()
    }
}

fun main() {
//    println(Solution().rob(intArrayOf(1, 2, 3, 1, 4, 5)))
    println(Solution().rob(intArrayOf(1, 2, 3, 1)))
}
