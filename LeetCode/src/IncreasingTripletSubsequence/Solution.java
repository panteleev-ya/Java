package IncreasingTripletSubsequence;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().increasingTriplet(new int[]{99, 98, 10, 97, 96, 20, 1, 30}));
        System.out.println(new Solution().increasingTriplet(new int[]{1, 2, 3, 4, 5}));
        System.out.println(new Solution().increasingTriplet(new int[]{5, 4, 3, 2, 1}));
        System.out.println(new Solution().increasingTriplet(new int[]{2, 1, 5, 0, 4, 6}));
    }

    public boolean increasingTriplet(int[] nums) {
        int left = Integer.MAX_VALUE;
        int middle = Integer.MAX_VALUE;

        for (int num : nums) {
            if (num == left || num == middle) {
                continue;
            }
            if (num < left) {
                left = num;
            } else if (num < middle) {
                middle = num;
            } else {
                return true;
            }
        }
        return false;
    }
}
