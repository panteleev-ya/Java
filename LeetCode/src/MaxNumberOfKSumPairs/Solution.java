package MaxNumberOfKSumPairs;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
//        System.out.println(new Solution().maxOperations(new int[]{1, 2, 3, 4}, 5));
        System.out.println(new Solution().maxOperations(new int[]{3, 1, 3, 4, 3}, 6));
    }

    public int maxOperations(int[] nums, int k) {
        int left = 0;
        int right = nums.length - 1;
        Arrays.sort(nums);
        int iterations = 0;
        while (left < right) {
            int v = nums[left] + nums[right];
            if (v == k) {
                iterations++;
                left++;
                right--;
            } else if (v > k) {
                right--;
            } else {
                left++;
            }
        }
        return iterations;
    }
}
