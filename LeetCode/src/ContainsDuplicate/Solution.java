package ContainsDuplicate;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> duplicates = new HashSet<>();
        for (int num: nums) {
            if (!duplicates.add(num)) {
                return true;
            }
        }
        return false;
    }
}