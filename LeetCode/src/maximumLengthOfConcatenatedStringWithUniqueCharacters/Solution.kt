package maximumLengthOfConcatenatedStringWithUniqueCharacters

import kotlin.math.max


class Solution {
    fun maxLength(arr: List<String>): Int {
        // Pre-process arr with an optimizing helper
        // which converts each word to its character bitset
        // and then uses a set to prevent duplicate results
        val optSet: MutableSet<Int> = HashSet()
        for (word in arr) wordToBitSet(optSet, word)


        // Convert the set back to an array for iteration
        // then start up the recursive helper
        val optArr = IntArray(optSet.size)
        var i = 0
        for (num in optSet) optArr[i++] = num
        return dfs(optArr, 0, 0)
    }

    private fun wordToBitSet(optSet: MutableSet<Int>, word: String) {
        // Initialize an empty int to use as a character bitset
        var charBitSet = 0
        for (c in word.toCharArray()) {
            // If the bitset contains a duplicate character
            // then discard this word with an early return
            // otherwise add the character to the bitset
            val mask = 1 shl c.code - 'a'.code
            if ((charBitSet and mask) > 0) return
            charBitSet += mask
        }


        // Store the length of the word in the unused space
        // then add the completed bitset to our optimized set
        optSet.add(charBitSet + (word.length shl 26))
    }

    private fun dfs(optArr: IntArray, pos: Int, res: Int): Int {
        // Separate the parts of the bitset res
        val oldChars = res and ((1 shl 26) - 1)
        val oldLen = res shr 26
        var best = oldLen


        // Iterate through the remaining results
        for (i in pos until optArr.size) {
            val newChars = optArr[i] and ((1 shl 26) - 1)
            val newLen = optArr[i] shr 26


            // If the two bitsets overlap, skip to the next result
            if ((newChars and oldChars) != 0) continue


            // Combine the two results and trigger the next recursion
            val newRes = newChars + oldChars + (newLen + oldLen shl 26)
            best = max(best.toDouble(), dfs(optArr, i + 1, newRes).toDouble()).toInt()
        }
        return best
    }
}

fun main() {
    println(
        Solution().maxLength(
            listOf(
                "a",
                "b",
                "c",
                "d",
                "e",
                "f",
                "g",
                "h",
                "i",
                "j",
                "k",
                "l",
                "m",
                "n",
                "o",
                "p"
            )
        )
    )
}
