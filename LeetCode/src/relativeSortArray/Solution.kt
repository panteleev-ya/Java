package relativeSortArray

class Solution {
    fun relativeSortArray(arr1: IntArray, arr2: IntArray): IntArray {
        return arr1.sortedWith { a, b -> compare(arr2, a, b) }.toIntArray()
    }

    private fun compare(arr2: IntArray, a: Int, b: Int): Int {
        if (a == b) {
            return 0
        }
        var indexA = arr2.size
        var indexB = arr2.size
        for (i in arr2.indices) {
            if (arr2[i] == a) {
                indexA = i
            }
            if (arr2[i] == b) {
                indexB = i
            }
        }
        if (indexA == indexB && indexA == arr2.size) {
            return a - b
        }
        return indexA - indexB
    }
}

fun main() {
    val arr1 = intArrayOf(2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19)
    val arr2 = intArrayOf(2, 1, 4, 3, 9, 6)
    println(Solution().relativeSortArray(arr1, arr2).contentToString())
}