package removeMaxNumberOfEdgesToKeepGraphFullyTraversable

class Solution {
    fun maxNumEdgesToRemove(n: Int, edges: Array<IntArray>): Int {
        val unionFindAlice = UnionFind(n)
        val unionFindBob = UnionFind(n)
        var edgesUsed = 0

        // Process type 3 edges first
        for (edge in edges) {
            if (edge[0] == 3) {
                val aliceConnected = unionFindAlice.union(edge[1] - 1, edge[2] - 1)
                val bobConnected = unionFindBob.union(edge[1] - 1, edge[2] - 1)
                if (aliceConnected || bobConnected) {
                    edgesUsed++
                }
            }
        }

        // Process type 1 edges for Alice
        for (edge in edges) {
            if (edge[0] == 1) {
                if (unionFindAlice.union(edge[1] - 1, edge[2] - 1)) {
                    edgesUsed++
                }
            }
        }

        // Process type 2 edges for Bob
        for (edge in edges) {
            if (edge[0] == 2) {
                if (unionFindBob.union(edge[1] - 1, edge[2] - 1)) {
                    edgesUsed++
                }
            }
        }

        // Check if both Alice and Bob can traverse the entire graph
        if (unionFindAlice.isConnected() && unionFindBob.isConnected()) {
            return edges.size - edgesUsed
        } else {
            return -1
        }
    }
}

class UnionFind(n: Int) {
    private val parent = IntArray(n) { it }
    private val rank = IntArray(n) { 1 }
    private var components = n

    fun find(x: Int): Int {
        if (parent[x] != x) {
            parent[x] = find(parent[x]) // Path compression
        }
        return parent[x]
    }

    fun union(x: Int, y: Int): Boolean {
        val rootX = find(x)
        val rootY = find(y)
        if (rootX != rootY) {
            if (rank[rootX] > rank[rootY]) {
                parent[rootY] = rootX
            } else if (rank[rootX] < rank[rootY]) {
                parent[rootX] = rootY
            } else {
                parent[rootY] = rootX
                rank[rootX]++
            }
            components--
            return true
        }
        return false
    }

    fun isConnected(): Boolean {
        return components == 1
    }
}
