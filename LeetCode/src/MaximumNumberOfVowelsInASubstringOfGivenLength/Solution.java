package MaximumNumberOfVowelsInASubstringOfGivenLength;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().findMaxAverage(new int[]{4, 2, 1, 3, 3}, 2));
    }

    public double findMaxAverage(int[] nums, int k) {
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        int maxSum = sum;
        for (int i = k; i < nums.length; i++) {
            sum = sum - nums[i - k] + nums[i];
            maxSum = Math.max(sum, maxSum);
        }
        return (double) maxSum / k;
    }
}
