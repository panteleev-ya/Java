package validPalindromeIV

class Solution {
    fun makePalindrome(s: String): Boolean {
        var left = 0
        var right = s.length - 1
        var moves = 2
        while (left < right) {
            if (s[left] != s[right]) {
                if (moves > 0) {
                    moves--
                } else {
                    return false
                }
            }
            left++
            right--
        }
        return true
    }
}
