package Day12;

public class Solution {
    public static void main(String[] args) {
        System.out.println(maximumUniqueSubarray(new int[]{4, 2, 4, 5, 6}));
        System.out.println(maximumUniqueSubarray(new int[]{4}));
        System.out.println(maximumUniqueSubarray(new int[]{5, 2, 1, 2, 5, 2, 1, 2, 5}));
    }

    public static int maximumUniqueSubarray(int[] nums) {
        boolean[] uniqueNumsIndexes = new boolean[10001];
        int maxSubArraySum = 0;
        int subArraySum = 0;
        for (int start = 0, end = 0; start < nums.length && end != nums.length; start++) {
            for (; end < nums.length && !uniqueNumsIndexes[nums[end]]; end++) {
                uniqueNumsIndexes[nums[end]] = true;
                subArraySum += nums[end];
            }
            maxSubArraySum = Math.max(maxSubArraySum, subArraySum);
            subArraySum -= nums[start];
            uniqueNumsIndexes[nums[start]] = false;
        }
        return maxSubArraySum;
    }
}
