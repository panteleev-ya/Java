package ProductOfArrayExceptSelf;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        System.out.println(Arrays.toString(productExceptSelf(nums)));
    }
    public static int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];

        if (nums.length == 2) {
            result[0] = nums[1];
            result[1] = nums[0];
            return result;
        }

        int mul = 1;
        for (int i = 1; i < nums.length; i++) {
            mul *= nums[i - 1];
            result[i] = mul;
        }
        mul = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            mul *= nums[i + 1];
            result[i] *= mul;
        }
        result[0] = mul;
        return result;
    }
}
