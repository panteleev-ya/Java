package numberOfStepsToReduceANumberInBinaryRepresentationToOne

class Solution {
    fun numSteps(s: String): Int {
        val chars = ("0$s").toCharArray()
        var i = chars.size - 1
        var sum = 0
        while (chars[i] == '0') {
            sum++
            i--
        }
        while (i != 0) {
            if (chars[0] == '0' && i == 1) {
                break
            }
            sum++
            while (i != 0 && chars[i] != '0') {
                sum++
                i--
            }
            chars[i] = '1'
        }
        return sum
    }
}

fun main() {
    println(Solution().numSteps("10110101"))
//    println(Solution().numSteps("1101"))
}
