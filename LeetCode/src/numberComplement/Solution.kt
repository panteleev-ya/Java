package numberComplement

class Solution {
    fun findComplement(num: Int): Int {
        var m = Int.MAX_VALUE
        while (m / 2 >= num) {
            m /= 2
        }
        return m.xor(num)
    }
}

fun main() {
    println(Solution().findComplement(5))
}