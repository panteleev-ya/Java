package Day9;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 3};
//        int[] nums = {1, 2};
        int k = 2;
        System.out.println(Arrays.toString(topKFrequent(nums, k)));
    }

    public static int[] topKFrequent(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return null;
        }

        int[] freq = new int[k];

        // Counter map - counting
        HashMap<Integer, Integer> freqMap = new HashMap<>(100_000);
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }
        // Sorting unique nums by PriorityQueue, where (a, b) -> freqMap.get(a) - freqMap.get(b)
        // Sorting in ASC, deleting minimums if size > k
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(freqMap::get));
        for (int key: freqMap.keySet()) {
            priorityQueue.add(key);
            if (priorityQueue.size() > k) {
                priorityQueue.remove();
            }
        }

        // Returning first k most frequent nums
        for (int i = k - 1; i >= 0; i--) {
            freq[i] = priorityQueue.poll();
        }
        return freq;
    }
}
