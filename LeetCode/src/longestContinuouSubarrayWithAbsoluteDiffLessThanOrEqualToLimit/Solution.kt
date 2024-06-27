package longestContinuouSubarrayWithAbsoluteDiffLessThanOrEqualToLimit

import java.util.*
import kotlin.math.max


class Solution {
    fun longestSubarray(nums: IntArray, limit: Int): Int {
        val maxDeque: Deque<Int> = LinkedList()
        val minDeque: Deque<Int> = LinkedList()
        var left = 0
        var maxLength = 0

        for (right in nums.indices) {
            // Maintain the maxDeque in decreasing order
            while (!maxDeque.isEmpty() && maxDeque.peekLast() < nums[right]) {
                maxDeque.pollLast()
            }
            maxDeque.offerLast(nums[right])

            // Maintain the minDeque in increasing order
            while (!minDeque.isEmpty() && minDeque.peekLast() > nums[right]) {
                minDeque.pollLast()
            }
            minDeque.offerLast(nums[right])

            // Check if the current window exceeds the limit
            while (maxDeque.peekFirst() - minDeque.peekFirst() > limit) {
                // Remove the elements that are out of the current window
                if (maxDeque.peekFirst() == nums[left]) {
                    maxDeque.pollFirst()
                }
                if (minDeque.peekFirst() == nums[left]) {
                    minDeque.pollFirst()
                }
                left++
            }

            maxLength = max(maxLength, (right - left + 1))
        }

        return maxLength
    }
}