package countNumberOfTeams

class Solution {
    fun numTeams(rating: IntArray): Int {
        var counter = 0
        for (j in rating.indices) {
            var leftLess = 0
            var leftGreater = 0
            for (i in j - 1 downTo 0) {
                if (rating[i] < rating[j]) {
                    leftLess++
                } else {
                    leftGreater++
                }
            }

            var rightLess = 0
            var rightGreater = 0
            for (k in j + 1 until rating.size) {
                if (rating[j] < rating[k]) {
                    rightGreater++
                } else {
                    rightLess++
                }
            }

            counter += leftLess * rightGreater + leftGreater * rightLess
        }

        return counter
    }
}