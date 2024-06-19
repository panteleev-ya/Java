package rottingOranges

import java.util.*

class Solution {
    fun orangesRotting(grid: Array<IntArray>): Int {
        var freshOrangesCount = 0
        val rottenOranges: Queue<Pair<Int, Int>> = LinkedList()
        for (i in grid.indices) {
            for (j in grid[i].indices) {
                if (grid[i][j] == 1) {
                    freshOrangesCount++
                } else if (grid[i][j] == 2) {
                    rottenOranges.add(Pair(i, j))
                }
            }
        }
        if (rottenOranges.isEmpty()) {
            return if (freshOrangesCount == 0) 0 else -1
        }
        val directions = arrayOf(Pair(-1, 0), Pair(1, 0), Pair(0, -1), Pair(0, 1))
        var time = -1
        while (rottenOranges.isNotEmpty()) {
            repeat(rottenOranges.size) {
                val rottenOrangePosition = rottenOranges.poll()
                for (direction in directions) {
                    val x = rottenOrangePosition.first + direction.first
                    val y = rottenOrangePosition.second + direction.second
                    if (x in grid.indices && y in grid[x].indices) {
                        if (grid[x][y] == 1) {
                            freshOrangesCount--
                            rottenOranges.add(Pair(x, y))
                            grid[x][y] = 2
                        }
                    }
                }
            }
            time++
        }
        return if (freshOrangesCount == 0) time else -1
    }
}