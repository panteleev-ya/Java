package Day10;

public class Solution {
    public static void main(String[] args) {
        String s = "abba";
        System.out.println(lengthOfLongestSubstring(s));
    }
    public static int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int[] letterIndexes = new int[128];
        for (int i = 0; i < 128; i++) {
            letterIndexes[i] = -1;
        }
        int maxLength = 0;
        char[] letters = s.toCharArray();
        int closestToRepeatIndex = 0;
        for (int i = 0; i < n; i++) {
            // Not a new character
            if (letterIndexes[letters[i]] != -1) {
                closestToRepeatIndex = Math.max(closestToRepeatIndex, letterIndexes[letters[i]] + 1);
            }
            if (maxLength < i - closestToRepeatIndex + 1) {
                maxLength = i - closestToRepeatIndex + 1;
            }
            letterIndexes[letters[i]] = i;
        }
        return maxLength;
    }
}
