package findCenterOfStarGraph

class Solution {
    fun findCenter(edges: Array<IntArray>): Int {
        val (a, b) = edges[0]
        val (c, d) = edges[1]
        return if (a == c || a == d) a else b
    }
}