package SummaryRanges;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        int[] nums = {0,1,2,4,5,7};
        var result = summaryRanges(nums);
        System.out.println(result);
    }
    public static List<String> summaryRanges(int[] nums) {
        List<String> ranges = new ArrayList<>();
        if (nums.length == 0) {
            return ranges;
        }
        int start = nums[0];
        int prev = nums[0];
        int end = nums[0];
        int index = 1;
        while (index < nums.length) {
            if (nums[index] - prev == 1) {
                prev = nums[index];
                end = prev;
            } else {
                if (end > start) {
                    ranges.add(String.format("%d->%d", start, end));
                } else {
                    ranges.add(String.valueOf(start));
                }
                start = nums[index];
                end = start;
                prev = start;
            }
            index++;
        }
        if (end > start) {
            ranges.add(String.format("%d->%d", start, end));
        } else {
            ranges.add(String.valueOf(start));
        }
        return ranges;
    }
}
