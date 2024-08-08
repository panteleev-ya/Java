package satisfiabilityOfEqualityEquations

class Solution {
    fun equationsPossible(equations: Array<String>): Boolean {
        val root = IntArray(26) { it }

        for (eqn in equations) {
            if (eqn[1] == '=') {
                val x = eqn[0].code - 'a'.code
                val y = eqn[3].code - 'a'.code
                union(root, x, y)
            }
        }

        for (eqn in equations) {
            if (eqn[1] == '!') {
                val x = eqn[0].code - 'a'.code
                val y = eqn[3].code - 'a'.code
                if (find(root, x) == find(root, y)) {
                    return false
                }
            }
        }

        return true
    }

    private fun find(root: IntArray, x: Int): Int {
        if (root[x] != x) {
            root[x] = find(root, root[x])
        }
        return root[x]
    }

    private fun union(root: IntArray, x: Int, y: Int) {
        val rootX = find(root, x)
        val rootY = find(root, y)
        if (rootX != rootY) {
            root[rootX] = rootY
        }
    }
}
