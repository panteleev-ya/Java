package heightChecker

import java.util.*

class Solution {
    fun heightChecker(heights: IntArray): Int {
        val expected = IntArray(heights.size) { heights[it] }
        Arrays.sort(expected)
        var counter = 0
        for (i in heights.indices) {
            if (heights[i] != expected[i]) {
                counter++
            }
        }
        return counter
    }
}