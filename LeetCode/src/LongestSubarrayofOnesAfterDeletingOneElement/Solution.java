package LongestSubarrayofOnesAfterDeletingOneElement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public static void main(String[] args) {
        int[] nums = {0, 0, 1, 1};
        System.out.println(longestSubarray(nums));
    }
    public static int longestSubarray(int[] nums) {
        ArrayList<Integer> ranges = new ArrayList<>();
        ArrayList<Integer> pairs = new ArrayList<>();
        int i = 0;
        int sum = 0;

        // Собираем длины диапазонов 1-иц
        for (; i < nums.length; i++) {
            if (nums[i] == 1) {
                sum++;
            } else {
                ranges.add(sum);
                sum = 0;
            }
        }
        if (sum > 0) {
            ranges.add(sum);
        }

        // Собираем суммы соседей
        for (i = 1; i < ranges.size(); i++) {
            pairs.add(ranges.get(i - 1) + ranges.get(i));
        }

        // Нет нулей
        if (pairs.size() == 0) {
            if (ranges.size() == 0) {
                return 0;
            }
            return ranges.get(0) - 1;
        }

        // Ищем максимум
        return pairs.stream().max(Comparator.comparingInt(i2 -> i2)).get();
    }
}
