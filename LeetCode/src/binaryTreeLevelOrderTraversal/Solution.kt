package binaryTreeLevelOrderTraversal

import java.util.*


class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class Solution {
    fun levelOrder(root: TreeNode?): List<List<Int>> {
        val result = mutableListOf<MutableList<Int>>()
        var queue: Queue<TreeNode?> = LinkedList()
        queue.add(root)
        while (queue.isNotEmpty()) {
            val tmpQueue: Queue<TreeNode?> = LinkedList()
            val level = mutableListOf<Int>()
            while (queue.isNotEmpty()) {
                val node = queue.poll() ?: continue
                level.add(node.`val`)
                tmpQueue.add(node.left)
                tmpQueue.add(node.right)
            }
            queue = tmpQueue
            if (level.isNotEmpty()) {
                result.add(level)
            }
        }
        return result
    }
}
