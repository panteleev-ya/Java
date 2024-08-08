package makeTwoArraysEqualByReversingSubarrays

class Solution {
    fun canBeEqual(target: IntArray, arr: IntArray): Boolean {
        val map = HashMap<Int, Int>()
        for (num in target) {
            map.merge(num, 1) { a, b -> a + b }
        }
        for (num in arr) {
            map.merge(num, -1) { a, b -> a + b }
        }
        for ((num, count) in map) {
            if (count != 0) {
                return false
            }
        }
        return true
    }
}