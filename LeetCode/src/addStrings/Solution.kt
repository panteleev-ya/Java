package addStrings

class Solution {
    fun addStrings(num1: String, num2: String): String {
        val sb = StringBuilder()
        var overflow = 0
        var left = num1.length - 1
        var right = num2.length - 1
        while (left >= 0 || right >= 0) {
            val leftVal = if (left >= 0) num1[left] - '0' else 0
            val rightVal = if (right >= 0) num2[right] - '0' else 0
            val sum = leftVal + rightVal + overflow
            overflow = sum / 10
            sb.append(sum % 10)
            if (left >= 0) {
                left--
            }
            if (right >= 0) {
                right--
            }
        }
        if (overflow > 0) {
            sb.append(overflow)
        }
        return sb.reverse().toString()
    }
}