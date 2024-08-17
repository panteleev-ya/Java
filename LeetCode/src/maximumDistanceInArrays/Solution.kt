package maximumDistanceInArrays

import kotlin.math.abs
import kotlin.math.max
import kotlin.math.min


class Solution {
    fun maxDistance(arrays: List<List<Int>>): Int {
        var result = 0
        var left = arrays[0].first()
        var right = arrays[0].last()
        for (i in 1 until arrays.size) {
            result = max(
                result, max(
                    abs(arrays[i].last() - left),
                    abs(right - arrays[i].first())
                )
            )
            left = min(left, arrays[i].first())
            right = max(right, arrays[i].last())
        }
        return result
    }
}

fun main() {
    println(Solution().maxDistance(arrayListOf(arrayListOf(1, 2, 3), arrayListOf(4, 5), arrayListOf(1, 2, 3))))
}