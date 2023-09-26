package MaxConsecutiveOnesIII;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().longestOnes(new int[]{1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0}, 2));
        System.out.println(new Solution().longestOnes(new int[]{0, 0, 0, 1}, 4));
    }

    public int longestOnes(int[] nums, int k) {
        int maxCount = 0;
        int start = 0;
        int end = 0;
        while (end < nums.length) {
            if (nums[end] == 1) {
                end++;
            } else if (k > 0) {
                end++;
                k--;
            } else {
                while (nums[start] == 1) {
                    start++;
                }
                start++;
                k++;
            }
            maxCount = Math.max(maxCount, end - start);
        }
        return maxCount;
    }
}
