package generateParentheses

class Solution {
    fun generateParenthesis(n: Int): List<String> {
        val list = mutableListOf<String>()

        fun makeMove(open: Int, close: Int, comb: String) {
            if (open == 0 && close == 0) {
                list.add(comb)
                return
            }
            if (close > open) {
                makeMove(open, close - 1, "$comb)")
            }
            if (open > 0) {
                makeMove(open - 1, close, "$comb(")
            }
        }

        makeMove(n, n, "")
        return list
    }
}

fun main() {
    println(Solution().generateParenthesis(3))
}