package findMinimumTimeToFinishAllJobsII

import java.util.*
import kotlin.math.max


class Solution {
    fun minimumTime(jobs: IntArray, workers: IntArray): Int {
        Arrays.sort(jobs)
        Arrays.sort(workers)
        var answer = 0
        for (i in jobs.indices) {
            answer = max(--jobs[i] / workers[i] + 1, answer)
        }
        return answer
    }
}

fun main() {
    println(Solution().minimumTime(intArrayOf(5, 2, 4), intArrayOf(1, 7, 5)))
}