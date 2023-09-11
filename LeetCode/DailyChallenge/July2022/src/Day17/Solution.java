package Day17;

public class Solution {
    public static void main(String[] args) {

    }

    public int kInversePairs(int n, int k) {
        int[][] dp = new int[n + 1][k + 1];
        int module = 1000_000_007;
        for (int i = 1; i <= n; i++) {
            dp[i][0] = 1;
            for (int j = 1; j <= k; j++) {
                int val = (dp[i - 1][j] + module - ((j - i) >= 0 ? dp[i - 1][j - i] : 0)) % module;
                dp[i][j] = (dp[i][j - 1] + val) % module;
            }
        }
        return ((dp[n][k] + module - (k > 0 ? dp[n][k - 1] : 0)) % module);
    }
}
