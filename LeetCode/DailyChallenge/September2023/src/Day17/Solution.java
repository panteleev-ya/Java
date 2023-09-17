package Day17;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public static void main(String[] args) {
//        int[][] graph = new int[][]{{1, 2, 3}, {0}, {0}, {0}};
//        int[][] graph = new int[][]{{1}, {0, 2, 4}, {1, 3, 4}, {2}, {1, 2}};
//        int[][] graph = new int[][]{{1}, {0, 2, 4}, {1, 3}, {2}, {1, 5}, {4}};
//        int[][] graph = new int[][]{
//                {1}, {0, 2, 4, 9}, {1, 3}, {2},
//                {1, 5}, {4, 9}, {9}, {8, 9},
//                {7, 9}, {1, 5, 6, 7, 8, 9}
//        };
        int[][] graph = new int[][]{{1, 2, 3, 4}, {0, 2}, {0, 1}, {0, 5}, {0, 6}, {3}, {4}};
        System.out.println(new Solution().shortestPathLength(graph));
    }

    public int shortestPathLength(int[][] graph) {
        int n = graph.length;

        int allMask = (1 << n) - 1;
        boolean[][] visitedMaskAndNode = new boolean[n][allMask + 1];
        Queue<int[]> paths = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            paths.add(new int[]{i, 1 << i, 0}); // vertex, mask, length
            visitedMaskAndNode[i][1 << i] = true; // last vertex "i" with mask 2^i
        }

        while (!paths.isEmpty()) {
            int[] node = paths.poll();
            if (node[1] == allMask) {
                return node[2];
            }
            for (int neighbour : graph[node[0]]) {
                int nextMask = node[1] | (1 << neighbour);
                if (!visitedMaskAndNode[neighbour][nextMask]) {
                    visitedMaskAndNode[neighbour][nextMask] = true;
                    paths.add(new int[]{neighbour, nextMask, node[2] + 1});
                }
            }
        }
        return -1;
    }
}
