package Day18;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        int n = 6;
        List<List<Integer>> connections = new ArrayList<>();
        int[][] arrayConnections = {{0, 1}, {1, 2}, {2, 0}, {1, 3}, {3, 4}, {4, 5}, {5, 3}};
        for (int[] arrayConnection : arrayConnections) {
            List<Integer> connection = new ArrayList<>();
            connection.add(arrayConnection[0]);
            connection.add(arrayConnection[1]);
            connections.add(connection);
        }
        System.out.println(criticalConnections(n, connections));
    }

    public static List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (List<Integer> oneConnection : connections) {
            graph[oneConnection.get(0)].add(oneConnection.get(1));
            graph[oneConnection.get(1)].add(oneConnection.get(0));
        }

        HashSet<List<Integer>> connectionsSet = new HashSet<>(connections);
        int[] rank = new int[n];
        Arrays.fill(rank, -2);

        dfs(graph, 0, 0, rank, connectionsSet);

        return new ArrayList<>(connectionsSet);
    }

    private static int dfs(List<Integer>[] graph, int node, int depth, int[] rank, HashSet<List<Integer>> connectionsSet) {
        if (rank[node] >= 0) {
            return rank[node]; // already visited node. return its rank
        }
        rank[node] = depth;
        int minDepthFound = depth; // can be Integer.MAX_VALUE also.
        for (Integer neighbor : graph[node]) {
            if (rank[neighbor] == depth - 1) { // ignore parent
                continue;
            }
            int minDepth = dfs(graph, neighbor, depth + 1, rank, connectionsSet);
            minDepthFound = Math.min(minDepthFound, minDepth);
            if (minDepth <= depth) {
                // to avoid the sorting just try to remove both combinations. of (x,y) and (y,x)
                connectionsSet.remove(Arrays.asList(node, neighbor));
                connectionsSet.remove(Arrays.asList(neighbor, node));
            }
        }
        return minDepthFound;
    }
}
