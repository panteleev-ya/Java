package findPlayersWithZeroOrOneLosses

class Solution {
    fun findWinners(matches: Array<IntArray>): List<List<Int>> {
        val losesCountMap = mutableMapOf<Int, Int>()
        for (match in matches) {
            losesCountMap.putIfAbsent(match[0], 0)
            losesCountMap[match[1]] = losesCountMap.getOrDefault(match[1], 0) + 1
        }
        val result = listOf<MutableList<Int>>(mutableListOf(), mutableListOf())
        for ((player, losesCount) in losesCountMap) {
            when (losesCount) {
                0 -> result[0].add(player)
                1 -> result[1].add(player)
            }
        }
        result[0].sort()
        result[1].sort()
        return result
    }
}
