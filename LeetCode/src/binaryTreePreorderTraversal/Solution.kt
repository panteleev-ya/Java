package binaryTreePreorderTraversal

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class Solution {
    fun preorderTraversal(root: TreeNode?): List<Int> {
        fun goDeeper(node: TreeNode?, list: MutableList<Int>) {
            node ?: return
            list.add(node.`val`)
            goDeeper(node.left, list)
            goDeeper(node.right, list)
        }

        val result = mutableListOf<Int>()
        goDeeper(root, result)
        return result
    }
}