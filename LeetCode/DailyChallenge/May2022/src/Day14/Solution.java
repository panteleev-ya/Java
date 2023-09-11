package Day14;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public static void main(String[] args) {
        int[][] times = {{2, 1, 1}, {2, 3, 1}, {3, 4, 1}};
        int n = 4, k = 2;
        System.out.println(networkDelayTime(times, n, k));
    }

    public static int networkDelayTime(int[][] times, int n, int k) {
        // Making graph
        int[][] graph = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                graph[i][j] = -1;
            }
        }
        for (int[] edge : times) {
            graph[edge[0] - 1][edge[1] - 1] = edge[2];
        }

        // Setting distances
        int[] distances = new int[n];
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[k - 1] = 0;

        // BFS
        Queue<Integer> queue = new LinkedList<>();
        queue.add(k - 1);
        while (!queue.isEmpty()) {
            int v = queue.poll();
            for (int j = 0; j < n; j++) {
                if (graph[v][j] != -1 && distances[j] > distances[v] + graph[v][j]) {
                    distances[j] = distances[v] + graph[v][j];
                    queue.add(j);
                }
            }
        }

        int result = -1;
        for (int distance : distances) {
            if (distance == Integer.MAX_VALUE) {
                return -1;
            }
            if (distance > result) {
                result = distance;
            }
        }
        return result;
    }
}
