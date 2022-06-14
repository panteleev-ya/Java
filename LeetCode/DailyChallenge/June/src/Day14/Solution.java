package Day14;

public class Solution {
    public static void main(String[] args) {

    }

    public static int minDistance(String s, String t) {
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        int n = sChars.length;
        int m = tChars.length;

        int[][] dp = new int[n + 1][m + 1];

        for (int i = n - 1; i >= 0; --i) {
            for (int j = m - 1; j >= 0; --j) {
                if (sChars[i] == tChars[j]) {
                    dp[i][j] = 1 + dp[i + 1][j + 1];
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j + 1]);
                }
            }
        }

        return s.length() + t.length() - (2 * dp[0][0]);
    }
}
