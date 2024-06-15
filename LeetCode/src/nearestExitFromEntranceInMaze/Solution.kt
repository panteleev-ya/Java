package nearestExitFromEntranceInMaze

import java.util.*


class Solution {
    fun nearestExit(maze: Array<CharArray>, entrance: IntArray): Int {
        val rows = maze.size
        val cols = maze[0].size
        val dirs = arrayOf(intArrayOf(1, 0), intArrayOf(-1, 0), intArrayOf(0, 1), intArrayOf(0, -1))

        // Mark the entrance as visited since it's not an exit.
        val startRow = entrance[0]
        val startCol = entrance[1]
        maze[startRow][startCol] = '+'

        // Start BFS from the entrance, and use a queue `queue` to store all the cells to be visited.
        val queue: Queue<IntArray> = LinkedList()
        queue.offer(intArrayOf(startRow, startCol, 0))

        while (!queue.isEmpty()) {
            val position = queue.poll()
            val row = position[0]
            val col = position[1]
            val distance = position[2]

            // For the current cell, check its four neighbor cells.
            for (dir in dirs) {
                val nextRow = row + dir[0]
                val nextCol = col + dir[1]

                // If there exists an unvisited empty neighbor:
                if (nextRow in 0 until rows && nextCol in 0 until cols && maze[nextRow][nextCol] == '.') {
                    // If this empty cell is an exit, return distance + 1.
                    if (nextRow == 0 || nextRow == rows - 1 || nextCol == 0 || nextCol == cols - 1) {
                        return distance + 1
                    }

                    // Otherwise, add this cell to 'queue' and mark it as visited.
                    maze[nextRow][nextCol] = '+'
                    queue.offer(intArrayOf(nextRow, nextCol, distance + 1))
                }
            }
        }

        // If we finish iterating without finding an exit, return -1.
        return -1
    }
}

fun main() {
    println(
        Solution().nearestExit(
            arrayOf(
                charArrayOf('+', '+', '.', '+'),
                charArrayOf('.', '.', '.', '+'),
                charArrayOf('+', '+', '+', '.')
            ), intArrayOf(1, 2)
        )
    )
}