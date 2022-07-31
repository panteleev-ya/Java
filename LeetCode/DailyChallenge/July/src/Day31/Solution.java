package Day31;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        NumArray array = new NumArray(new int[]{1, 3, 5, 6, 7, 9, 11});
        System.out.println(array.sumRange(0, 6));
        System.out.println(array.sumRange(3, 5));
        System.out.println(array.sumRange(6, 6));
    }

    private static class NumArray {
        private final int[] nums;
        private int sum;
        private final int n;

        public NumArray(int[] nums) {
            this.nums = nums;
            sum = Arrays.stream(nums).sum();
            n = nums.length;
        }

        public void update(int index, int val) {
            sum = sum - nums[index] + val;
            nums[index] = val;
        }

        public int sumRange(int left, int right) {
            if (right - left > n / 2) {
                return sum - (sumNums(0, left - 1) + sumNums(right + 1, n - 1));
            }
            return sumNums(left, right);
        }

        private int sumNums(int l, int r) {
            int s = 0;
            l = Math.max(0, l);
            r = Math.min(r, n - 1);
            for (int i = l; i <= r; i++) {
                s += nums[i];
            }
            return s;
        }
    }
}
