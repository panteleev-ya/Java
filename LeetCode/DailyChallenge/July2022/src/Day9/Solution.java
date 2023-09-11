package Day9;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().maxResult(new int[]{1, -1, -2, 4, -7, 3}, 2));
        System.out.println(new Solution().maxResult(new int[]{10, -5, -2, 4, 0, 3}, 3));
        System.out.println(new Solution().maxResult(new int[]{1, -5, -20, 4, -1, 3, -6, -3}, 2));
    }

    public int maxResult(int[] nums, int k) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int maxNum = nums[0], maxNumIndex = 0;
        for (int i = 1; i < nums.length; i++) {
            if (i - k > 0 && maxNumIndex < i - k) {
                maxNum = dp[i - k];
                maxNumIndex = i - k;
                for (int j = i - k + 1; j < i; j++) {
                    if (dp[j] >= maxNum) {
                        maxNum = dp[j];
                        maxNumIndex = j;
                    }
                }
            }
            dp[i] = maxNum + nums[i];
            if (dp[i] >= maxNum) {
                maxNum = dp[i];
                maxNumIndex = i;
            }
        }
        return dp[nums.length - 1];
    }
}
