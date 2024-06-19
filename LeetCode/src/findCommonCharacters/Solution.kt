package findCommonCharacters

import java.util.*

class Solution {
    fun commonChars(words: Array<String>): List<String> {
        val countingMap: MutableMap<Char, TreeMap<Int, Int>> = HashMap()
        for (word in words) {
            val wordMap: MutableMap<Char, Int> = HashMap()
            for (c in word) {
                wordMap.merge(c, 1) { a, b -> a + b }
            }
            for (entry in wordMap) {
                if (!countingMap.contains(entry.key)) {
                    countingMap[entry.key] = TreeMap { a, b -> b - a }
                }
                countingMap[entry.key]?.merge(entry.value, 1) { a, b -> a + b }
            }
        }
        val answer: MutableList<String> = ArrayList()
        for (charMap in countingMap) {
            var wordCounter = 0
            var count = 0
            for (entry in charMap.value) {
                wordCounter += entry.value
                if (wordCounter == words.size) {
                    count = entry.key
                }
            }
            val s = charMap.key.toString()
            for (i in 1..count) {
                answer.add(s)
            }
        }
        return answer
    }
}