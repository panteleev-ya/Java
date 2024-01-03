package Day2;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        String s = "dwmodizxvvbosxxw";
        // [d] {wmo} {diz} [x] {v} {v} [b] {o} [s] [x] [x] [w]
        String[] dictionary = {
                "cehy", "diz", "ds", "e",
                "gu", "ksv", "kzbu", "lb",
                "nuq", "o", "ox", "r",
                "tskz", "txhe", "v", "wmo",
        };
        System.out.println(new Solution().minExtraChar(s, dictionary));
    }

    public int minExtraChar(String s, String[] dictionary) {
        int[] dp = new int[s.length() + 1];
        Arrays.fill(dp, s.length() + 1);
        dp[0] = 0;

        Set<String> dictionarySet = new HashSet<>(Arrays.asList(dictionary));

        for (int i = 1; i <= s.length(); i++) {
            dp[i] = dp[i - 1] + 1;
            for (int l = 1; l <= i; l++) {
                if (dictionarySet.contains(s.substring(i - l, i))) {
                    dp[i] = Math.min(dp[i], dp[i - l]);
                }
            }
        }
        return dp[s.length()];
    }
}
