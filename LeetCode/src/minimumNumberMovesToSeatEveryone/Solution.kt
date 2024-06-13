package minimumNumberMovesToSeatEveryone

import java.util.*
import kotlin.math.abs

class Solution {
    fun minMovesToSeat(seats: IntArray, students: IntArray): Int {
        Arrays.sort(seats)
        Arrays.sort(students)
        var sum = 0
        for (i in seats.indices) {
            sum += abs(seats[i] - students[i])
        }
        return sum
    }
}