package Day16;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public static void main(String[] args) {
        int[][] grid = {
                {0, 1, 1, 0, 0, 0},
                {0, 1, 0, 1, 1, 0},
                {0, 1, 1, 0, 1, 0},
                {0, 0, 0, 1, 1, 0},
                {1, 1, 1, 1, 1, 0},
                {1, 1, 1, 1, 1, 0}
        };
        System.out.println(shortestPathBinaryMatrix(grid));
    }

    public static int shortestPathBinaryMatrix(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0][0] == 1) {
            return -1;
        }
        int n = grid.length;
        int[][] distances = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                distances[i][j] = Integer.MAX_VALUE;
            }
        }
        distances[0][0] = 1;
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(0, 0));
        while (!queue.isEmpty()) {
            Pair prev = queue.poll();
            int pX = prev.x;
            int pY = prev.y;
            Pair[] neighbours = {
                    new Pair(pX - 1, pY - 1), new Pair(pX - 1, pY), new Pair(pX - 1, pY + 1),
                    new Pair(pX, pY - 1), new Pair(pX, pY + 1),
                    new Pair(pX + 1, pY - 1), new Pair(pX + 1, pY), new Pair(pX + 1, pY + 1)
            };
            for (Pair next : neighbours) {
                if (!next.isValid(n)) {
                    continue;
                }
                int nX = next.x;
                int nY = next.y;
                if (grid[nX][nY] == 0 && distances[nX][nY] > distances[pX][pY] + 1) {
                    distances[nX][nY] = distances[pX][pY] + 1;
                    queue.add(next);
                }
            }
        }
        if (distances[n - 1][n - 1] == Integer.MAX_VALUE) {
            return -1;
        }
        return distances[n - 1][n - 1];
    }

    private record Pair(int x, int y) {
        public boolean isValid(int n) {
            return x >= 0 && x < n && y >= 0 && y < n;
        }
    }
}
