package slidingWindowMaximum;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class Solution {
    public static void main(String[] args) {
//        System.out.println(Arrays.toString(new Solution().maxSlidingWindow(new int[]{1, 2, 1, 0, 4, 2, 6}, 3)));
//        System.out.println(Arrays.toString(new Solution().maxSlidingWindow(new int[]{1, -1}, 1)));
        System.out.println(Arrays.toString(new Solution().maxSlidingWindow(new int[]{1, 3, 1, 2, 0, 5}, 3)));
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] output = new int[nums.length - k + 1];
        Deque<Integer> decreasingDeque = new LinkedList<>();
        int left = 0;
        int right = 0;

        while (right < nums.length) {
            while (!decreasingDeque.isEmpty() && nums[decreasingDeque.peekLast()] < nums[right]) {
                decreasingDeque.removeLast();
            }
            decreasingDeque.addLast(right);

            if (left > decreasingDeque.peekFirst()) {
                decreasingDeque.pollFirst();
            }

            if (right + 1 >= k) {
                output[left] = nums[decreasingDeque.peekFirst()];
                left++;
            }

            right++;
        }

        return output;
    }
}
