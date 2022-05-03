package FourSum;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
//        int[] nums = {1, 0, -1, 0, -2, 2};
        int[] nums = {2, 2, 2, 2};
        int target = 8;
        System.out.println(fourSum(nums, target));
    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        Set<Integer> set = new HashSet<>();
        List<List<Integer>> quadruplets = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (!set.contains(num)) {
                set.add(num);
                nums[i] = Integer.MIN_VALUE;
                List<List<Integer>> triples = threeSum(nums, target - num);
                for (List<Integer> triple : triples) {
                    triple.add(num);
                    triple.sort(Comparator.comparingInt(i1 -> i1));
                    if (!containsCombination(quadruplets, triple)) {
                        quadruplets.add(triple);
                    }
                }
            }
        }
        return quadruplets;
    }

    public static List<List<Integer>> threeSum(int[] nums, int target) {
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
            int intMinCount = 0;
            num = uniqueNums.get(start);
            twoSum = target - num;
            middle = start;
            end = numsSize - 1;
            if (num == Integer.MIN_VALUE) {
                intMinCount++;
            }
            while (middle <= end) {
                numBegin = uniqueNums.get(middle);
                numEnd = uniqueNums.get(end);
                if (numBegin + numEnd < twoSum) {
                    middle += 1;
                } else if (numBegin + numEnd > twoSum) {
                    end -= 1;
                } else {
                    if (numBegin == Integer.MIN_VALUE) {
                        intMinCount++;
                    }
                    if (numEnd == Integer.MIN_VALUE) {
                        intMinCount++;
                    }
                    // x + numBegin + numEnd == T, now calculate the size of the contribution
                    if (start < middle && middle < end) {
                        isValid = freqNums.get(num) * freqNums.get(numBegin) * freqNums.get(numEnd);
                    } else if (start == middle && middle < end) {
                        isValid = freqNums.get(num) * (freqNums.get(num) - 1) / 2 * freqNums.get(numEnd);
                    } else if (start < middle && middle == end) {
                        isValid = freqNums.get(num) * freqNums.get(numBegin) * (freqNums.get(numBegin) - 1) / 2;
                    } else {
                        isValid = freqNums.get(num) * (freqNums.get(num) - 1) * (freqNums.get(num) - 2) / 6;
                    }
                    if (isValid > 0 && intMinCount <= 1) {
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

    private static boolean containsCombination(List<List<Integer>> quadruplets, List<Integer> triple) {
        for (List<Integer> quadruplet: quadruplets) {
            boolean contains = true;
            for (int i = 0; i < 4; i++) {
                if (!quadruplet.get(i).equals(triple.get(i))) {
                    contains = false;
                    break;
                }
            }
            if (contains) {
                return true;
            }
        }
        return false;
    }
}
