package SubarraySumEqualsK;

public class Solution {
    public static void main(String[] args) {
        int[] nums = { 1 };
        int k = 1;
        System.out.println(fastSubarraySum(nums, k));
    }
    public static int subarraySum(int[] nums, int k) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum == k) {
                    count++;
                }
            }
        }
        return count;
    }

    // Придумать как использовать идею!
    // sum(0, j) = sums[j]
    // sum(i, j) = sums[j] - sums[i - 1]
    public static int fastSubarraySum(int[] nums, int k) {
        int count = 0;

        // Заполняем значениями все суммы от 0 до всех j
        int[] sums = new int[nums.length];
        sums[0] = nums[0];
        if (nums[0] == k) {
            count++;
        }
        for (int i = 1; i < nums.length; i++) {
            sums[i] = sums[i - 1] + nums[i];
            if (sums[i] == k) {
                count++;
            }
        }

        // Используем полученные данные
        for (int i = 1; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                if (sums[j] - sums[i - 1] == k) {
                    count++;
                }
            }
        }
        return count;
    }
}
