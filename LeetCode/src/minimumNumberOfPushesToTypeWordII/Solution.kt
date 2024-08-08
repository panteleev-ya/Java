package minimumNumberOfPushesToTypeWordII

class Solution {
    fun minimumPushes(word: String): Int {
        val map = HashMap<Char, Int>()
        for (c in word) {
            map.merge(c, 1) { a, b -> a + b }
        }
        val sorted = map.values.toList().sortedDescending()
        var pushesCount = 0
        for (i in sorted.indices) {
            pushesCount += (i / 8 + 1) * sorted[i]
        }
        return pushesCount
    }
}