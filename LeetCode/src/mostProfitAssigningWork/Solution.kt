package mostProfitAssigningWork

import java.util.PriorityQueue

class Solution {
    fun maxProfitAssignment(difficulty: IntArray, profit: IntArray, worker: IntArray): Int {
        val jobs: PriorityQueue<Job> = PriorityQueue()
        for (i in difficulty.indices) {
            jobs.add(Job(difficulty[i], profit[i]))
        }
        val workers: PriorityQueue<Int> = PriorityQueue { a, b -> b - a }
        for (i in worker.indices) {
            workers.add(worker[i])
        }
        var totalProfit = 0
        while (jobs.isNotEmpty() && workers.isNotEmpty()) {
            val job = jobs.poll()
            while (workers.isNotEmpty() && workers.peek() >= job.difficulty) {
                totalProfit += job.profit
                workers.poll()
            }
        }
        return totalProfit
    }
}

class Job(val difficulty: Int, val profit: Int) : Comparable<Job> {
    override fun compareTo(other: Job): Int {
        return other.profit - profit
    }
}

fun main() {
    println(
        Solution().maxProfitAssignment(
            intArrayOf(2, 4, 6, 8, 10),
            intArrayOf(10, 20, 30, 40, 50),
            intArrayOf(4, 5, 6, 7)
        )
    )
}