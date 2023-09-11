package Day20;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public static void main(String[] args) {
        int[][] obstacleGrid = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
//        int[][] obstacleGrid = {{0, 1}, {1, 0}};
        System.out.println(uniquePathsWithObstacles(obstacleGrid));
    }

    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0) {
            return 0;
        }
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;
        if (obstacleGrid[0][0] == 1 || obstacleGrid[n - 1][m - 1] == 1) {
            return 0;
        }
        if (obstacleGrid.length == 1) {
            return 1;
        }

        int[][] pathNumbers = new int[n][m];
        pathNumbers[0][0] = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (obstacleGrid[i][j] == 0) {
                    if (i > 0) {
                        pathNumbers[i][j] += pathNumbers[i - 1][j];
                    }
                    if (j > 0) {
                        pathNumbers[i][j] += pathNumbers[i][j - 1];
                    }
                }
            }
        }
        return pathNumbers[n - 1][m - 1];
    }
}
