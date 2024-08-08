package mergeSortedArray

class Solution {
    fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int) {
        var left = m - 1
        var right = n - 1
        for (i in m + n - 1 downTo 0) {
            if (right < 0) {
                break
            }
            if (left >= 0 && nums1[left] > nums2[right]) {
                nums1[i] = nums1[left--]
            } else {
                nums1[i] = nums2[right--]
            }
        }
    }
}