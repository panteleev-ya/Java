package minimumNumberOfKeypresses

import java.util.TreeMap

class Solution {
    fun minimumKeypresses(s: String): Int {
        val map: MutableMap<Char, Int> = HashMap()
        for (c in s) {
            map.merge(c, 1) { a, b -> a + b }
        }
        val sorted: List<Int> = map.values.sortedWith() { a, b -> b - a }
        var position = 1
        var emptyKeys = 9
        var presses = 0
        for (num in sorted) {
            if (emptyKeys == 0) {
                position++
                emptyKeys = 9
            }
            presses += position * num
            emptyKeys--
        }
        return presses
    }
}

fun main() {
    println(Solution().minimumKeypresses("aaaaaaaabcdefgggghijkllllllllllmmmnoppponono"))
}