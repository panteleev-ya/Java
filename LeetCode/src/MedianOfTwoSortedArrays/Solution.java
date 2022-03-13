package MedianOfTwoSortedArrays;

import java.util.ArrayList;
import java.util.Comparator;

public class Solution {
    public static void main(String[] args) {
//        int[][] nums = {{1, 2}, {3, 4}};
        int[][] nums = {{3, 7}, {1, 2}};
        System.out.println(findMedianSortedArrays(nums[0], nums[1]));
    }
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        ArrayList<Integer> arr = new ArrayList<>();
        for (var i: nums1) {
            arr.add(i);
        }
        for (var j: nums2) {
            arr.add(j);
        }
        arr.sort(Comparator.comparingInt(i -> i));
        if (arr.size() % 2 == 1) {
            return (double) arr.get((arr.size()) / 2);
        }
        return (arr.get((arr.size()) / 2) + arr.get((arr.size() - 1) / 2)) / 2.0;
    }
}
