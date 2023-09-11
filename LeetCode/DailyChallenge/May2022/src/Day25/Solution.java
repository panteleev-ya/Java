package Day25;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {

    }

    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
        int[] dp = new int[envelopes.length];
        int answer = 0;
        for (int[] envelope : envelopes) {
            int height = envelope[1];
            int left = Arrays.binarySearch(dp, 0, answer, height);
            if (left < 0) {
                left = -left - 1;
            }
            if (left == answer) {
                answer++;
            }
            dp[left] = height;
        }
        return answer;
    }
}
