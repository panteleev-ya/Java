package ipo

import java.util.*


class Solution {
    fun findMaximizedCapital(k: Int, w: Int, profits: IntArray, capital: IntArray): Int {
        var currentCapital = w
        val n = profits.size
        val projects = arrayOfNulls<Project>(n)
        for (i in 0 until n) {
            projects[i] = Project(capital[i], profits[i])
        }
        Arrays.sort(projects)
        val profitsPriorityQueue = PriorityQueue(n, Collections.reverseOrder<Int>())
        var index = 0
        for (i in 0 until k) {
            while (index < n && projects[index]!!.capital <= currentCapital) {
                profitsPriorityQueue.add(projects[index++]!!.profit)
            }
            if (profitsPriorityQueue.isEmpty()) {
                break
            }
            currentCapital += profitsPriorityQueue.poll()
        }
        return currentCapital
    }
}

class Project(var capital: Int, var profit: Int) : Comparable<Project> {
    override fun compareTo(other: Project): Int {
        return capital - other.capital
    }
}

fun main() {
//    println(Solution().findMaximizedCapital(2, 0, intArrayOf(1, 2, 3), intArrayOf(0, 1, 1)))
//    println(Solution().findMaximizedCapital(2, 0, intArrayOf(1, 2, 3), intArrayOf(0, 9, 10)))
    println(Solution().findMaximizedCapital(1, 0, intArrayOf(1, 2, 3), intArrayOf(1, 1, 2)))
}