package patchingArray

class Solution {
    fun minPatches(nums: IntArray, n: Int): Int {
        var patches = 0
        var i = 0
        var miss = 1L // use long to avoid integer overflow error
        while (miss <= n) {
            if (i < nums.size && nums[i] <= miss) { // miss is covered
                miss += nums[i]
                i++
            } else { // patch miss to the array
                miss += miss
                patches++ // increase the answer
            }
        }
        return patches
    }
}

fun main() {
    println(Solution().minPatches(intArrayOf(1, 5, 10), 20))
}