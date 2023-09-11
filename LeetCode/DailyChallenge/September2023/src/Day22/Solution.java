package Day22;

public class Solution {
    public static void main(String[] args) {
//        String s = "abc";
        String s = "abcba";
        System.out.println(countSubstrings(s));
    }
    public static int countSubstrings(String s) {
        int result = 0;
        int n = s.length();
        // Looking for every substring which has center at i (odd length) or (i, i+1) (even length)
        // Moving to the left and to the right to check if it is still a palindrome
        // s[i - 2] s[i - 1] <-- s[i] --> s[i + 1] s[i + 2]
        // If s[i - 1] == s[i - 2] => check next to symbols
        // s[i - 2] <-- s[i - 1] s[i] s[i + 1] --> s[i + 2]
        // Repeat until reaches start or end of string or until s[i - k] != s[i + k]
        for (int i = 0; i < n; i++) {
            result += findSubstringsWithCenterAt(s, i, i);
            result += findSubstringsWithCenterAt(s, i, i + 1);
        }
        return result;
    }

    private static int findSubstringsWithCenterAt(String s, int i, int j) {
        int subStringsCount = 0;
        int n = s.length();
        while (i >= 0 && j < n && s.charAt(i) == s.charAt(j)) {
            subStringsCount++;
            i--;
            j++;
        }
        return subStringsCount;
    }
}
