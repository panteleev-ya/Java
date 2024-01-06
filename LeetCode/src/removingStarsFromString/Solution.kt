package removingStarsFromString

class Solution {
    fun removeStars(s: String): String {
        val stringBuilder = StringBuilder()
        var removeCount = 0
        for (i in s.length - 1 downTo 0) {
            if (s[i] == '*') {
                removeCount++
            } else if (removeCount > 0) {
                removeCount--
            } else {
                stringBuilder.append(s[i])
            }
        }
        return stringBuilder.reverse().toString()
    }
}