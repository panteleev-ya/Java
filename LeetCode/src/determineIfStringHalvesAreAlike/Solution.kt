package determineIfStringHalvesAreAlike

class Solution {
    fun halvesAreAlike(s: String): Boolean {
        val chars = s.toCharArray()
        var vowelsCount = 0
        val vowels = setOf('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U')
        val half = chars.size / 2
        for (i in 0 until half) {
            if (vowels.contains(chars[i])) {
                vowelsCount++
            }
        }
        for (i in half until chars.size) {
            if (vowels.contains(chars[i])) {
                vowelsCount--
            }
        }
        return vowelsCount == 0
    }
}
