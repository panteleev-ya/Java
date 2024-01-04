package determineIfTwoStringsAreClose

class Solution {
    fun closeStrings(word1: String, word2: String): Boolean {
        val mapWord1 = mutableMapOf<Char, Int>()
        word1.toCharArray().forEach {
            mapWord1[it] = mapWord1.getOrDefault(it, 0) + 1
        }
        val mapWord2 = mutableMapOf<Char, Int>()
        word2.toCharArray().forEach {
            mapWord2[it] = mapWord2.getOrDefault(it, 0) + 1
        }
        if (!mapWord1.keys.containsAll(mapWord2.keys)) {
            return false
        }
        val mapValues1 = mutableMapOf<Int, Int>()
        mapWord1.values.forEach {
            mapValues1[it] = mapValues1.getOrDefault(it, 0) + 1
        }
        val mapValues2 = mutableMapOf<Int, Int>()
        mapWord2.values.forEach {
            mapValues2[it] = mapValues2.getOrDefault(it, 0) + 1
        }
        for (key in mapValues1.keys) {
            if (mapValues1.getOrDefault(key, -1) != mapValues2.getOrDefault(key, -1)) {
                return false
            }
        }
        return true
    }
}

fun main() {
    val word1 = "aaabbbbccddeeeeefffff"
    val word2 = "aaaaabbcccdddeeeeffff"
    println(Solution().closeStrings(word1, word2))
}
