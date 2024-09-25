package permutationInString;

import java.util.Arrays;

public class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1 == null || s2 == null || s1.length() > s2.length()) {
            return false;
        }

        // calculate frequencies of chars in s1
        int[] frequencies = new int[26];
        Arrays.fill(frequencies, 0);
        for (char c : s1.toCharArray()) {
            frequencies[c - 'a']++;
        }

        // reduce them by frequencies of chars in each s2's substring
        char[] chars = s2.toCharArray();
        for (int i = 0; i < s1.length() - 1; i++) {
            frequencies[chars[i] - 'a']--;
        }

        int left = 0;
        for (int right = s1.length() - 1; right < chars.length; right++, left++) {
            frequencies[chars[right] - 'a']--;
            if (isPermutation(frequencies)) {
                return true;
            }
            frequencies[chars[left] - 'a']++;
        }

        return false;
    }

    // if all frequencies comparisions return 0, we found the permutation of s1
    private boolean isPermutation(int[] frequencies) {
        for (int i = 0; i < 26; i++) {
            if (frequencies[i] != 0) {
                return false;
            }
        }
        return true;
    }
}
