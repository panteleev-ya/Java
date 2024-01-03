package Day22;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {

    }

    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }
}
