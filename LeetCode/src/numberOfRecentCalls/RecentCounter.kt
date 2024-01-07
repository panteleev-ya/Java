package numberOfRecentCalls

import java.util.LinkedList
import java.util.Queue

class RecentCounter {
    val queue: Queue<Int> = LinkedList()

    fun ping(t: Int): Int {
        queue.add(t)
        val edgeValue = t - 3000
        while (queue.peek() < edgeValue) {
            queue.poll()
        }
        return queue.size
    }
}