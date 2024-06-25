package appendCharactersToStringToMakeSubsequence

class Solution {
    fun appendCharacters(s: String, t: String): Int {
        var i = 0
        var k = 0
        var found = true
        while (found && i < s.length && k < t.length) {
            found = false
            for (j in i until s.length) {
                if (s[j] == t[k]) {
                    k++
                    i = j + 1
                    found = true
                    break
                }
            }
        }
        return t.length - k
    }
}

fun main() {
    println(Solution().appendCharacters("abcde", "a"))
}