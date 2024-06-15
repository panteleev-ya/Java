package reorderRoutesToMakeAllPathsLeadToTheCityZero

import kotlin.math.abs

class Solution {
    private var edges = 0

    fun dfs(src: Int, vertexes: Array<ArrayList<Int>>, visited: IntArray) {
        visited[src] = 1
        val roomsList = vertexes[src]
        for (item in roomsList) {
            if (visited[abs(item)] == 0) {
                if (item > 0) {
                    edges++
                }
                dfs(abs(item), vertexes, visited)
            }
        }
    }

    fun minReorder(n: Int, connections: Array<IntArray>): Int {
        val visited = IntArray(n) { 0 }
        val graph = Array<ArrayList<Int>>(n) { arrayListOf() }
        for (edge in connections) {
            graph[edge[0]].add(edge[1])
            graph[edge[1]].add(-edge[0])
        }
        for (index in graph.indices) {
            dfs(0, graph, visited)
        }
        return edges
    }
}

fun main() {
    println(
        Solution().minReorder(
            6,
            arrayOf(
                intArrayOf(0, 1),
                intArrayOf(1, 3),
                intArrayOf(2, 3),
                intArrayOf(4, 0),
                intArrayOf(4, 5),
            )
        )
    )
}