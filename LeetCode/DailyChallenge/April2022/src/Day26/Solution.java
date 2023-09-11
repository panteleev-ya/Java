package Day26;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int[][] points = {{3, 12}, {-2, 5}, {-4, 1}};
        System.out.println(minCostConnectPoints(points));
    }

    public static int minCostConnectPoints(int[][] points) {
        int n = points.length;

        int[][] graph = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                graph[i][j] = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
            }
        }

        boolean[] used = new boolean[n];
        Arrays.fill(used, false);

        int[] distances = new int[n];
        Arrays.fill(distances, Integer.MAX_VALUE);

        // =========================================================================
        // https://github.com/SmartOven/Algorithms/blob/master/Lab_10/lab10_2_1.cpp
        // Prim algorithm - building MST
        distances[0] = 0;
        for (int i = 0; i < n; i++) {
            int v = -1;
            for (int j = 0; j < n; j++) {
                if (!used[j] && (v == -1 || distances[j] < distances[v])) {
                    v = j;
                }
            }
            used[v] = true;
            for (int j = 0; j < n; j++) {
                if (!used[j] && graph[v][j] < distances[j] && v != j) {
                    distances[j] = graph[v][j];
                }
            }
        }
        // =========================================================================

        int result = 0;
        for (int dist: distances) {
            result += dist;
        }

        return result;
    }
}
