package maximumNumberOfPointsWithCost

import kotlin.math.max

class Solution {
    fun maxPoints(points: Array<IntArray>): Long {
        val cols = points[0].size
        val currentRow = LongArray(cols)
        var previousRow = LongArray(cols)

        for (row in points) {
            // runningMax holds the maximum value generated in the previous iteration of each loop
            var runningMax = 0L

            // Left to right pass
            for (col in 0 until cols) {
                runningMax = max(runningMax - 1, previousRow[col])
                currentRow[col] = runningMax
            }

            runningMax = 0
            // Right to left pass
            for (col in cols - 1 downTo 0) {
                runningMax = max(runningMax - 1, previousRow[col])
                currentRow[col] = max(currentRow[col], runningMax) + row[col]
            }

            // Update previousRow for next iteration
            previousRow = currentRow
        }

        return previousRow.max()
    }
}

fun main() {
    println(
        Solution().maxPoints(
            arrayOf(
                intArrayOf(3, 0, 0, 0, 0, 0, 0),
                intArrayOf(0, 0, 0, 0, 0, 6, 0),
                intArrayOf(3, 0, 0, 0, 0, 0, 0)
            )
        )
    )
}
