package kokoEatingBananas

class Solution {
    fun minEatingSpeed(piles: IntArray, h: Int): Int {
        var min = 1
        var max = piles.max()
        while (min != max) {
            val middle = (min + max) / 2
            var hoursTaken = 0
            for (pile in piles) {
                hoursTaken += pile / middle
                if (pile % middle > 0) {
                    hoursTaken++
                }
            }
            if (hoursTaken > h) {
                min = middle + 1
            } else {
                max = middle
            }
        }
        return min
    }
}