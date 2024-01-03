package numberOfLaserBeamsInBank

class Solution {
    fun numberOfBeams(bank: Array<String>): Int {
        var multiplier = 0
        var sum = 0
        for (line in bank) {
            var count = 0
            for (c in line.toCharArray()) {
                if (c == '1') {
                    count++
                }
            }
            if (count != 0) {
                sum += multiplier * count
                multiplier = count
            }
        }
        return sum
    }
}