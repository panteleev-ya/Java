package binaryTreePreorderTraversal

import java.util.*


class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class Solution {
    fun preorderTraversal(root: TreeNode?): List<Int> {
        val stack = Stack<TreeNode>()
        val output = LinkedList<Int>()
        root ?: return output
        stack.add(root)
        while (stack.isNotEmpty()) {
            val node = stack.pop()
            output.add(node.`val`)
            if (node.right != null) {
                stack.add(node.right)
            }
            if (node.left != null) {
                stack.add(node.left)
            }
        }
        return output
    }
}