package topKFrequentElements;


import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : nums) {
            freq.merge(num, 1, Integer::sum);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> freq.get(b) - freq.get(a));
        pq.addAll(freq.keySet());

        int[] topFrequent = new int[k];
        for (int i = 0; i < k; i++) {
            topFrequent[i] = pq.poll();
        }
        return topFrequent;
    }
}
