package Day3;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int[] nums = {1, 3, 2, 3, 3};
        System.out.println(findUnsortedSubarray(nums));
    }

    public static int findUnsortedSubarray(int[] nums) {
        int n = nums.length;
        int max = nums[0];
        int min = nums[n - 1];

        // Values are chosen to handle edge cases.
        // For unsorted arrays, values will be updated inside the loop.
        int high = 0;
        int low = 1;

        for (int i = 0, j = n - 1; i < n && j >= 0; i++, j--) {
            if (nums[i] < max) {
                high = i;
            }
            if (nums[j] > min) {
                low = j;
            }
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[j]);
        }
        return high - low + 1;
    }
}
