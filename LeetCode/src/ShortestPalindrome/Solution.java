package ShortestPalindrome;

public class Solution {
    public static void main(String[] args) {
        System.out.println(shortestPalindrome("aacecaaa"));
    }

    public static String shortestPalindrome(String s) {
        int left = 0;
        for (int right = s.length() - 1; right >= 0; right--) {
            if (s.charAt(left) != s.charAt(right)) {
                continue;
            }
            left++;
        }

        if (left == s.length()) {
            return s;
        }

        String suffix = s.substring(left);
        String prefix = new StringBuilder(suffix).reverse().toString();
        String mid = shortestPalindrome(s.substring(0, left));
        return prefix + mid + suffix;
    }
}
