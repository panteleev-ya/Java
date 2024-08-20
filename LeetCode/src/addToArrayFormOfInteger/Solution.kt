package addToArrayFormOfInteger

class Solution {
    fun addToArrayForm(num: IntArray, k: Int): List<Int> {
        val n: Int = num.size
        var currentK = k
        val result = mutableListOf<Int>()

        var i = n
        while (--i >= 0 || currentK > 0) {
            if (i >= 0) {
                currentK += num[i]
            }
            result.add(currentK % 10)
            currentK /= 10
        }

        return result.reversed()
    }
}