package numberOfWaysToSelectBuildings

class Solution {
    fun numberOfWays(s: String): Long {
        var count1s = 0L
        var count0s = 0L
        var count10s = 0L
        var count01s = 0L

        var selections = 0L

        for (char in s) {
            if (char == '0') {
                count0s += 1L
                count10s += count1s
                selections += count01s
            } else {
                count1s += 1L
                count01s += count0s
                selections += count10s
            }
        }

        return selections
    }
}

fun main() {
    println(Solution().numberOfWays("001101"))
}