package Day5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
    }

    public List<Integer> majorityElement(int[] nums) {
        List<Integer> appeared = new ArrayList<>(nums.length);
        Map<Integer, Integer> appearance = new HashMap<>();
        int cutOff = nums.length / 3 + 1;
        for (int num : nums) {
            appearance.merge(num, 1, Integer::sum);
            if (appearance.get(num) == cutOff) {
                appeared.add(num);
            }
        }
        return appeared;
    }
}
