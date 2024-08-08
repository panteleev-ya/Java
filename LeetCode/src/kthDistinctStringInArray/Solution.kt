package kthDistinctStringInArray

class Solution {
    fun kthDistinct(arr: Array<String>, k: Int): String {
        val map = LinkedHashMap<String, Int>()
        for (word in arr) {
            map.merge(word, 1) { a, b -> a + b }
        }
        var distinctCount = 0
        for (entry in map) {
            if (entry.value == 1) {
                if (++distinctCount == k) {
                    return entry.key
                }
            }
        }
        return ""
    }
}
