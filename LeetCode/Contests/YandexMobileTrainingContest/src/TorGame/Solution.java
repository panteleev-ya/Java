package TorGame;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

public class Solution {
    private static int n, m;

    public static void main(String[] args) throws FileNotFoundException {
        Scanner console = new Scanner(new FileInputStream("D:\\DiskApps\\Programming\\GitRepos\\Java\\LeetCode\\Contests\\YandexMobileTrainingContest\\src\\TorGame\\input.txt"));
        n = console.nextInt();
        m = console.nextInt();

        int startX = console.nextInt();
        int startY = console.nextInt();
        int endX = console.nextInt();
        int endY = console.nextInt();

        int[][] distances = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int cellType = console.nextInt();
                if (cellType == 0) {
                    distances[i][j] = Integer.MAX_VALUE;
                } else {
                    distances[i][j] = -1;
                }
            }
        }

        distances[startX][startY] = 0;
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(startX, startY));
        Pair[] neighbours = new Pair[4];
        while (!queue.isEmpty() && distances[endX][endY] == Integer.MAX_VALUE) {
            Pair current = queue.poll();
            int prevX = current.x;
            int prevY = current.y;
            getNeighbours(current.x, current.y, neighbours);
            for (int i = 0; i < 4; i++) {
                int nextX = neighbours[i].x;
                int nextY = neighbours[i].y;

                // Not valid cell
                if (distances[nextX][nextY] == -1) {
                    continue;
                }
                if (distances[nextX][nextY] > distances[prevX][prevY] + 1) {
                    distances[nextX][nextY] = distances[prevX][prevY] + 1;
                    queue.add(neighbours[i]);
                }
            }
        }

        if (distances[endX][endY] == Integer.MAX_VALUE) {
            System.out.println(-1);
            return;
        }

        StringBuilder reversedWay = new StringBuilder();
        char[] steps = {'S', 'N', 'E', 'W'};
        neighbours = new Pair[4];
        while (!(endX == startX && endY == startY)) {
            int nextMinDistance = Integer.MAX_VALUE;
            int nextX = endX;
            int nextY = endY;
            char nextStep = steps[0];

            getNeighbours(endX, endY, neighbours);
            for (int i = 0; i < 4; i++) {
                int neighbourX = neighbours[i].x;
                int neighbourY = neighbours[i].y;
                if (distances[neighbourX][neighbourY] == -1) {
                    continue;
                }
                if (distances[neighbourX][neighbourY] < nextMinDistance) {
                    nextX = neighbourX;
                    nextY = neighbourY;
                    nextMinDistance = distances[neighbourX][neighbourY];
                    nextStep = steps[i];
                }
            }
            reversedWay.append(nextStep);
            endX = nextX;
            endY = nextY;
        }
        System.out.println(reversedWay.reverse());
    }

    private static class Pair {
        public int x;
        public int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static void getNeighbours(int x, int y, Pair[] neighbours) {
        neighbours[0] = new Pair(x - 1, y);
        neighbours[1] = new Pair(x + 1, y);
        neighbours[2] = new Pair(x, y - 1);
        neighbours[3] = new Pair(x, y + 1);
        for (int i = 0; i < 4; i++) {
            if (neighbours[i].x < 0) {
                neighbours[i].x += n;
            } else if (neighbours[i].x >= n) {
                neighbours[i].x -= n;
            }
            if (neighbours[i].y < 0) {
                neighbours[i].y += m;
            } else if (neighbours[i].y >= m) {
                neighbours[i].y -= m;
            }
        }
    }
}
