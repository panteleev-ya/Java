package Day9;

public class Solution {
    public static void main(String[] args) {

    }

    public int combinationSum4(int[] nums, int target) {
        return calculate(nums, target, new Integer[target + 1]);
    }

    public int calculate(int[] nums, int target, Integer[] calculated) {
        if (target < 0) {
            return 0;
        }

        if (target == 0) {
            return 1;
        }

        if (calculated[target] != null) {
            return calculated[target];
        }

        int count = 0;
        for (int num : nums) {
            count += calculate(nums, target - num, calculated);
        }

        return calculated[target] = count;
    }
}
