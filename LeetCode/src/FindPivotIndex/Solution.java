package FindPivotIndex;

public class Solution {
    public static void main(String[] args) {

    }

    public int pivotIndex(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int leftSum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (sum - nums[i] == leftSum) {
                return i;
            }
            leftSum += nums[i];
            sum -= nums[i];
        }
        return -1;
    }
}
