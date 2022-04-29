package Day29;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int[][] graph1 = {{1, 2, 3}, {0, 2}, {0, 1, 3}, {0, 2}};
        System.out.println(isBipartite(graph1));
        int[][] graph2 = {{1, 3}, {0, 2}, {1, 3}, {0, 2}};
        System.out.println(isBipartite(graph2));
    }

    public static boolean isBipartite(int[][] graph) {
        int n = graph.length;
        Colors[] color = new Colors[n];
        Arrays.fill(color, Colors.UNCOLORED);
        BooleanPointer isBipartite = new BooleanPointer(true);
        for (int i = 0; i < n; i++) {
            if (color[i] == Colors.UNCOLORED) {
                dfs(graph, color, i, Colors.WHITE, isBipartite);
                if (!isBipartite.getValue()) {
                    return false;
                }
            }
        }
        return true;
    }

    private enum Colors {
        UNCOLORED,
        WHITE,
        BLACK,
    }

    private static Colors nextColor(Colors color) {
        if (color == Colors.WHITE) {
            return Colors.BLACK;
        }
        return Colors.WHITE;
    }

    private static class BooleanPointer {
        private boolean value;
        BooleanPointer(boolean value) {
            this.value = value;
        }
        public boolean getValue() {
            return value;
        }
        public void setValue(boolean value) {
            this.value = value;
        }
    }

    private static void dfs(int[][] graph, Colors[] color, int from, Colors vertexColor, BooleanPointer isBipartite) {
        color[from] = vertexColor;
        for (int to : graph[from]) {
            if (color[to] == Colors.UNCOLORED) {
                dfs(graph, color, to, nextColor(vertexColor), isBipartite);
            }
            else if (color[to] == vertexColor) {
                isBipartite.setValue(false);
                return;
            }
        }
    }
}