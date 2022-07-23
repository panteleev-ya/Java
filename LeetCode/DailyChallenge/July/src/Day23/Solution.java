package Day23;

import java.util.Arrays;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().countSmaller(new int[]{5, 2, 6, 1}));
    }

    public List<Integer> countSmaller(int[] nums) {
        // move number range to [1, 20001]
        Arrays.setAll(nums, i -> 10001 + nums[i]);
        Integer[] answer = new Integer[nums.length];

        // allocate enough space for BIT of range [1, 20001]
        int[] bit = new int[20002];
        for (int i = nums.length - 1; i >= 0; i--) {
            // get count by BIT
            int count = 0;
            for (int j = nums[i] - 1; j > 0; j -= j & -j) {
                count += bit[j];
            }
            answer[i] = count;

            // update count in BIT
            for (int j = nums[i]; j < bit.length; j += j & -j) {
                bit[j]++;
            }
        }
        return Arrays.asList(answer);
    }
}
