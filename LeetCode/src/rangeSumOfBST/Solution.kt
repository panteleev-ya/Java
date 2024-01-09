package rangeSumOfBST

class Solution {
    var sum = 0

    fun rangeSumBST(root: TreeNode?, low: Int, high: Int): Int {
        sum = 0
        dfs(root, low, high)
        return sum
    }

    fun dfs(root: TreeNode?, low: Int, high: Int) {
        root ?: return

        if (root.`val` in low..high) {
            sum += root.`val`
        }
        dfs(root.right, low, high)
        dfs(root.left, low, high)
    }

    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }
}
