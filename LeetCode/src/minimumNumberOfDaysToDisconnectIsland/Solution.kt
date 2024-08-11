package minimumNumberOfDaysToDisconnectIsland

import kotlin.math.min

class Solution {
    private val directions = arrayOf(
        intArrayOf(0, 1),
        intArrayOf(1, 0),
        intArrayOf(0, -1),
        intArrayOf(-1, 0),
    )

    fun minDays(grid: Array<IntArray>): Int {
        val rows = grid.size
        val cols = grid[0].size
        val apInfo = ArticulationPointInfo(false, 0)
        var landCells = 0
        var islandCount = 0

        // Arrays to store information for each cell
        val discoveryTime = Array(rows) { IntArray(cols) { -1 } }
        val lowestReachable = Array(rows) { IntArray(cols) { -1 } }
        val parentCell = Array(rows) { IntArray(cols) { -1 } }

        // Traverse the grid to find islands and articulation points
        for (i in 0 until rows) {
            for (j in 0 until cols) {
                if (grid[i][j] == 1) {
                    landCells++
                    if (discoveryTime[i][j] == -1) {
                        findArticulationPoints(
                            grid,
                            i,
                            j,
                            discoveryTime,
                            lowestReachable,
                            parentCell,
                            apInfo
                        )
                        islandCount++
                    }
                }
            }
        }

        // Determine the minimum number of days to disconnect the grid
        if (islandCount == 0 || islandCount >= 2) {
            return 0
        }

        if (landCells == 1) {
            return 1
        }

        if (apInfo.hasArticulationPoint) {
            return 1
        }

        return 2
    }

    private fun findArticulationPoints(
        grid: Array<IntArray>,
        row: Int,
        col: Int,
        discoveryTime: Array<IntArray>,
        lowestReachable: Array<IntArray>,
        parentCell: Array<IntArray>,
        apInfo: ArticulationPointInfo
    ) {
        val cols = grid[0].size
        discoveryTime[row][col] = apInfo.time
        apInfo.time++
        lowestReachable[row][col] = discoveryTime[row][col]
        var children = 0

        // Explore all adjacent cells
        for (direction in directions) {
            val newRow = row + direction[0]
            val newCol = col + direction[1]
            if (isValidLandCell(grid, newRow, newCol)) {
                if (discoveryTime[newRow][newCol] == -1) {
                    children++
                    parentCell[newRow][newCol] = row * cols + col // Set parent
                    findArticulationPoints(
                        grid,
                        newRow,
                        newCol,
                        discoveryTime,
                        lowestReachable,
                        parentCell,
                        apInfo
                    )

                    // Update the lowest reachable time
                    lowestReachable[row][col] = min(
                        lowestReachable[row][col].toDouble(),
                        lowestReachable[newRow][newCol].toDouble()
                    ).toInt()

                    // Check for articulation point condition
                    if (lowestReachable[newRow][newCol] >=
                        discoveryTime[row][col] &&
                        parentCell[row][col] != -1
                    ) {
                        apInfo.hasArticulationPoint = true
                    }
                } else if (newRow * cols + newCol != parentCell[row][col]) {
                    // Update the lowest reachable time for back edge
                    lowestReachable[row][col] = min(
                        lowestReachable[row][col].toDouble(),
                        discoveryTime[newRow][newCol].toDouble()
                    ).toInt()
                }
            }
        }

        // Root of DFS tree is an articulation point if it has more than one child
        if (parentCell[row][col] == -1 && children > 1) {
            apInfo.hasArticulationPoint = true
        }
    }

    // Check if the given cell is a valid land cell
    private fun isValidLandCell(grid: Array<IntArray>, row: Int, col: Int): Boolean {
        val rows = grid.size
        val cols = grid[0].size
        return (row >= 0 && col >= 0 && row < rows && col < cols && grid[row][col] == 1)
    }
}

class ArticulationPointInfo(var hasArticulationPoint: Boolean, var time: Int)
