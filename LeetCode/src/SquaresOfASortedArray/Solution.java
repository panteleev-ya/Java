package SquaresOfASortedArray;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int[] nums = {-4, -1, 0, 3, 10};
        System.out.println(Arrays.toString(sortedSquares(nums)));
    }
    public static int[] sortedSquares(int[] nums) {
        int[] squaredNums = new int[nums.length];
        int start = 0;
        int end = nums.length - 1;
        int i = nums.length - 1;
        while (start <= end) {
            int startSquare = nums[start] * nums[start];
            int endSquare = nums[end] * nums[end];
            if (startSquare > endSquare) {
                squaredNums[i] = startSquare;
                start++;
            } else {
                squaredNums[i] = endSquare;
                end--;
            }
            i--;
        }
        return squaredNums;
    }
}
