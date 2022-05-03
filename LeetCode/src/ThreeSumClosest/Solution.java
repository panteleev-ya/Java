package ThreeSumClosest;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        int[] nums = {0, 2, 1, -3};
        int target = 1;
        System.out.println(threeSumClosest(nums, target));
    }

    public static int threeSumClosest(int[] nums, int target) {
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

        int closest = getMinSum(freqNums, uniqueNums, 0, 3, 0);
        int closestDifference = Math.abs(target - closest);

        // Считаем все варианты
        int numsSize = uniqueNums.size();
        int num, middle, end, numBegin, numEnd, currentSum, difference;
        for (int start = 0; start < numsSize; start++) {
            num = uniqueNums.get(start);
            middle = start;
            end = numsSize - 1;
            while (middle <= end) {
                numBegin = uniqueNums.get(middle);
                numEnd = uniqueNums.get(end);
                currentSum = numBegin + numEnd + num;
                difference = getCurrentSumDifference(target, freqNums, num, middle, end, numBegin, numEnd, currentSum, start);
                if (difference != Integer.MIN_VALUE && Math.abs(difference) < Math.abs(closestDifference)) {
                    closestDifference = difference;
                    closest = currentSum;
                }
                if (difference < 0) {
                    middle += 1;
                } else {
                    end -= 1;
                }
            }
        }

        return closest;
    }

    private static int getMinSum(HashMap<Integer, Integer> freqNums, ArrayList<Integer> uniqueNums, int result, int count, int index) {
        int minNum = uniqueNums.get(index);
        int minNumCount = Math.min(count, freqNums.get(minNum));
        count -= minNumCount;
        result += minNum * minNumCount;
        if (count == 0) {
            return result;
        } else {
            return getMinSum(freqNums, uniqueNums, result, count, index + 1);
        }
    }

    private static int getCurrentSumDifference(int target, HashMap<Integer, Integer> freqNums, int num, int middle, int end, int numBegin, int numEnd, int currentSum, int start) {
        int isValid;
        if (start < middle && middle < end) {
            isValid = freqNums.get(num) * freqNums.get(numBegin) * freqNums.get(numEnd);
        }
        else if (start == middle && middle < end) {
            isValid = freqNums.get(num) * (freqNums.get(num) - 1) / 2 * freqNums.get(numEnd);
        }
        else if (start < middle && middle == end) {
            isValid = freqNums.get(num) * freqNums.get(numBegin) * (freqNums.get(numBegin) - 1) / 2;
        }
        else {
            isValid = freqNums.get(num) * (freqNums.get(num) - 1) * (freqNums.get(num) - 2) / 6;
        }
        if (isValid > 0) {
            return currentSum - target;
        }
        return Integer.MIN_VALUE;
    }
}
