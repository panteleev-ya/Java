package Day6;

import java.util.Comparator;
import java.util.HashMap;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 2, 3, 3, 4, 4, 5, 5};
        int target = 8;
        System.out.println(threeSumMulti(arr, target));
    }

    public static int threeSumMulti(int[] arr, int target) {
        HashMap<Integer, Integer> numCounts = new HashMap<>();
        ArrayList<Integer> nums = new ArrayList<>();

        // Собираем количества всех чисел и сами числа в принципе
        int currentCount;
        for (int num : arr) {
            currentCount = numCounts.getOrDefault(num, 0);
            if (currentCount == 0) {
                nums.add(num);
            }
            numCounts.put(num, currentCount + 1);
        }

        // Сортируем встречающиеся числа по возрастанию
        nums.sort(Comparator.comparingInt(i -> i));

        // Считаем все варианты
        int module = 1_000_000_007;
        long count = 0;
        int numsSize = nums.size();
        int num, twoSum, middle, end, numBegin, numEnd;
        for (int start = 0; start < numsSize; start++) {
            num = nums.get(start);
            twoSum = target - num;
            middle = start;
            end = numsSize - 1;
            while (middle <= end) {
                numBegin = nums.get(middle);
                numEnd = nums.get(end);
                if (numBegin + numEnd < twoSum) {
                    middle += 1;
                } else if (numBegin + numEnd > twoSum) {
                    end -= 1;
                } else {
                    // x + numBegin + numEnd == T, now calculate the size of the contribution
                    if (start < middle && middle < end) {
                        count += (long) numCounts.get(num) * numCounts.get(numBegin) * numCounts.get(numEnd);
                    }
                    else if (start == middle && middle < end) {
                        count += (long) numCounts.get(num) * (numCounts.get(num) - 1) / 2 * numCounts.get(numEnd);
                    }
                    else if (start < middle && middle == end) {
                        count += (long) numCounts.get(num) * numCounts.get(numBegin) * (numCounts.get(numBegin) - 1) / 2;
                    }
                    else {
                        count += (long) numCounts.get(num) * (numCounts.get(num) - 1) * (numCounts.get(num) - 2) / 6;
                    }

                    middle += 1;
                    end -= 1;
                }
            }
        }

        return (int) (count % module);
    }
}
