package minimumWindowSubstring;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().minWindow("OUZODYXAZV", "XYZ"));
    }

    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() < t.length()) {
            return "";
        }

        Map<Character, Integer> frequencies = new HashMap<>();

        for (char c : t.toCharArray()) {
            frequencies.merge(c, 1, Integer::sum);
        }

        char[] chars = s.toCharArray();
        int bestLeft = -1;
        int bestRight = chars.length;

        int left = 0;
        int right = 0;

        while (right < chars.length) {
            frequencies.merge(chars[right], -1, Integer::sum);
            // while current substring fits, try to lower its size
            if (isValidSubstring(frequencies)) {
                while (true) {
                    if (bestRight - bestLeft > right - left) {
                        bestRight = right;
                        bestLeft = left;
                    }

                    // move left pointer
                    int updatedFrequency = frequencies.merge(chars[left], 1, Integer::sum);
                    left++;

                    // check if we break the validness
                    if (updatedFrequency > 0) {
                        break;
                    }
                }
            }
            right++;
        }

        if (bestLeft == -1) {
            return "";
        }
        return s.substring(bestLeft, bestRight + 1);
    }

    // checks that substring of `t` contains all chars from `s`
    private boolean isValidSubstring(Map<Character, Integer> frequencies) {
        for (int f : frequencies.values()) {
            if (f > 0) {
                return false;
            }
        }
        return true;
    }
}
