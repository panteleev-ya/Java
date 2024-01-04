package equalRowAndColumnPairs

class Solution {
    fun equalPairs(grid: Array<IntArray>): Int {
        val rows = mutableMapOf<String, Int>()
        val columns = mutableMapOf<String, Int>()
        for (i in grid.indices) {
            var s = ""
            for (j in grid[0].indices) {
                s += grid[i][j]
                s += ','
            }
            rows[s] = rows.getOrDefault(s, 0) + 1
        }

        for (j in grid[0].indices) {
            var s = ""
            for (i in grid.indices) {
                s += grid[i][j]
                s += ','
            }
            columns[s] = columns.getOrDefault(s, 0) + 1
        }

        var count = 0
        for (rowEntry in rows) {
            count += rowEntry.value * columns.getOrDefault(rowEntry.key, 0)
        }
        return count
    }
}

fun main() {
    val grid = arrayOf(intArrayOf(11, 1), intArrayOf(1, 11))
    println(Solution().equalPairs(grid))
}
