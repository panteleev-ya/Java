package nAryTreePostorderTraversal

class Solution {
    fun postorder(root: Node?): List<Int> {
        val result = mutableListOf<Int>()
        dfs(root, result)
        return result
    }

    private fun dfs(node: Node?, result: MutableList<Int>) {
        if (node == null) {
            return
        }
        for (child in node.children) {
            dfs(child, result)
        }
        result.add(node.`val`)
    }
}

class Node(var `val`: Int) {
    var children: List<Node?> = listOf()
}