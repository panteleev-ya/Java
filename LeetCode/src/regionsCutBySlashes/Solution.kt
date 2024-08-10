package regionsCutBySlashes

class Solution {
    private lateinit var parent: IntArray
    private lateinit var rank: IntArray

    private fun find(x: Int): Int {
        if (parent[x] != x) {
            parent[x] = find(parent[x]) // Path compression
        }
        return parent[x]
    }

    private fun union(x: Int, y: Int) {
        val rootX = find(x)
        val rootY = find(y)

        if (rootX != rootY) {
            when {
                rank[rootX] > rank[rootY] -> parent[rootY] = rootX
                rank[rootX] < rank[rootY] -> parent[rootX] = rootY
                else -> {
                    parent[rootY] = rootX
                    rank[rootX]++
                }
            }
        }
    }

    fun regionsBySlashes(grid: Array<String>): Int {
        val n = grid.size
        val size = n * n * 4

        parent = IntArray(size) { it }
        rank = IntArray(size) { 0 }

        for (i in 0 until n) {
            for (j in 0 until n) {
                val index = (i * n + j) * 4
                val c = grid[i][j]

                // Union the parts of a cell
                if (c == '/') {
                    union(index, index + 3)
                    union(index + 1, index + 2)
                } else if (c == '\\') {
                    union(index, index + 1)
                    union(index + 2, index + 3)
                } else {
                    union(index, index + 1)
                    union(index + 1, index + 2)
                    union(index + 2, index + 3)
                }

                // Union with right cell
                if (j + 1 < n) {
                    union(index + 1, (index + 4) + 3)
                }

                // Union with bottom cell
                if (i + 1 < n) {
                    union(index + 2, (index + n * 4) + 0)
                }
            }
        }

        // Count the number of regions
        return (0 until size).count { find(it) == it }
    }
}

fun main() {
    println(Solution().regionsBySlashes(arrayOf("\\/\\ ", " /\\/", " \\/ ", "/ / ")))
}