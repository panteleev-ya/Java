package lowestCommonAncestorOfBinaryTreeIII

class Solution {
    class Node(var `val`: Int) {
        var left: Node? = null
        var right: Node? = null
        var parent: Node? = null

        constructor(
            `val`: Int,
            parent: Node? = null,
            left: Node? = null,
            right: Node? = null,
        ) : this(`val`) {
            this.parent = parent
            this.left = left
            this.right = right
        }
    }

    fun lowestCommonAncestor(p: Node?, q: Node?): Node? {
        val setOfParentsOfP: MutableSet<Node?> = HashSet()
        var current = p
        while (current != null) {
            setOfParentsOfP.add(current)
            current = current.parent
        }
        current = q
        while (current != null) {
            if (setOfParentsOfP.contains(current)) {
                return current
            }
            current = current.parent
        }
        return null
    }
}

fun main() {
    val p = Solution.Node(1)
    val q = Solution.Node(2, parent = p)
    println(Solution().lowestCommonAncestor(p, q))
}