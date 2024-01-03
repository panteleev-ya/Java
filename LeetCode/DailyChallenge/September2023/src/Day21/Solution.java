package Day21;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().findMedianSortedArrays(new int[]{1, 3}, new int[]{2}));
        System.out.println(new Solution().findMedianSortedArrays(new int[]{1, 3}, new int[]{2, 4}));
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        List<Integer> nums = new ArrayList<>();
        for (var i : nums1) {
            nums.add(i);
        }
        for (var j : nums2) {
            nums.add(j);
        }
        nums.sort(Comparator.comparingInt(i -> i));
        if (nums.size() % 2 == 1) {
            return (double) nums.get((nums.size()) / 2);
        } else {
            return (nums.get((nums.size()) / 2) + nums.get((nums.size() - 1) / 2)) / 2.0;
        }
    }
}
