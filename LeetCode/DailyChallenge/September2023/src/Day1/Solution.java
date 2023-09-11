package Day1;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int n = 5;
        System.out.println(Arrays.toString(new Solution().countBits(n)));
    }

    public int[] countBits(int n) {
        int[] ans = new int[n + 1];
        ans[0] = 0;
        for (int i = 1; i <= n; i++) {
            ans[i] = 0;
            int k = i;
            while (k > 0) {
                ans[i] += k & 1;
                k >>= 1;
            }
        }
        return ans;
    }
}
