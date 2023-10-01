package Day3;

public class Solution {
    public static void main(String[] args) {
        int m = 3;
        int n = 7;
        System.out.println(new Solution().uniquePaths(m, n));
    }

    public int uniquePaths(int m, int n) {
        int[][] grid = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = 0;
            }
        }
        for (int i = 0; i < m; i++) {
            grid[i][n - 1] = 1;
        }
        for (int j = 0; j < n; j++) {
            grid[m - 1][j] = 1;
        }
        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                grid[i][j] = grid[i + 1][j] + grid[i][j + 1];
            }
        }
        return grid[0][0];
    }
}
