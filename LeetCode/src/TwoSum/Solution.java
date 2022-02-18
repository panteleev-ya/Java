package TwoSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        int[] nums = new int[]{3, 3};
        int target = 6;
        var indexes = twoSum(nums, target);
        System.out.println(Arrays.toString(indexes));
    }
    public static int[] twoSum(int[] nums, int target) {
        int[] v = Arrays.copyOf(nums, nums.length);
        Arrays.sort(v);

        int first = 0;
        int last = nums.length - 1;

        while (v[first] + v[last] != target) {
            if (v[first] + v[last] > target) {
                last--;
            } else if (v[first] + v[last] < target) {
                first++;
            }
        }

        int a = v[first];
        int b = v[last];
        first = -1;
        last = -1;
        for (int i = 0; i < nums.length; i++) {
            if (first == -1 && nums[i] == a) {
                first = i;
            } else if (last == -1 && nums[i] == b) {
                last = i;
            }
        }
        return new int[]{first, last};
    }
}
