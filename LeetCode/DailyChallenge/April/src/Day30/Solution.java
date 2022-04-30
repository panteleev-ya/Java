package Day30;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        String[][] equations;
        double[] values;
        String[][] queries;

        equations = new String[][]{{"x1", "x2"}, {"x2", "x3"}, {"x3", "x4"}, {"x4", "x5"}};
        values = new double[]{3.0, 4.0, 5.0, 6.0};
        queries = new String[][]{{"x1", "x1"}, {"x1", "x5"}, {"x5", "x2"}, {"x2", "x4"}, {"x2", "x2"}, {"x2", "x9"}, {"x9", "x9"}};

        List<List<String>> list1 = new ArrayList<>();
        for (String[] equation : equations) {
            List<String> line1 = new ArrayList<>(Arrays.asList(equation));
            list1.add(line1);
        }

        List<List<String>> list2 = new ArrayList<>();
        for (String[] query : queries) {
            List<String> line2 = new ArrayList<>(Arrays.asList(query));
            list2.add(line2);
        }

        System.out.println(Arrays.toString(calcEquation(list1, values, list2)));
    }

    private static Map<String, Map<String, Double>> makeGraph(List<List<String>> equations, double[] values) {
        // build a graph
        // like a -> b = values[i]
        // and b -> a  = 1.0 / values[i];
        Map<String, Map<String, Double>> graph = new HashMap<>();
        String a;
        String b;

        for (int i = 0; i < equations.size(); i++) {
            a = equations.get(i).get(0);
            b = equations.get(i).get(1);

            graph.putIfAbsent(a, new HashMap<>());
            graph.get(a).put(b, values[i]);

            graph.putIfAbsent(b, new HashMap<>());
            graph.get(b).put(a, 1 / values[i]);

        }
        return graph;
    }

    public static double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Map<String, Double>> graph = makeGraph(equations, values);

        double[] answer = new double[queries.size()];

        // check for every Query
        // store it in answer array;
        for (int i = 0; i < queries.size(); i++) {
            String a = queries.get(i).get(0);
            String b = queries.get(i).get(1);

            // We find way from src to dest
            // Like x1 / x5 = (x1 / x2) * (x2 / x3) * (x3 / x4) * (x4 / x5);
            // or x1 / x1 = (x1 / x2) * (x2 / x1); // = 1
            answer[i] = dfs(a, b, new HashSet<>(), graph);
        }
        return answer;
    }

    public static double dfs(String src, String dest, Set<String> visited, Map<String, Map<String, Double>> graph) {
        // If src is not present in graph return -1.0;
        if (!graph.containsKey(src)) {
            return -1.0;
        }

        // If we have a way from src to dest -> return it
        if (graph.get(src).containsKey(dest)) {
            return graph.get(src).get(dest);
        }

        visited.add(src);
        for (Map.Entry<String, Double> nbr : graph.get(src).entrySet()) {
            if (!visited.contains(nbr.getKey())) {
                // Trying to find the way from src to dest trough other variables
                double weight = dfs(nbr.getKey(), dest, visited, graph);
                if (weight != -1.0) {
                    return nbr.getValue() * weight;
                }
            }
        }
        return -1.0;
    }
}
