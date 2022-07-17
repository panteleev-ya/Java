package Day16;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {

    }

    private int[][][] cache;

    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        cache = new int[m][n][maxMove + 1];
        for (int[][] cc : cache) {
            for (int[] c : cc) {
                Arrays.fill(c, -1);
            }
        }
        return f(m, n, maxMove, startRow, startColumn);
    }

    private int f(int m, int n, int max, int r, int c) {
        if (r < 0 || c < 0 || r == m || c == n) {
            return 1;
        }
        if (max == 0) {
            return 0;
        }
        if (cache[r][c][max] > -1) {
            return cache[r][c][max];
        }
        int module = 1000_000_007;
        long l = f(m, n, max - 1, r - 1, c) % module;
        l += f(m, n, max - 1, r + 1, c) % module;
        l += f(m, n, max - 1, r, c + 1) % module;
        l += f(m, n, max - 1, r, c - 1) % module;
        cache[r][c][max] = (int) (l % module);
        return cache[r][c][max];
    }
}
