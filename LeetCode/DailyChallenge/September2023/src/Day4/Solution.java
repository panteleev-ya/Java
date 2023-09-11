package Day4;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

public class Solution {
    public static void main(String[] args) {
        int[] nums = {4, 4, 1, 3, 1, 3, 2, 2, 5, 5, 1, 5, 2, 1, 2, 3, 5, 4};
        int k = 2;
        System.out.println(maxOperations(nums, k));
    }

    public static int maxOperations(int[] nums, int k) {
        int target = k;
        int counter = 0;
        HashMap<Integer, Integer> freqNums = new HashMap<>();
        ArrayList<Integer> uniqueNums = new ArrayList<>();

        // Собираем количества всех чисел и сами числа в принципе
        int currentCount;
        for (int num : nums) {
            currentCount = freqNums.getOrDefault(num, 0);
            if (currentCount == 0) {
                uniqueNums.add(num);
            }
            freqNums.put(num, currentCount + 1);
        }

        // Сортируем встречающиеся числа по возрастанию
        uniqueNums.sort(Comparator.comparingInt(i -> i));

        int numsSize = uniqueNums.size();
        int right = numsSize - 1;
        for (int left = 0; left < numsSize && left <= right; left++) {
            int leftNum = uniqueNums.get(left);
            if (freqNums.get(leftNum) == 0) {
                continue;
            }
            while (left <= right) {
                int rightNum = uniqueNums.get(right);
                if (leftNum + rightNum < target) {
                    // Means left += 1;
                    break;
                } else if (leftNum + rightNum > target || freqNums.get(rightNum) == 0) {
                    right -= 1;
                } else {
                    int count;
                    int leftCount = freqNums.get(leftNum);
                    if (left < right) {
                        int rightCount = freqNums.get(rightNum);
                        count = Math.min(leftCount, rightCount);
                        freqNums.replace(leftNum, Math.max(0, leftCount - count));
                        freqNums.replace(rightNum, Math.max(0, rightCount - count));
                    } else {
                        count = leftCount / 2;
                        freqNums.replace(leftNum, Math.max(0, leftCount - count));
                    }
                    counter += count;
                    break;
                }
            }
        }
        return counter;
    }
}
