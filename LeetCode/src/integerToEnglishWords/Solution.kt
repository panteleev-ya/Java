package integerToEnglishWords

class Solution {
    fun numberToWords(num: Int): String {
        val belowTwenty = arrayOf(
            "Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten",
            "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen",
            "Nineteen"
        )
        val decades = arrayOf("Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety")
        val bigNumbers = arrayOf("Thousand", "Million", "Billion")

        val revParts = num.toString().reversed().chunked(3)
        val parts = Array(revParts.size) { revParts[revParts.size - 1 - it].reversed().toInt() }

        var bigNumberIndex = parts.size - 2
        val sb = StringBuilder()

        for (i in parts.indices) {
            if (i > 0) {
                if (parts[i] == 0) {
                    bigNumberIndex--
                    continue
                }
                sb.append(" ")
            }
            var x = parts[i]
            var checkNext = true
            if (x >= 100) {
                sb.append(belowTwenty[x / 100])
                sb.append(" Hundred")
                x %= 100
                if (x > 0) {
                    sb.append(" ")
                } else {
                    checkNext = false
                }
            }
            if (checkNext) {
                if (x < 20) {
                    sb.append(belowTwenty[x])
                } else {
                    sb.append(decades[x / 10 - 2])
                    x %= 10
                    if (x > 0) {
                        sb.append(" ")
                        sb.append(belowTwenty[x])
                    }
                }
            }
            if (bigNumberIndex >= 0) {
                sb.append(" ")
                sb.append(bigNumbers[bigNumberIndex])
                bigNumberIndex--
            }
        }
        return sb.toString()
    }
}

fun main() {
    println(Solution().numberToWords(0))
    println(Solution().numberToWords(20))
    println(Solution().numberToWords(123))
    println(Solution().numberToWords(123456))
    println(Solution().numberToWords(1234567))
    println(Solution().numberToWords(1234067))
    println(Solution().numberToWords(2147483647))
}