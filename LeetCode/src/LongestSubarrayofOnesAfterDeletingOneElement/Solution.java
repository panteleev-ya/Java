package LongestSubarrayofOnesAfterDeletingOneElement;

public class Solution {
    public static void main(String[] args) {
        int[] nums = {1, 1, 0, 0, 1, 0, 1, 1, 1};
        System.out.println(longestSubarray(nums));
    }

    public static int longestSubarray(int[] nums) {
        int length = 0;
        int indexZero = -1;
        int result = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                if (indexZero != -1) {
                    result = Math.max(i - length - 1, result);
                    length = indexZero + 1;
                }
                indexZero = i;
            }
        }
        if (result == -1) {
            return nums.length - 1;
        }
        result = Math.max(nums.length - length - 1, result);
        return result;
    }
}
