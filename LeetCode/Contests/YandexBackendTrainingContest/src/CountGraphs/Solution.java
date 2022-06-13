package CountGraphs;

import java.util.*;

public class Solution {

    private static int[] vertexesWeights;
    private static Set<Integer> allVertexes;
    private static List<Set<Integer>> unusedVertexes;
    private static int n;
    private static long graphsCount;

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        n = console.nextInt();
        graphsCount = 0;

        // Initialize vertexes
        allVertexes = new HashSet<>();
        for (int i = 0; i < n; i++) {
            allVertexes.add(i);
        }

        // Create vertexes weights array
        vertexesWeights = new int[n];
        vertexesWeights[0] = n - 1;

        // Create unused vertexes sets for each vertex
        unusedVertexes = new ArrayList<>(n);
        unusedVertexes.add(new HashSet<>()); // for vertex 0 every other vertex is already used
        for (int i = 1; i < n; i++) {
            Set<Integer> iVertexes = new HashSet<>(allVertexes);
            iVertexes.remove(i);
            unusedVertexes.add(iVertexes);
        }

        // Out of memory
        dfs();

        System.out.println(graphsCount);
    }

    private static void dfs() {
        graphsCount++;
        for (int vertex: allVertexes) {
            if (vertexesWeights[vertex] >= n - 2) {
                continue;
            }
            Set<Integer> vertexUnusedVertexes = unusedVertexes.get(vertex);
            for (int unusedVertex: vertexUnusedVertexes) {
                if (vertexesWeights[unusedVertex] >= n - 2) {
                    continue;
                }
                vertexUnusedVertexes.remove(unusedVertex);
                vertexesWeights[vertex]++;
                vertexesWeights[unusedVertex]++;
                dfs();
                vertexUnusedVertexes.add(unusedVertex);
                vertexesWeights[vertex]--;
                vertexesWeights[unusedVertex]--;
            }
        }
    }
}
