package maximumProfitInJobScheduling

import java.util.*
import kotlin.math.max

class Solution {
    class Job(val startTime: Int, val endTime: Int, val profit: Int)

    fun jobScheduling(startTime: IntArray, endTime: IntArray, profit: IntArray): Int {
        val n = startTime.size
        val jobs = Array(n) { i -> Job(startTime[i], endTime[i], profit[i]) }
        jobs.sortBy { it.startTime }
        var maxProfit = 0
        val pq = PriorityQueue<Pair<Int, Int>>(compareBy { it.first }) // stores endTime & profit

        for (job in jobs) {
            while(pq.isNotEmpty() && job.startTime >= pq.peek().first) {
                maxProfit = max(maxProfit, pq.peek().second)
                pq.remove()
            }

            pq.offer(job.endTime to maxProfit + job.profit)
        }

        while(pq.isNotEmpty()) {
            maxProfit = max(maxProfit, pq.peek().second)
            pq.remove()
        }

        return maxProfit
    }
}

fun main() {
    Solution().jobScheduling(intArrayOf(1, 2, 3, 3), intArrayOf(3, 4, 5, 6), intArrayOf(50, 10, 40, 70))
}
