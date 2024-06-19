package maximumLevelSumBinaryTree

import java.util.*

class Solution {
    fun maxLevelSum(root: TreeNode?): Int {
        root ?: return 0
        var levelWithMaxSum = 1
        var maxSum = Int.MIN_VALUE
        var currentLevel = 0
        val levelQueue: Queue<TreeNode> = LinkedList()
        levelQueue.add(root)
        while (levelQueue.isNotEmpty()) {
            currentLevel++
            val levelSize = levelQueue.size
            var levelSum = 0
            repeat(levelSize) {
                val current = levelQueue.poll()
                levelSum += current.`val`
                if (current.left != null) {
                    levelQueue.add(current.left)
                }
                if (current.right != null) {
                    levelQueue.add(current.right)
                }
            }
            if (levelSum > maxSum) {
                maxSum = levelSum
                levelWithMaxSum = currentLevel
            }
        }
        return levelWithMaxSum
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

}