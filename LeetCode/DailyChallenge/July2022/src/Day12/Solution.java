package Day12;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
//        System.out.println(new Solution().makeSquare(new int[]{1, 1, 2, 2, 2}));
//        System.out.println(new Solution().makeSquare(new int[]{3, 3, 3, 3, 4}));
//        System.out.println(new Solution().makeSquare(new int[]{5, 4, 4, 3, 2, 1, 1}));
//        System.out.println(new Solution().makeSquare(new int[]{3, 3, 3, 3}));
//        System.out.println(new Solution().makeSquare(new int[]{3, 3, 3, 1, 1, 1}));
        System.out.println(new Solution().makeSquare(new int[]{13, 11, 1, 8, 6, 7, 8, 8, 6, 7, 8, 9, 8}));
    }

    public boolean makeSquare(int[] matchsticks) {
        if (matchsticks == null || matchsticks.length == 0) {
            return false;
        }
        int sum = 0;
        for (int num : matchsticks) {
            sum += num;
        }

        if (sum % 4 != 0) {
            return false;
        }

        Arrays.sort(matchsticks);

        return dfs(matchsticks, new int[4], matchsticks.length - 1, sum / 4);
    }

    boolean dfs(int[] matchsticks, int[] sum, int index, int target) {
        if (index == -1) {
            return true;
        }

        for (int i = 0; i < 4; i++) {
            if ((sum[i] + matchsticks[index] > target) || (i > 0 && sum[i] == sum[i - 1])) {
                continue;
            }

            sum[i] += matchsticks[index];

            if (dfs(matchsticks, sum, index - 1, target)) {
                return true;
            }
            sum[i] -= matchsticks[index];
        }
        return false;
    }
}
