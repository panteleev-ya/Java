package amountOfTimeForBinaryTreeToBeInfected

import java.util.*
import kotlin.math.abs
import kotlin.math.max
import kotlin.math.min

class Solution {
    fun amountOfTime(root: TreeNode?, start: Int): Int {
        var result = 0

        fun dfs(node: TreeNode?): Int {
            if (node == null) {
                return 0
            }

            val left = dfs(node.left)
            val right = dfs(node.right)

            if (node.`val` == start) {
                result = max(result, max(left, right))
                return -1
            } else {
                if (left >= 0 && right >= 0) {
                    return 1 + max(left, right)
                }

                result = max(result, abs(left) + abs(right))
                return min(left, right) - 1
            }
        }

        dfs(root)

        return result
    }
}

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

fun main() {
//    val root = buildTree(listOf(1, 2, null, 3, null, 4, null, 5))
    val root = buildTree(listOf(1, 5, 3, null, 4, 10, 6, 9, 2, 7))
    println(Solution().amountOfTime(root, 6))
}

fun buildTree(testCase: Collection<Int?>): TreeNode? {
    if (testCase.isEmpty()) {
        return null
    }
    val valuesQueue: Queue<Int?> = LinkedList()
    for (value in testCase) {
        valuesQueue.add(value)
    }
    val nodesQueue: Queue<TreeNode> = LinkedList()
    val rootValue = valuesQueue.poll() ?: return null
    val root = TreeNode(rootValue)
    nodesQueue.add(root)
    while (valuesQueue.isNotEmpty()) {
        val node = nodesQueue.poll()
        val leftValue = valuesQueue.poll()
        if (leftValue != null) {
            node.left = TreeNode(leftValue)
            nodesQueue.add(node.left)
        }
        if (valuesQueue.isNotEmpty()) {
            val rightValue = valuesQueue.poll()
            if (rightValue != null) {
                node.right = TreeNode(rightValue)
                nodesQueue.add(node.right)
            }
        }
    }
    return root
}
