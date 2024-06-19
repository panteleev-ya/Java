package readNCharactersGivenRead4

import kotlin.math.min

/**
 * The read4 API is defined in the parent class Reader4.
 * fun read4(buf4:CharArray): Int {}
 */

class Solution : Reader4() {
    /**
     * @param buf Destination buffer
     * @param n Number of characters to read
     * @return The number of actual characters read
     */
    fun read(buf: CharArray, n: Int): Int {
        var counter = 0
        var resp = -1
        val buf2 = CharArray(4) { ' ' }
        var target: Int
        while (counter < n && resp != 0) {
            resp = read4(buf2)
            target = min(n - counter, resp)
            for (i in 0 until target) {
                buf[counter + i] = buf2[i]
            }
            counter += target
        }
        return counter
    }
}

open class Reader4 {
    private var length = 12  // specify me to test
    fun read4(buf4: CharArray): Int {
        if (length >= 4) {
            length -= 4
            return 4
        }
        val remaining = length
        length = 0
        return remaining
    }
}

fun main() {
    val n = 12
    println(Solution().read(CharArray(n), n))
}