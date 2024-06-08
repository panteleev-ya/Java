package handOfStraights

import java.util.*

class Solution {
    fun isNStraightHand(hand: IntArray, groupSize: Int): Boolean {
        if (hand.size % groupSize > 0) {
            return false
        }
        Arrays.sort(hand)
        val groups: MutableList<MutableList<Int>> = ArrayList()
        groups.add(arrayListOf(hand[0], 1))
        var lastUnfilled = 0
        for (i in 1 until hand.size) {
            var used = false
            for (j in lastUnfilled until groups.size) {
                if (groups[j][1] == groupSize) {
                    lastUnfilled++
                } else if (hand[i] - groups[j][0] == 1) {
                    groups[j][1]++
                    groups[j][0] = hand[i]
                    used = true
                    break
                } else if (hand[i] - groups[j][0] > 1) {
                    return false
                }
            }
            if (!used) {
                groups.add(arrayListOf(hand[i], 1))
            }
        }
        return groups[groups.size - 1][1] == groupSize
    }
}

fun main() {
//    println(Solution().isNStraightHand(intArrayOf(1, 2, 3, 6, 2, 3, 4, 7, 8), 3))
    println(Solution().isNStraightHand(intArrayOf(1, 2, 3), 1))
}