package pathSumIII

class Solution {
    private var numOfPath = 0

    fun pathSum(root: TreeNode?, targetSum: Int): Int {
        if (root == null) {
            return 0
        }

        val map: MutableMap<Long, Int> = mutableMapOf()
        map[0] = 1
        dfs(root, targetSum, map, 0L)

        return numOfPath
    }

    private fun dfs(node: TreeNode?, targetSum: Int, map: MutableMap<Long, Int>, prefixSum: Long) {
        if (node == null) {
            return
        }

        val currentSum = prefixSum + node.`val`
        numOfPath += map.getOrDefault(currentSum - targetSum, 0)
        map.merge(currentSum, 1) { a, b -> a + b }

        dfs(node.left, targetSum, map, currentSum)
        dfs(node.right, targetSum, map, currentSum)

        // Map only stores info about ways to get HERE, so we can rely on them when counting
        map.merge(currentSum, -1) { a, b -> a + b }
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
//    10,5,-3,3,2,null,11,3,-2,null,1
    val root1 = TreeNode(
        10,
        TreeNode(
            5,
            TreeNode(
                3,
                TreeNode(3),
                TreeNode(-2)
            ),
            TreeNode(
                2,
                null,
                TreeNode(1)
            )
        ),
        TreeNode(
            -3,
            null,
            TreeNode(11)
        )
    )
    println(Solution().pathSum(root1, 8))

//    1,null,2,null,3,null,4,null,5
    val root2 = TreeNode(
        1,
        null,
        TreeNode(
            2,
            null,
            TreeNode(
                3,
                null,
                TreeNode(
                    4,
                    null,
                    TreeNode(5)
                )
            )
        )
    )
    println(Solution().pathSum(root2, 3))

//    1000000000,1000000000,null,294967296,null,1000000000,null,1000000000,null,1000000000
    val root3 = TreeNode(
        1000000000,
        TreeNode(
            1000000000,
            TreeNode(
                294967296,
                TreeNode(
                    1000000000,
                    TreeNode(
                        1000000000,
                        TreeNode(
                            1000000000,
                            null,
                            null
                        ),
                        null
                    ),
                    null
                ),
                null
            ),
            null
        ),
        null
    )
    println(Solution().pathSum(root3, 0))
}