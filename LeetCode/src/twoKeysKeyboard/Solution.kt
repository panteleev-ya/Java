package twoKeysKeyboard

import kotlin.math.min

class Solution {
    fun minSteps(n: Int): Int {
        if (n == 1) {
            return 0
        }

        val dp = IntArray(n + 1) { Int.MAX_VALUE }

        fun paste(copiedAmount: Int, onScreenAmount: Int, operations: Int) {
            dp[onScreenAmount] = min(dp[onScreenAmount], operations)
            if (copiedAmount + onScreenAmount <= n) {
                paste(copiedAmount, onScreenAmount + copiedAmount, operations + 1)
                if (onScreenAmount + onScreenAmount <= n) {
                    paste(onScreenAmount, onScreenAmount + onScreenAmount, operations + 2)
                }
            }
        }

        paste(1, 1, 1)
        return dp[n]
    }
}