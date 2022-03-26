package SubarraySumsDivisibleByK;

public class Solution {
    public static void main(String[] args) {
//        int[] nums = {4,5,0,-2,-3,1};
        int[] nums = { 8, 9, 7, 8, 9 };
        int k = 8;
        System.out.println(subarraysDivByK(nums, k));
    }

    public static int subarraysDivByK(int[] nums, int k) {
        int counter = 0;
        int[] modules = new int[k];
        modules[0] = 1;
        int sum = 0;
        for (int num : nums) {
            sum = (sum + num) % k;
            if (sum < 0) {
                sum += k;
            }
            if (modules[sum] > 0) {
                counter += modules[sum];
            }
            modules[sum]++;
        }
        return counter;
    }
}
