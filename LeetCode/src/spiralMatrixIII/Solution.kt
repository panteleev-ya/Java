package spiralMatrixIII

import java.util.*
import kotlin.collections.HashSet

class Solution {
    fun spiralMatrixIII(rows: Int, cols: Int, rStart: Int, cStart: Int): Array<IntArray> {
        val cellsSet = HashSet<Cell>()
        for (i in 0 until rows) {
            for (j in 0 until cols) {
                cellsSet.add(Cell(i, j))
            }
        }
        val cellsQueue: Queue<Cell> = LinkedList()
        cellsQueue.add(Cell(rStart, cStart))
        val order = Array(rows * cols) { intArrayOf() }
        var visitedCounter = 0
        var movesCounter = 0
        var distance = 0
        val directions = arrayOf(intArrayOf(0, 1), intArrayOf(1, 0), intArrayOf(0, -1), intArrayOf(-1, 0))
        while (cellsSet.isNotEmpty()) {
            var currentCell = cellsQueue.peek()
            while (cellsQueue.isNotEmpty()) {
                currentCell = cellsQueue.poll()
                if (cellsSet.contains(currentCell)) {
                    order[visitedCounter++] = intArrayOf(currentCell.row, currentCell.col)
                    cellsSet.remove(currentCell)
                }
            }

            val direction = directions[movesCounter % 4]
            distance += (movesCounter + 1) % 2
            for (i in 1..distance) {
                val row = currentCell.row + direction[0] * i
                val col = currentCell.col + direction[1] * i
                cellsQueue.add(Cell(row, col))
            }
            movesCounter++
        }
        return order
    }
}

class Cell(var row: Int, var col: Int) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Cell

        if (row != other.row) return false
        if (col != other.col) return false

        return true
    }

    override fun hashCode(): Int {
        var result = row
        result = 31 * result + col
        return result
    }
}

fun main() {
    println(Solution().spiralMatrixIII(1, 4, 0, 0))
}