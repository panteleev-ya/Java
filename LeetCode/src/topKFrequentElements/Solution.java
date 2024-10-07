package topKFrequentElements;


import java.util.*;

public class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // count frequencies -> O(n) time, O(n) space
        Map<Integer, Integer> frequencies = new HashMap<>();
        for (int num : nums) {
            frequencies.merge(num, 1, Integer::sum);
        }

        // put them into buckets by value -> O(n) time, O(n) space
        List<Integer>[] buckets = new List[nums.length + 1];
        for (var entry : frequencies.entrySet()) {
            int num = entry.getKey();
            int freq = entry.getValue();
            if (buckets[freq] == null) {
                buckets[freq] = new ArrayList<>();
            }
            buckets[freq].add(num);
        }

        // collect result from buckets -> O(k) time
        int[] topFrequent = new int[k];
        for (int i = buckets.length - 1, j = 0; i >= 0 && j < k; i--) {
            if (buckets[i] == null) {
                continue;
            }
            for (int num : buckets[i]) {
                if (j >= k) {
                    break;
                }
                topFrequent[j] = num;
                j++;
            }
        }

        return topFrequent;
    }
}