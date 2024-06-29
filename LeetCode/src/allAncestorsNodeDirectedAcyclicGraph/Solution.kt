package allAncestorsNodeDirectedAcyclicGraph

import java.util.*


class Solution {
    fun getAncestors(n: Int, edges: Array<IntArray>): List<MutableList<Int>> {
        // Create adjacency list
        val adjacencyList: Array<MutableList<Int>> = Array(n) { mutableListOf() }
        for (i in 0 until n) {
            adjacencyList[i] = ArrayList()
        }

        // Fill the adjacency list and indegree array based on the edges
        val indegree = IntArray(n)
        for (edge in edges) {
            val from = edge[0]
            val to = edge[1]
            adjacencyList[from].add(to)
            indegree[to]++
        }

        // Queue for nodes with no incoming edges (starting points for topological sort)
        val nodesWithZeroIndegree: Queue<Int> = LinkedList()
        for (i in indegree.indices) {
            if (indegree[i] == 0) {
                nodesWithZeroIndegree.add(i)
            }
        }

        // List to store the topological order of nodes
        val topologicalOrder: MutableList<Int> = ArrayList()
        while (!nodesWithZeroIndegree.isEmpty()) {
            val currentNode = nodesWithZeroIndegree.poll()
            topologicalOrder.add(currentNode)

            // Reduce indegree of neighboring nodes and add them to the queue
            // if they have no more incoming edges
            for (neighbor in adjacencyList[currentNode]) {
                indegree[neighbor]--
                if (indegree[neighbor] == 0) {
                    nodesWithZeroIndegree.add(neighbor)
                }
            }
        }

        // Initialize the result list and set list for storing ancestors
        val ancestorsList: MutableList<MutableList<Int>> = ArrayList()
        val ancestorsSetList: MutableList<MutableSet<Int>> = ArrayList()
        for (i in 0 until n) {
            ancestorsList.add(ArrayList())
            ancestorsSetList.add(HashSet())
        }

        // Fill the set list with ancestors using the topological order
        for (node in topologicalOrder) {
            for (neighbor in adjacencyList[node]) {
                // Add immediate parent, and other ancestors.
                ancestorsSetList[neighbor].add(node)
                ancestorsSetList[neighbor]
                    .addAll(ancestorsSetList[node])
            }
        }

        // Convert sets to lists and sort them
        for (i in ancestorsList.indices) {
            ancestorsList[i].addAll(ancestorsSetList[i])
            ancestorsList[i].sort()
        }

        return ancestorsList
    }
}