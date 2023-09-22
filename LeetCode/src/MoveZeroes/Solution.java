package MoveZeroes;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int[] array = new int[]{0, 1, 0, 3, 12};
        moveZeroes(array);
        System.out.println(Arrays.toString(array));
    }
    public static void moveZeroes(int[] nums) {
        int[] movedZeros = new int[nums.length];
        Arrays.fill(movedZeros, 0);
        int notZeroIndex = 0;
        for (int i = 0; i < movedZeros.length; i++) {
            if (nums[i] != 0) {
                movedZeros[notZeroIndex] = nums[i];
                notZeroIndex++;
            }
        }
        System.arraycopy(movedZeros, 0, nums, 0, nums.length);
    }
}
