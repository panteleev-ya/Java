package Day28;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution {
    public static void main(String[] args) {
        int[][] heights = {
                {10, 8}, {10, 8}, {1, 2}, {10, 3}, {1, 3}, {6, 3}, {5, 2}
        };
        System.out.println(minimumEffortPath(heights));
    }

    public static int minimumEffortPath(int[][] heights) {
        // Goal row and col
        int n = heights.length - 1;
        int m = heights[0].length - 1;

        // Set up the minHeap
        PriorityQueue<Coordinate> pq = new PriorityQueue<>();

        // Add the first coordinate to the heap
        Coordinate startingCoord = new Coordinate(0, 0, heights[0][0], 0);
        pq.offer(startingCoord);

        // Keep track of current distance to each coordinate
        int[][] distances = new int[heights.length][heights[0].length];
        for (int i = 0; i < heights.length; i++) {
            Arrays.fill(distances[i], Integer.MAX_VALUE);
        }

        // Set up arrays for children nodes
        int[] directionsX = {0, 1, 0, -1};
        int[] directionsY = {1, 0, -1, 0};

        // While heap not empty,
        while (!pq.isEmpty()) {
            // Pop off heap
            Coordinate current = pq.poll();

            // If coordinate is target coordinate return the distance
            if (current.x == n && current.y == m) {
                return current.distance;
            }

            // Calculate distance to all neighbors
            for (int i = 0; i < 4; i++) {
                int nextX = current.x + directionsX[i];
                int nextY = current.y + directionsY[i];

                // If we are not out of the range
                if (nextX >= 0 && nextX <= n && nextY >= 0 && nextY <= m) {
                    int height = heights[nextX][nextY];
                    int distance = Math.max(current.distance, Math.abs(current.height - height));
                    if (distance < distances[nextX][nextY]) {
                        distances[nextX][nextY] = distance;
                        pq.offer(new Coordinate(nextX, nextY, height, distance));
                    }
                }
            }
        }
        return 0;
    }

    public static class Coordinate implements Comparable<Coordinate> {
        public int x;
        public int y;
        public int height;
        public int distance;

        public Coordinate(int x, int y, int height, int distance) {
            this.x = x;
            this.y = y;
            this.height = height;
            this.distance = distance;
        }

        @Override
        public int compareTo(Coordinate c) {
            return this.distance - c.distance;
        }
    }
}
