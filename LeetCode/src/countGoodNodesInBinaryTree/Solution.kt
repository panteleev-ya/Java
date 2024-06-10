package countGoodNodesInBinaryTree

class Solution {
    private var count: Int = 0

    fun goodNodes(root: TreeNode?): Int {
        count = 0
        helper(root, Int.MIN_VALUE)
        return count
    }

    private fun helper(root: TreeNode?, maxFound: Int) {
        if (root == null) {
            return
        }
        var updatedMaxFound = maxFound
        if (root.`val` >= maxFound) {
            updatedMaxFound = root.`val`
            count++
        }
        helper(root.left, updatedMaxFound)
        helper(root.right, updatedMaxFound)
    }
}

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}