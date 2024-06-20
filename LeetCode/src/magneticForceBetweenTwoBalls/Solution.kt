package magneticForceBetweenTwoBalls

import java.util.Arrays

class Solution {
    fun maxDistance(position: IntArray, m: Int): Int {
        Arrays.sort(position)
        var start = 1
        var end = (position.last() - position.first()) / (m - 1)
        while (start != end) {
            val middle = (start + end + 1) / 2
            if (canFit(position, m, middle)) {
                start = middle
            } else {
                end = middle - 1
            }
        }
        return end
    }

    private fun canFit(position: IntArray, m: Int, distance: Int): Boolean {
        var prevPosition = position.first()
        var mm = m - 1
        var i = 1
        while (i < position.size && mm > 0) {
            if (position[i] - prevPosition >= distance) {
                mm--
                prevPosition = position[i]
            }
            i++
        }
        return mm == 0
    }
}

fun main() {
    println(Solution().maxDistance(intArrayOf(1, 2, 3, 4, 7), 3))
}