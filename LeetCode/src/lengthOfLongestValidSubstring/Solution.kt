package lengthOfLongestValidSubstring

class Solution {
    fun longestValidSubstring(word: String, forbidden: List<String>): Int {
        var maxLength = 0
        var lowerLimit = 0
        val forbiddenSet = HashSet<String>(forbidden)
        for (upperLimit in 1..word.length) {
            for (pointer in upperLimit - 1 downTo lowerLimit) {
                if (upperLimit - pointer > 10) {
                    break
                } else if (word.substring(pointer, upperLimit) in forbiddenSet) {
                    lowerLimit = pointer + 1
                    break
                }
            }
            maxLength = maxOf(maxLength, upperLimit - lowerLimit)
        }
        return maxLength
    }
}