package minimumNumberOfOperationsToMakeArrayEmpty

class Solution {
    fun minOperations(nums: IntArray): Int {
        val map = hashMapOf<Int, Int>()
        for (num in nums) {
            map.merge(num, 1) { old, new -> old + new }
        }
        var operationsCount = 0
        for (value in map.values) {
            if (value < 2) {
                return -1
            }
            val mod = value % 3
            when (mod) {
                0 -> operationsCount += value / 3
                1 -> operationsCount += 2 + (value - 4) / 3
                2 -> operationsCount += 1 + (value - 2) / 3
            }
        }
        return operationsCount
    }
}