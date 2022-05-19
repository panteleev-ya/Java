package Day19;

public class Solution {
    public static void main(String[] args) {
//        int[][] matrix = {{9, 9, 4}, {6, 6, 8}, {2, 1, 1}};
        int[][] matrix = {{3, 4, 5}, {3, 2, 6}, {2, 2, 1}};
        System.out.println(longestIncreasingPath(matrix));
    }

    private static final int[][] steps = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};
    private static int maxDistance;

    public static int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        int n = matrix.length;
        int m = matrix[0].length;
        maxDistance = 0;

        int[][] distances = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (distances[i][j] != 0) {
                    // Means we already visited this cell, so we found every way from it to others
                    continue;
                }
                dfs(matrix, distances, i, j, 1);
            }
        }

        return maxDistance + 1;
    }

    private static void dfs(int[][] matrix, int[][] distances, int x, int y, int distance) {
        int n = matrix.length;
        int m = matrix[0].length;
        for (var step : steps) {
            int i = x + step[0];
            int j = y + step[1];

            // If out of bounds
            if (!(i >= 0 && i < n && j >= 0 && j < m)) {
                continue;
            }

            // If value next not less than current value
            if (!(matrix[i][j] < matrix[x][y])) {
                continue;
            }

            // If new distance is not longer than current
            if (!(distance > distances[i][j])) {
                continue;
            }
            if (distance > maxDistance) {
                maxDistance = distance;
            }
            distances[i][j] = distance;
            dfs(matrix, distances, i, j, distance + 1);
        }
    }
}
