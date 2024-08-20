package topKFrequentElements

class Solution {
    fun topKFrequent(nums: IntArray, k: Int): IntArray {
        val map = HashMap<Int, Int>()
        for (num in nums) {
            map.merge(num, 1) { a, b -> a + b }
        }
        return map.entries.stream()
            .sorted { a, b -> b.value - a.value }
            .limit(k + 0L)
            .map { it.key }
            .toList()
            .toIntArray()
    }
}

fun main() {
    println(Solution().topKFrequent(intArrayOf(1, 1, 1, 2, 2, 3), 2).contentToString())
}