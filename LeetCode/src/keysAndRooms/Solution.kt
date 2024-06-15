package keysAndRooms

import java.util.*

class Solution {
    fun canVisitAllRooms(rooms: List<List<Int>>): Boolean {
        val used = BooleanArray(rooms.size) { false }
        val keysQueue: Queue<Int> = LinkedList()
        keysQueue.addAll(rooms[0])
        used[0] = true
        while (keysQueue.isNotEmpty()) {
            val roomIndex = keysQueue.poll()
            if (used[roomIndex]) {
                continue
            }
            keysQueue.addAll(rooms[roomIndex])
            used[roomIndex] = true
        }
        return used.all { it }
    }
}

fun main() {
    println(Solution().canVisitAllRooms(listOf(listOf(1), listOf(2), listOf(3), listOf())))
}