package RegularExpressionMatching;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        String s = console.nextLine();
        String p = console.nextLine();
        System.out.println(isMatch(s, p));
    }

    // Top-down memoized approach
    public static boolean isMatch(String s, String p) {
        Boolean[][] memo = new Boolean[s.length() + 1][p.length() + 1];
        return helper(s, p, 0, 0, memo);
    }

    // i and j are pointers for s and p respectively
    public static boolean helper(String s, String p, int i, int j, Boolean[][] memo) {
        if (memo[i][j] != null) {
            return memo[i][j];
        }

        if (i >= s.length() && j >= p.length()) {
            // If both i and j exceed their lengths then it's a match
            return true;
        }
        else if (j >= p.length()) {
            // If only j exceeds the length then it's not a match
            return false;
        }

        // If both characters are equal or . then it's a match
        boolean match = (i < s.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.'));

        if (j + 1 < p.length() && p.charAt(j + 1) == '*') // Special case when next character is a *
            // If characters match then check next character in s OR check by skipping the character in p (along with *)
            return memo[i][j] = match && helper(s, p, i + 1, j, memo) || helper(s, p, i, j + 2, memo);

        if (match) {
            // If both i and j match then check next characters of both
            return memo[i][j] = helper(s, p, i + 1, j + 1, memo);
        }
        // Else characters don't match
        return memo[i][j] = false;
    }
}