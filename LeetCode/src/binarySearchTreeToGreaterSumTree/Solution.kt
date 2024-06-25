package binarySearchTreeToGreaterSumTree

class Solution {
    fun bstToGst(root: TreeNode?): TreeNode? {
        var sum = 0

        fun helper(node: TreeNode?) {
            if (node == null) {
                return
            }

            helper(node.right)

            sum += node.`val`
            node.`val` = sum

            helper(node.left)
        }

        helper(root)
        return root
    }
}

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}