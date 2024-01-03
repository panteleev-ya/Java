package Day28;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        System.out.println(minDeletions("aaabbbcc"));
    }

    public static int minDeletions(String s) {
        int[] frequencies = new int[26];
        HashSet<Integer> set = new HashSet<>();
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
