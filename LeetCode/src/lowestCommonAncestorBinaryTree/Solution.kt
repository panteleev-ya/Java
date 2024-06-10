package lowestCommonAncestorBinaryTree

class Solution {
    class TreeNode(var `val`: Int = 0) {
        var left: TreeNode? = null
        var right: TreeNode? = null

        constructor(`val`: Int, left: TreeNode?, right: TreeNode?) : this(`val`) {
            this.left = left
            this.right = right
        }
    }

    fun lowestCommonAncestor(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {
        if (root == null || root === p || root === q) {
            return root
        }
        val left = lowestCommonAncestor(root.left, p, q)
        val right = lowestCommonAncestor(root.right, p, q)

        return if (left == null) {
            right
        } else if (right == null) {
            left
        } else {
            root
        }
    }
}

fun main() {
    println(Solution().lowestCommonAncestor(null, null, null))
}