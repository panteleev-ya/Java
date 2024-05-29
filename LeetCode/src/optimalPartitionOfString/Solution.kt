package optimalPartitionOfString

import java.util.*


class Solution {
    fun partitionString(s: String): Int {
        val lastSeen = IntArray(26)
        Arrays.fill(lastSeen, -1)
        var count = 1
        var substringStart = 0
        for (i in s.indices) {
            if (lastSeen[s[i].code - 'a'.code] >= substringStart) {
                count++
                substringStart = i
            }
            lastSeen[s[i].code - 'a'.code] = i
        }
        return count
    }
}

fun main() {
    println(Solution().partitionString("abacaba"))
}