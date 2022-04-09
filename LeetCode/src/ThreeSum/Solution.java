package ThreeSum;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        System.out.println(threeSum(nums));
    }
    public static List<List<Integer>> threeSum(int[] nums) {
        int target = 0;
        List<List<Integer>> triples = new ArrayList<>();
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

        // Считаем все варианты
        int numsSize = uniqueNums.size();
        int num, twoSum, middle, end, numBegin, numEnd, isValid;
        ArrayList<Integer> triple;
        for (int start = 0; start < numsSize; start++) {
            num = uniqueNums.get(start);
            twoSum = target - num;
            middle = start;
            end = numsSize - 1;
            while (middle <= end) {
                numBegin = uniqueNums.get(middle);
                numEnd = uniqueNums.get(end);
                if (numBegin + numEnd < twoSum) {
                    middle += 1;
                } else if (numBegin + numEnd > twoSum) {
                    end -= 1;
                } else {
                    // x + numBegin + numEnd == T, now calculate the size of the contribution
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
                        triple = new ArrayList<>();
                        triple.add(numBegin);
                        triple.add(num);
                        triple.add(numEnd);
                        triples.add(triple);
                    }
                    middle += 1;
                    end -= 1;
                }
            }
        }

        return triples;
    }
}
