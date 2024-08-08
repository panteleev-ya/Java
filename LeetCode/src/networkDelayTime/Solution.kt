package networkDelayTime

import java.util.*

class Solution {
    private val graph: MutableMap<Int, MutableList<Neighbor>> = mutableMapOf()

    data class Neighbor(val distance: Int, val value: Int)

    private fun dijkstra(signalReceivedAt: IntArray, source: Int) {
        val queue = PriorityQueue<Neighbor>(compareBy { it.distance })
        queue.add(Neighbor(0, source))
        signalReceivedAt[source] = 0
        while (queue.isNotEmpty()) {
            val (currNodeTime, currNode) = queue.remove()

            if (currNodeTime > signalReceivedAt[currNode]) {
                continue
            }

            if (!graph.containsKey(currNode)) {
                continue
            }

            val neighbors = graph[currNode] ?: emptyList()
            for ((time, neighborNode) in neighbors) {
                val newTime = currNodeTime + time
                if (signalReceivedAt[neighborNode] > newTime) {
                    signalReceivedAt[neighborNode] = newTime
                    queue.add(Neighbor(newTime, neighborNode))
                }
            }
        }
    }

    fun networkDelayTime(times: Array<IntArray>, n: Int, k: Int): Int {
        for ((source, dest, travelTime) in times) {
            val neighbors = graph.getOrPut(source) { mutableListOf() }
            neighbors.add(Neighbor(travelTime, dest))
        }
        val signalReceivedAt = IntArray(n + 1) { Int.MAX_VALUE }
        dijkstra(signalReceivedAt, k)
        val answer = signalReceivedAt.drop(1).max() // zero is not a node
        return if (answer == Int.MAX_VALUE) -1 else answer
    }
}