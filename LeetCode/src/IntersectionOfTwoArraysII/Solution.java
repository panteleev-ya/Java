package IntersectionOfTwoArraysII;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int[] nums1 = {1,2,2,1};
        int[] nums2 = {2,2};
        System.out.println(Arrays.toString(intersect(nums1, nums2)));
    }
    public static int[] intersect(int[] nums1, int[] nums2) {
        // Сортируем массивы
        if (isNotSorted(nums1, true)) {
            Arrays.sort(nums1);
        }
        if (isNotSorted(nums2, true)) {
            Arrays.sort(nums2);
        }

        // Получаем "intersection"
        int[] intersection = new int[nums1.length];
        int i = 0, j = 0;
        int k = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                intersection[k] = nums1[i];
                k++;
                i++;
                j++;
            } else if (nums1[i] < nums2[j]){
                i++;
            } else {
                j++;
            }
        }
        return Arrays.copyOf(intersection, k);
    }
    public static boolean isNotSorted(int[] nums, boolean ASC) {
        if (ASC) {
            for (int i = 0; i < nums.length - 1; i++) {
                if (nums[i] > nums[i + 1]) {
                    return true;
                }
            }
        } else {
            for (int i = 0; i < nums.length - 1; i++) {
                if (nums[i] < nums[i + 1]) {
                    return true;
                }
            }
        }
        return false;
    }
}
