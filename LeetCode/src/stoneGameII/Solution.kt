package stoneGameII

class Solution {
    fun stoneGameII(piles: IntArray): Int {
        val totalPiles = piles.size
        val suffixSums = IntArray(totalPiles + 1)
        for (i in totalPiles - 1 downTo 0) {
            suffixSums[i] = suffixSums[i + 1] + piles[i]
        }
        return maxStonesAliceCanGet(suffixSums, 1, 0, Array(totalPiles) { IntArray(totalPiles + 1) })
    }

    private fun maxStonesAliceCanGet(suffixSums: IntArray, m: Int, currentPile: Int, memo: Array<IntArray>): Int {
        val totalPiles = suffixSums.size - 1
        if (currentPile >= totalPiles) {
            return 0
        }
        if (currentPile + 2 * m >= totalPiles) {
            return suffixSums[currentPile]
        }
        if (memo[currentPile][m] != 0) {
            return memo[currentPile][m]
        }

        var maxStones = 0
        for (x in 1..2 * m) {
            val next = maxStonesAliceCanGet(suffixSums, maxOf(m, x), currentPile + x, memo)
            val currentStones = suffixSums[currentPile] - next
            maxStones = maxOf(maxStones, currentStones)
        }
        memo[currentPile][m] = maxStones
        return maxStones
    }
}

fun main() {
    println(Solution().stoneGameII(intArrayOf(2, 7, 9, 4, 4)))
}