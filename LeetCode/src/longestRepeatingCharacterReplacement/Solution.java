package longestRepeatingCharacterReplacement;

public class Solution {
    public int characterReplacement(String s, int k) {
        int[] frequencies = new int[26];
        int maxSubstringLength = 0;
        int maxFrequency = 0;
        int left = 0;
        char[] chars = s.toCharArray();

        for (int right = 0; right < chars.length; right++) {
            frequencies[chars[right] - 'A']++;
            maxFrequency = Math.max(maxFrequency, frequencies[chars[right] - 'A']);

            if (right - left + 1 - maxFrequency > k) {
                frequencies[chars[left] - 'A']--;
                left++;
            }
            maxSubstringLength = Math.max(maxSubstringLength, right - left + 1);
        }
        return maxSubstringLength;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().characterReplacement("AABABCA", 1));
    }
}
