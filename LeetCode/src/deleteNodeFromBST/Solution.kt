package deleteNodeFromBST

class Solution {
    fun deleteNode(root: TreeNode?, key: Int): TreeNode? {
        tailrec fun getNode(current: TreeNode?, prev: TreeNode?): Pair<TreeNode?, TreeNode>? =
            if (current == null) null
            else if (current.`val` == key) prev to current
            else if (current.`val` < key) getNode(current.right, current)
            else getNode(current.left, current)

        val (prev, current) = getNode(root, null) ?: return root

        var leftmost = current.right
        while (leftmost?.left != null) leftmost = leftmost.left
        leftmost?.left = current.left // connect left part

        prev?.run { // connect to prev
            if (left == current) left = current.right ?: current.left
            else right = current.right ?: current.left
        } ?: return current.right ?: current.left

        return root
    }
}

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null

    constructor(`val`: Int, left: TreeNode?, right: TreeNode?) : this(`val`) {
        this.left = left
        this.right = right
    }
}

fun main() {
    println(Solution().deleteNode(null, 1))
}
