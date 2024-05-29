package timeTakenToCrossTheDoor

import java.util.*

class Solution {
    fun timeTaken(arrival: IntArray, state: IntArray): IntArray {
        val timings = IntArray(arrival.size)
        val enterQueue = ArrayDeque<Int>()
        val exitQueue = ArrayDeque<Int>()
        var time = 0
        var person = 0
        var isEntering = false
        var doorUsedLastTime = false
        while (person < arrival.size || enterQueue.isNotEmpty() || exitQueue.isNotEmpty()) {
            while (person < arrival.size && arrival[person] == time) {
                when (state[person]) {
                    0 -> enterQueue.offer(person)
                    1 -> exitQueue.offer(person)
                }
                person++
            }
            if (enterQueue.isNotEmpty() || exitQueue.isNotEmpty())  {
                isEntering = if (enterQueue.isNotEmpty() && exitQueue.isNotEmpty()) {
                    doorUsedLastTime && isEntering
                } else {
                    enterQueue.isNotEmpty()
                }
                timings[if (isEntering) enterQueue.poll() else exitQueue.poll()] = time
                doorUsedLastTime = true
            } else {
                doorUsedLastTime = false
            }
            time++
        }
        return timings
    }
}

fun main() {
    val arrival = intArrayOf(0, 1, 1, 2, 4)
    val state = intArrayOf(0, 1, 0, 0, 1)
    println(Solution().timeTaken(arrival, state))
}

