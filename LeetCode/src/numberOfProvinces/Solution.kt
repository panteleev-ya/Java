package numberOfProvinces

class Solution {
    fun findCircleNum(isConnected: Array<IntArray>): Int {
        val visited = BooleanArray(isConnected.size) { false }
        var counter = 0
        for (i in isConnected.indices) {
            if (!visited[i]) {
                dfs(i, isConnected, visited)
                counter++
            }
        }
        return counter
    }

    private fun dfs(i: Int, isConnected: Array<IntArray>, visited: BooleanArray) {
        visited[i] = true
        for (j in isConnected[i].indices) {
            if (isConnected[i][j] == 1 && !visited[j]) {
                dfs(j, isConnected, visited)
            }
        }
    }
}