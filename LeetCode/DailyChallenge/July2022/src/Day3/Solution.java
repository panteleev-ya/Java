package Day3;

public class Solution {
    public static void main(String[] args) {
        System.out.println(wiggleMaxLength(new int[]{1, 7, 4, 9, 2, 5}));
        System.out.println(wiggleMaxLength(new int[]{1, 17, 5, 10, 13, 15, 10, 5, 16, 8}));
    }

    public static int wiggleMaxLength(int[] nums) {
        int peak = 1;
        int valley = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                peak = valley + 1;
            }
            else if (nums[i] < nums[i - 1]) {
                valley = peak + 1;
            }
        }
        return Math.max(peak, valley);
    }
}
