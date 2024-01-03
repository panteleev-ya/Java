package Day3;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().numIdenticalPairs(new int[] { 1, 2, 3, 1, 1, 3 }));
    }

    public int numIdenticalPairs(int[] nums) {
        Map<Integer, Integer> visited = new HashMap<>();
        int count = 0;
        for (int num : nums) {
            count += visited.getOrDefault(num, 0);
            visited.merge(num, 1, Integer::sum);
        }
        return count;
    }
}
