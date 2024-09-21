package threeSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int threeSumTarget = 0;
        Arrays.sort(nums);
        List<List<Integer>> triplets = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] > 0) {
                break;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int twoSumTarget = threeSumTarget - nums[i];
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int twoSum = nums[left] + nums[right];
                if (twoSum < twoSumTarget) {
                    left++;
                } else if (twoSum > twoSumTarget) {
                    right--;
                } else {
                    triplets.add(List.of(nums[i], nums[left], nums[right]));
                    left++;
                    right--;

                    // avoiding duplicate triplets
                    while (left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }
                }

            }
        }
        return triplets;
    }
}
