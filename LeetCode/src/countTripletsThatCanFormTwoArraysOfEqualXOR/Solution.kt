package countTripletsThatCanFormTwoArraysOfEqualXOR

class Solution {
    fun countTriplets(arr: IntArray): Int {
        val prefixXOR = IntArray(arr.size + 1)
        prefixXOR[0] = 0
        System.arraycopy(arr, 0, prefixXOR, 1, arr.size)
        // Perform XOR on consecutive elements in the modified array
        for (i in 1 until prefixXOR.size) {
            prefixXOR[i] = prefixXOR[i] xor prefixXOR[i - 1]
        }

        // Iterate through the modified array to count triplets
        var count = 0
        for (start in prefixXOR.indices) {
            for (end in start + 1 until prefixXOR.size) {
                if (prefixXOR[start] == prefixXOR[end]) {
                    // Increment the result by the count of valid triplets
                    count += end - start - 1
                }
            }
        }

        return count
    }
}

fun main() {
    val arr = intArrayOf(2, 3, 1, 6, 7)
    println(Solution().countTriplets(arr))
}
