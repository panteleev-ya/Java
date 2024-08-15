package lemonadeChange

class Solution {
    fun lemonadeChange(bills: IntArray): Boolean {
        val change = intArrayOf(0, 0)  // $5 and $10 bills amounts
        for (bill in bills) {
            when (bill) {
                5 -> {
                    change[0]++
                }
                10 -> {
                    if (change[0] > 0) {
                        change[0]--
                        change[1]++
                    } else {
                        return false
                    }
                }
                20 -> {
                    if (change[1] > 0 && change[0] > 0) {
                        change[1]--
                        change[0]--
                    } else if (change[0] >= 3) {
                        change[0] -= 3
                    } else {
                        return false
                    }
                }
            }
        }
        return true
    }
}