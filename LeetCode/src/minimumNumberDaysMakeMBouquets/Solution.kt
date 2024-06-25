package minimumNumberDaysMakeMBouquets

class Solution {
    private fun getNumOfBouquets(bloomDay: IntArray, mid: Int, k: Int): Int {
        var numOfBouquets = 0
        var count = 0
        for (i in bloomDay.indices) {
            if (bloomDay[i] <= mid) {
                count++
            } else {
                count = 0
            }
            if (count == k) {
                numOfBouquets++
                count = 0
            }
        }
        return numOfBouquets
    }

    fun minDays(bloomDay: IntArray, m: Int, k: Int): Int {
        var start = 0
        var end = bloomDay.max()
        var minDays = -1
        while (start <= end) {
            val mid = (start + end) / 2
            if (getNumOfBouquets(bloomDay, mid, k) >= m) {
                minDays = mid
                end = mid - 1
            } else {
                start = mid + 1
            }
        }
        return minDays
    }
}

fun main() {
    // println(Solution().minDays(intArrayOf(7, 7, 7, 7, 12, 7, 7), 2, 3))
    println(Solution().minDays(intArrayOf(12, 7, 7, 7, 7, 7, 7), 2, 3))
}