package maximumDifferenceBetweenNodeAndAncestor

import amountOfTimeForBinaryTreeToBeInfected.TreeNode
import amountOfTimeForBinaryTreeToBeInfected.buildTree
import kotlin.math.max
import kotlin.math.min

class Solution {
    fun maxAncestorDiff(root: TreeNode?): Int {
        var diff = 0
        fun dfs(node: TreeNode?, minValue: Int, maxValue: Int) {
            if (node == null) {
                diff = max(diff, maxValue - minValue)
                return
            }
            val updMinValue = min(minValue, node.`val`)
            val updMaxValue = max(maxValue, node.`val`)
            dfs(node.left, updMinValue, updMaxValue)
            dfs(node.right, updMinValue, updMaxValue)
        }
        if (root == null) {
            return 0
        }
        dfs(root, root.`val`, root.`val`)
        return diff
    }
}

fun main() {
    val root = buildTree(listOf(8, 3, 10, 1, 6, null, 14, null, null, 4, 7, 13))
    println(Solution().maxAncestorDiff(root))
}
