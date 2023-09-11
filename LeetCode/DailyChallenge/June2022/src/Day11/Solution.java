package Day11;

public class Solution {
    public static void main(String[] args) {
        System.out.println(minOperations(new int[]{1, 1, 4, 2, 3}, 5));
        System.out.println(minOperations(new int[]{5, 6, 7, 8, 9}, 4));
        System.out.println(minOperations(new int[]{3, 2, 20, 1, 1, 3}, 10));
    }

    public static int minOperations(int[] nums, int x) {
        // Counting sum of all nums[i]
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        // Looking for the longest "middle" sub array that subArraySum = numsSum - x;
        int maxMiddleSubArrayLength = -1;
        int middleSubArraySum = 0;
        for (int l = 0, r = 0; r < nums.length; r++) {
            middleSubArraySum += nums[r];
            while (l <= r && middleSubArraySum > sum - x) {
                middleSubArraySum -= nums[l++];
            }
            if (middleSubArraySum == sum - x) {
                maxMiddleSubArrayLength = Math.max(maxMiddleSubArrayLength, r - l + 1);
            }
        }

        return maxMiddleSubArrayLength == -1 ? -1 : nums.length - maxMiddleSubArrayLength;
    }
}
