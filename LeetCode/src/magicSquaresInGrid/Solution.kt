package magicSquaresInGrid

import java.util.*

class Solution {
    fun numMagicSquaresInside(grid: Array<IntArray>): Int {
        if (grid.size < 3 || grid[0].size < 3) {
            return 0
        }
        val visited = Array(grid.size) { BooleanArray(grid[it].size) { false } }
        val directions = arrayOf(Pair(0, 1), Pair(1, 0))
        val queue: Queue<Pair<Int, Int>> = LinkedList()
        queue.add(Pair(0, 0))
        var counter = 0
        while (queue.isNotEmpty()) {
            val pos = queue.poll()
            if (isMagic(pos.first, pos.second, grid)) {
                counter++
            }
            for (dir in directions) {
                val x = pos.first + dir.first
                val y = pos.second + dir.second
                if (x + 2 < grid.size && y + 2 < grid[x].size && !visited[x][y]) {
                    queue.add(Pair(x, y))
                    visited[x][y] = true
                }
            }
        }
        return counter
    }

    private fun isMagic(x: Int, y: Int, grid: Array<IntArray>): Boolean {
        val seen = BooleanArray(9) { false }
        val sums = arrayOf(
            intArrayOf(0, 0, 0), // rows
            intArrayOf(0, 0, 0), // columns
            intArrayOf(0, 0)     // diagonals
        )
        for (i in 0 until 3) {
            for (j in 0 until 3) {
                val num = grid[x + i][y + j]
                if (num !in 1..9 || seen[num - 1]) {
                    return false
                }
                seen[num - 1] = true
                sums[0][i] += num
                sums[1][j] += num
                if (i == j) {
                    sums[2][0] += num
                }
                if (i + j + 1 == 3) {
                    sums[2][1] += num
                }
            }
        }
        val ref = sums[0][0]
        for (arr in sums) {
            for (num in arr) {
                if (num != ref) {
                    return false
                }
            }
        }
        return true
    }
}

fun main() {
    println(
        Solution().numMagicSquaresInside(
            arrayOf(
                intArrayOf(3, 10, 2, 3, 4),
                intArrayOf(4, 5, 6, 8, 1),
                intArrayOf(8, 8, 1, 6, 8),
                intArrayOf(1, 3, 5, 7, 1),
                intArrayOf(9, 4, 9, 2, 9)
            )
        )
    )
}
