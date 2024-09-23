package longestSubstringWithoutRepeatingCharacters;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null) {
            return 0;
        }
        if (s.length() < 2) {
            return s.length();
        }

        char[] chars = s.toCharArray();
        int left = 0;
        int maxSubStringLength = 0;
        Set<Character> foundChars = new HashSet<>();

        for (int right = 0; right < chars.length; right++) {
            while (foundChars.contains(chars[right])) {
                foundChars.remove(chars[left]);
                left++;
            }
            foundChars.add(chars[right]);
            maxSubStringLength = Math.max(maxSubStringLength, right - left + 1);
        }

        return maxSubStringLength;
    }
}