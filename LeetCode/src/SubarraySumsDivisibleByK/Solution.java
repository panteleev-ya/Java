package SubarraySumsDivisibleByK;

public class Solution {
    public static void main(String[] args) {
        int[] nums = {4,5,0,-2,-3,1};
        int k = 5;
        System.out.println(subArraysDivByK(nums, k));
    }

    public static int subArraysDivByK(int[] nums, int k) {
        // Memory Limit

//        int[][] modules = new int[nums.length][nums.length];
//        int subArraysCounter = 0;
//        int module = 0;
//        for (int j = 0; j < nums.length; j++) {
//            module += nums[j];
//            module = module % k;
//            if (module == 0) {
//                subArraysCounter++;
//            }
//            modules[0][j] = module;
//        }
//
//        for (int i = 1; i < nums.length; i++) {
//            for (int j = i; j < nums.length; j++) {
//                module = (modules[i - 1][j] - modules[i - 1][i - 1]) % k;
//                modules[i][j] = module;
//                if (module == 0) {
//                    subArraysCounter++;
//                }
//            }
//        }
//        return subArraysCounter;


        // Time Limit

        int sum = 0;
        int subArraysCounter = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                sum = sum % k;
                if (sum == 0) {
                    subArraysCounter++;
                }
            }
            sum = 0;
        }
        return subArraysCounter;
    }
}
