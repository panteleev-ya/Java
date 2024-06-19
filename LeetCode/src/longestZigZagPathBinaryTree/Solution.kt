package longestZigZagPathBinaryTree

import kotlin.math.max

class Solution {
    fun longestZigZag(root: TreeNode?): Int {
        return max(
            zigZag(root, 0, false),
            zigZag(root, 0, true)
        )
    }

    private fun zigZag(node: TreeNode?, length: Int, isLeft: Boolean): Int {
        if (node == null) {
            return length - 1
        }
        if (isLeft) {
            return max(
                zigZag(node.left, 1, true),
                zigZag(node.right, length + 1, false),
            )
        }
        return max(
            zigZag(node.left, length + 1, true),
            zigZag(node.right, 1, false),
        )
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
    val root1 = TreeNode(
        1,
        null,
        TreeNode(
            1,
            TreeNode(1),
            TreeNode(
                1,
                TreeNode(
                    1,
                    null,
                    TreeNode(
                        1,
                        null,
                        TreeNode(1)
                    )
                ),
                TreeNode(1)
            )
        )
    )
    println(Solution().longestZigZag(root1))

//    1,1,1,null,1,null,null,1,1,null,1
    val root2 = TreeNode(
        1,
        TreeNode(
            1,
            null,
            TreeNode(
                1,
                TreeNode(
                    1,
                    null,
                    TreeNode(1)
                ),
                TreeNode(1)
            )
        ),
        TreeNode(1)
    )
    println(Solution().longestZigZag(root2))
}