package MaxConsecutiveOnesIII;

import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {
        int[] nums = {1,0,0,0,1,1,0,0,1,1,0,0,0,0,0,0,1,1,1,1,0,1,0,1,1,1,1,1,1,0,1,0,1,0,0,1,1,0,1,1};
        int k = 8;
        System.out.println(longestOnes(nums, k));
    }

    public static int longestOnes(int[] nums, int k) {
        int zeroCounter = 0;
        int oneCounter = 0;
        int allZeros = 0;
        ArrayList<Integer[]> ranges = new ArrayList<>();
        int i = 0;
        while (i < nums.length) {
            while (i < nums.length && nums[i] == 1) {
                oneCounter++;
                i++;
            }
            if (oneCounter > 0) {
                ranges.add(new Integer[]{oneCounter, 1});
                oneCounter = 0;
            }
            while (i < nums.length && nums[i] == 0) {
                zeroCounter++;
                i++;
            }
            if (zeroCounter > 0) {
                ranges.add(new Integer[]{zeroCounter, 0});
                allZeros += zeroCounter;
                zeroCounter = 0;
            }
        }
        int maxLength = 0;
        int len;
        k = Math.min(k, allZeros); // чтобы не делать тупые проверки потом
        for (int j = 0; j < ranges.size(); j++) {
            len = getLength(j, k, ranges);
            if (len > maxLength) {
                maxLength = len;
            }
        }
        return maxLength;
    }

    public static int getLength(int start, int k, ArrayList<Integer[]> ranges) {
        int type, value;
        int sum = 0;
        int index = start;
        while (index < ranges.size()) {
            type = ranges.get(index)[1];
            value = ranges.get(index)[0];
            if (type == 0) {
                if (k >= value) {
                    k -= value;
                    sum += value;
                }
                else {
                    if (sum == 0) {
                        sum += k;
                        k = 0;
                    }
                    else { // закончили веселье
                        return sum + k;
                    }
                }
            } else {
                sum += value;
            }
            index++;
        }
        if (k > 0 && start > 0) {
            sum += k;
        }
        return sum;
    }
}
