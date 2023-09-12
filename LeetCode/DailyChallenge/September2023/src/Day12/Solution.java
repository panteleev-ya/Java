package Day12;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {

    }

    public int minDeletions(String s) {
        int[] frequencies = new int[26];
        Set<Integer> set = new HashSet<>();
        for (char ch : s.toCharArray()) {
            frequencies[ch - 'a']++;
        }

        int deletionCounter = 0;
        for (int frequency : frequencies) {
            while (frequency != 0 && set.contains(frequency)) {
                frequency--;
                deletionCounter++;
            }
            set.add(frequency);
        }
        return deletionCounter;
    }
}
