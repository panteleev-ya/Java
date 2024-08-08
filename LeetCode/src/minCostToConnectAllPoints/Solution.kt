package minCostToConnectAllPoints

import kotlin.math.abs


class Solution {
    fun minCostConnectPoints(points: Array<IntArray>): Int {
        val edges = ArrayList<IntArray>()
        for (i in points.indices) {
            for (j in i + 1 until points.size) {
                val weight = abs(points[i][0] - points[j][0]) + abs(points[i][1] - points[j][1])
                val edge = intArrayOf(weight, i, j)
                edges.add(edge)
            }
        }
        edges.sortBy { it[0] }
        val uf = UnionFind(points.size)
        var totalWeight = 0
        var edgesNeeded = points.size - 1
        var i = 0
        while (edgesNeeded > 0) {
            val edge = edges[i]
            i++
            val x = edge[1]
            val y = edge[2]
            if (uf.find(x) == uf.find(y)) {
                continue
            }
            uf.union(x, y)
            totalWeight += edge[0]
            edgesNeeded--
        }
        return totalWeight
    }
}

class UnionFind(verticesCount: Int) {
    private val root = IntArray(verticesCount) { it }
    private val rank = IntArray(verticesCount) { 1 }

    fun find(x: Int): Int {
        var rootX = x
        while (rootX != root[rootX]) {
            rootX = root[rootX]
        }
        return rootX
    }

    fun union(x: Int, y: Int) {
        val rootX = find(x)
        val rootY = find(y)
        if (rootX == rootY) {
            return
        }
        if (rank[rootX] < rank[rootY]) {
            root[rootX] = rootY
        } else if (rank[rootX] > rank[rootY]) {
            root[rootY] = rootX
        } else {
            root[rootX] = rootY
            rank[rootY]++
        }
    }
}