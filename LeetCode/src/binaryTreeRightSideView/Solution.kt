package binaryTreeRightSideView

import java.util.*

class Solution {
    fun rightSideView(root: TreeNode?): List<Int> {
        val view: MutableList<Int> = ArrayList()
        root ?: return view
        val queue: Queue<TreeNode> = LinkedList()
        queue.add(root)
        while (queue.isNotEmpty()) {
            view.add(queue.peek().`val`) // add first found (most right)
            val layerSize = queue.size
            repeat(layerSize) {
                val current = queue.poll()
                // adds most right found first, then all others
                // we will need ALL of them to find most right in the next layer
                if (current.right != null) {
                    queue.add(current.right)
                }
                if (current.left != null) {
                    queue.add(current.left)
                }
            }
        }
        return view
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
    val root = TreeNode(1, TreeNode(2, TreeNode(4), null), TreeNode(3))
    println(Solution().rightSideView(root))
}