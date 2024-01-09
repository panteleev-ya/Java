package leafSimilarTrees

class Solution {
    private val sequence1 = mutableListOf<Int>()
    private val sequence2 = mutableListOf<Int>()

    fun leafSimilar(root1: TreeNode?, root2: TreeNode?): Boolean {
        if ((root1 == null) != (root2 == null)) {
            return false
        }
        if (root1 == null) {
            return true
        }
        dfs(root1, sequence1)
        dfs(root2, sequence2)
        return sequence1 == sequence2
    }

    fun dfs(node: TreeNode?, sequence: MutableList<Int>) {
        if (node != null) {
            if (node.left == null && node.right == null) {
                sequence.add(node.`val`)
            }
            dfs(node.left, sequence)
            dfs(node.right, sequence)
        }
    }

    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }
}