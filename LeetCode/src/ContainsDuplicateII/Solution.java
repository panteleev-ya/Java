package ContainsDuplicateII;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1, 2, 3};
        int k = 2;
        System.out.println(containsNearbyDuplicate(nums, k));
    }

    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        k++;
        Set<Integer> duplicates = new HashSet<>();
        int i;
        for (i = 0; i < Math.min(nums.length, k); i++) {
            if (!duplicates.add(nums[i])) {
                return true;
            }
        }
        for (; i < nums.length; i++) {
            duplicates.remove(nums[i - k]);
            if (!duplicates.add(nums[i])) {
                return true;
            }
        }
        return false;
    }
}
