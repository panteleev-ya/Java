package uniqueNumberOfOccurrences

class Solution {
    fun uniqueOccurrences(arr: IntArray): Boolean {
        val map = hashMapOf<Int, Int>()
        val set = hashSetOf<Int>()
        arr.forEach{
            map[it] = map.getOrDefault(it, 0) + 1
        }
        for (value in map.values) {
            if (!set.add(value)) {
                return false
            }
        }
        return true
    }
}
