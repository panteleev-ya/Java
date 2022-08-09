package Task6;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        HashMap<Integer, Vertex> vertexMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int from = scanner.nextInt();
            int to = scanner.nextInt();

            // Если у нас нет вертекса - создать дефолтный вертекс
            vertexMap.putIfAbsent(from, new Vertex());
            vertexMap.putIfAbsent(to, new Vertex());

            if (from == to) {
                // Если from == to, то это петля из from в from
                vertexMap.get(from).incLoops();
            } else {
                // Иначе в "to" можно попасть еще и из "from"
                vertexMap.get(to).addWay(vertexMap.get(from));
            }
        }

        int longestWay = 0;
        for (Map.Entry<Integer, Vertex> entry : vertexMap.entrySet()) {
            longestWay = Math.max(longestWay, entry.getValue().getLongestChainLength());
        }
        System.out.println(longestWay);
    }

    private static class Vertex {
        private final List<Vertex> waysFrom;
        private int loopsCount;
        private int longestChainLength;

        public Vertex() {
            this.loopsCount = 0;
            this.waysFrom = new ArrayList<>();
            this.longestChainLength = -1;
        }

        public void incLoops() {
            loopsCount++;
        }

        public void addWay(Vertex v) {
            waysFrom.add(v);
        }

        public int getLongestChainLength() {
            if (longestChainLength != -1) {
                return longestChainLength; // pre-calculated
            }

            int chainLength = 0;
            for (Vertex vertex : waysFrom) {
                chainLength = Math.max(chainLength, vertex.getLongestChainLength() + 1);
            }

            return (longestChainLength = chainLength + loopsCount);
        }
    }
}
