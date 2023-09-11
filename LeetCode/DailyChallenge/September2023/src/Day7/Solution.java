package Day7;

import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        int[] nums = {3, 5, 0, 3, 4};
        System.out.println(find132pattern(nums));
    }

    public static boolean find132pattern(int[] nums) {
        Stack<Integer> stack = new Stack<>();

        int thirdElement = Integer.MIN_VALUE;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] < thirdElement) {
                return true;
            }
            while (!stack.isEmpty() && stack.peek() < nums[i]) {
                thirdElement = stack.pop();
            }
            stack.push(nums[i]);
        }
        return false;
    }
}
