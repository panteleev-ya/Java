package Day25;

public class Solution {
    public static void main(String[] args) {
        System.out.println(checkPossibility(new int[]{4, 2, 3}));
        System.out.println(checkPossibility(new int[]{4, 2, 1}));
        System.out.println(checkPossibility(new int[]{1, 4, 2, 5}));
        System.out.println(checkPossibility(new int[]{1, 4, 2, 3}));
        System.out.println(checkPossibility(new int[]{3, 4, 2, 5}));
        System.out.println(checkPossibility(new int[]{3, 4, 2, 3}));
    }

    public static boolean checkPossibility(int[] nums) {
        if (nums.length <= 2) {
            return true;
        }
        boolean hadChanged = false;
        for (int i = 1; i < nums.length; i++) {
            // If nothing is wrong then go next
            if (nums[i - 1] <= nums[i]) {
                continue;
            }

            // If something is wrong, but we can't fix it then return false
            if (hadChanged) {
                return false;
            }

            // If we can fix it
            // We try to fix existing sub array first, then check if we broke other part
            if (i - 2 >= 0) {
                if (nums[i - 2] <= nums[i]) {
                    // nums[i - 1] too big
                    nums[i - 1] = nums[i];
                } else {
                    // nums[i] too small
                    nums[i] = nums[i - 1];
                }
            } else {
                if (nums[i - 1] <= nums[i + 1]) {
                    // nums[i] too small
                    nums[i] = nums[i - 1];
                } else {
                    // nums[i - 1] too big
                    nums[i - 1] = nums[i];
                }
            }

            // We mark that we fixed it
            hadChanged = true;
        }
        return true;
    }
}
