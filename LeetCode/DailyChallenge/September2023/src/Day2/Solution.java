package Day2;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int[] nums = {3, 1, 2, 4};
        System.out.println(Arrays.toString(sortArrayByParity(nums)));
    }

    public static int[] sortArrayByParity(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        // From left and right borders to the middle
        while (left < right) {
            if (nums[left] % 2 == 1) {
                // If left num is not even -> move it to the right
                if (nums[right] % 2 == 0) {
                    // If right num is even -> swap it with the left num
                    int temp = nums[left];
                    nums[left] = nums[right];
                    nums[right] = temp;

                    // Left num swapped -> move to the next left num
                    left++;
                }

                // Looking for next right num to be swapped with the left num
                right--;
            } else {
                // If left num is even -> it is on its place, skip it
                left++;
            }
        }
        return nums;
    }
}
