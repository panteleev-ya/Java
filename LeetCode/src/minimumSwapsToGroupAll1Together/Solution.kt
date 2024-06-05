package minimumSwapsToGroupAll1Together

import kotlin.math.max

class Solution {
    fun minSwaps(data: IntArray): Int {
        val ones = data.sum()
        var left = 0
        var right = 0
        var countOnes = 0
        var maxCountOnes = 0
        while (right < data.size) {
            countOnes += data[right++]
            if (right - left > ones) {
                countOnes -= data[left++]
            }
            maxCountOnes = max(maxCountOnes, countOnes)
        }
        return ones - maxCountOnes
    }
}

fun main() {
    println(Solution().minSwaps(intArrayOf(1, 0, 1, 0, 1, 0, 0, 1, 1, 0, 1)))
}
