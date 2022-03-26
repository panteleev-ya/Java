package ReconstructItinerary;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
//        String[][] t = {{"MUC","LHR"},{"JFK","MUC"},{"SFO","SJC"},{"LHR","SFO"}, {"JFK", "LHR"}, {"SFO", "JFK"}};
//        String[][] t = {{"JFK","SFO"},{"JFK","ATL"},{"SFO","ATL"},{"ATL","JFK"},{"ATL","SFO"}};
//        String[][] t = {{"JFK","ATL"},{"ATL","JFK"}};
//        String[][] t = {{"EZE","AXA"},{"TIA","ANU"},{"ANU","JFK"},{"JFK","ANU"},{"ANU","EZE"},{"TIA","ANU"},{"AXA","TIA"},{"TIA","JFK"},{"ANU","TIA"},{"JFK","TIA"}};
        String[][] t = {{"AXA","EZE"},{"EZE","AUA"},{"ADL","JFK"},{"ADL","TIA"},{"AUA","AXA"},{"EZE","TIA"},{"EZE","TIA"},{"AXA","EZE"},{"EZE","ADL"},{"ANU","EZE"},{"TIA","EZE"},{"JFK","ADL"},{"AUA","JFK"},{"JFK","EZE"},{"EZE","ANU"},{"ADL","AUA"},{"ANU","AXA"},{"AXA","ADL"},{"AUA","JFK"},{"EZE","ADL"},{"ANU","TIA"},{"AUA","JFK"},{"TIA","JFK"},{"EZE","AUA"},{"AXA","EZE"},{"AUA","ANU"},{"ADL","AXA"},{"EZE","ADL"},{"AUA","ANU"},{"AXA","EZE"},{"TIA","AUA"},{"AXA","EZE"},{"AUA","SYD"},{"ADL","JFK"},{"EZE","AUA"},{"ADL","ANU"},{"AUA","TIA"},{"ADL","EZE"},{"TIA","JFK"},{"AXA","ANU"},{"JFK","AXA"},{"JFK","ADL"},{"ADL","EZE"},{"AXA","TIA"},{"JFK","AUA"},{"ADL","EZE"},{"JFK","ADL"},{"ADL","AXA"},{"TIA","AUA"},{"AXA","JFK"},{"ADL","AUA"},{"TIA","JFK"},{"JFK","ADL"},{"JFK","ADL"},{"ANU","AXA"},{"TIA","AXA"},{"EZE","JFK"},{"EZE","AXA"},{"ADL","TIA"},{"JFK","AUA"},{"TIA","EZE"},{"EZE","ADL"},{"JFK","ANU"},{"TIA","AUA"},{"EZE","ADL"},{"ADL","JFK"},{"ANU","AXA"},{"AUA","AXA"},{"ANU","EZE"},{"ADL","AXA"},{"ANU","AXA"},{"TIA","ADL"},{"JFK","ADL"},{"JFK","TIA"},{"AUA","ADL"},{"AUA","TIA"},{"TIA","JFK"},{"EZE","JFK"},{"AUA","ADL"},{"ADL","AUA"},{"EZE","ANU"},{"ADL","ANU"},{"AUA","AXA"},{"AXA","TIA"},{"AXA","TIA"},{"ADL","AXA"},{"EZE","AXA"},{"AXA","JFK"},{"JFK","AUA"},{"ANU","ADL"},{"AXA","TIA"},{"ANU","AUA"},{"JFK","EZE"},{"AXA","ADL"},{"TIA","EZE"},{"JFK","AXA"},{"AXA","ADL"},{"EZE","AUA"},{"AXA","ANU"},{"ADL","EZE"},{"AUA","EZE"}};
//        String[][] t = {{"EZE","AXA"},{"TIA","ANU"},{"ANU","JFK"},{"JFK","ANU"},{"ANU","EZE"},{"TIA","ANU"},{"AXA","TIA"},{"TIA","JFK"},{"ANU","TIA"},{"JFK","TIA"}};
//        String[][] t = {{"EZE","TIA"},{"EZE","HBA"},{"AXA","TIA"},{"JFK","AXA"},{"ANU","JFK"},{"ADL","ANU"},{"TIA","AUA"},{"ANU","AUA"},{"ADL","EZE"},{"ADL","EZE"},{"EZE","ADL"},{"AXA","EZE"},{"AUA","AXA"},{"JFK","AXA"},{"AXA","AUA"},{"AUA","ADL"},{"ANU","EZE"},{"TIA","ADL"},{"EZE","ANU"},{"AUA","ANU"}};
        List<List<String>> tickets = new ArrayList<>();
        for (var ticket: t) {
            ArrayList<String> newTicket = new ArrayList<>();
            newTicket.add(ticket[0]);
            newTicket.add(ticket[1]);
            tickets.add(newTicket);
        }
        System.out.println(findItinerary(tickets));
    }

    // Класс указателя
    private static class Pointer<T> {
        private T value;
        public Pointer() {

        }
        public Pointer(T value) {
            this.value = value;
        }
        public T getValue() {
            return value;
        }
        public void setValue(T value) {
            this.value = value;
        }
    }

    public static List<String> findItinerary(List<List<String>> tickets) {
        HashMap<String, ArrayList<String>> g = new HashMap<>();
        HashMap<String, Integer> used = new HashMap<>();

        // Собираем граф и used для ребер
        generateGraphAndUsed(tickets, g, used);

        Pointer<ArrayList<String>> maxPath = new Pointer<>(new ArrayList<>());

        var city = "JFK";
        var path = new ArrayList<String>();
        path.add(city);

        dfs(city, used, g, path, maxPath);
        return maxPath.getValue();
    }

    public static void dfs(String from, HashMap<String, Integer> used, HashMap<String, ArrayList<String>> g, ArrayList<String> path, Pointer<ArrayList<String>> maxPath) {
        // Проходимся по всем смежным с from вершинам (потенциальные to)
        if (g.containsKey(from)) {
            for (var to : g.get(from)) {
                // Если по этому ребру мы еще не проходили - идем по нему
                String fromTo = from + to;
                int edgesCount = used.get(fromTo);
                if (edgesCount > 0) {
                    // Помечаем ребро, по которому прошли и добавляем в путь
                    used.replace(fromTo, edgesCount - 1);
                    path.add(to);

                    dfs(to, used, g, path, maxPath);

                    // Возвращаем в исходное состояние
                    used.replace(fromTo, edgesCount);
                    path.remove(path.size() - 1);
                }
            }
        }
        int maxDepth = maxPath.getValue().size();
        if (path.size() >= maxDepth) {
            if (path.size() == maxDepth) {
                if (checkLexicalOrder(path, maxPath.getValue())) {
//                    maxPath.setValue(new ArrayList<>(path));
                    maxPath.setValue(path);
                }
            } else {  // path.size() > maxDepth
//                maxPath.setValue(new ArrayList<>(path));
                maxPath.setValue(path);
            }
        }
    }
    public static void generateGraphAndUsed(List<List<String>> tickets, HashMap<String, ArrayList<String>> g, HashMap<String, Integer> used) {
        // Проходимся по всем ребрам
        for (var ticket: tickets) {
            String from = ticket.get(0);
            String to = ticket.get(1);
            String fromTo = from + to;
            // Если в мапе нет такой вершины - создаем
            if (!g.containsKey(from)) {
                g.put(from, new ArrayList<>());
            }
            // Добавляем к списку возможных перелетов из from еще один to
            g.get(from).add(to);

            // В used закидывает fromTo -> +1
            if (!used.containsKey(fromTo)) {
                used.put(fromTo, 1);
            } else {
                used.replace(fromTo, used.get(fromTo) + 1);
            }
        }
    }

    public static boolean checkLexicalOrder(ArrayList<String> path, ArrayList<String> maxPath) {
        StringBuilder leftSB = new StringBuilder();
        StringBuilder rightSB = new StringBuilder();
        for (var city: path) {
            leftSB.append(city);
        }
        for (var city: maxPath) {
            rightSB.append(city);
        }

        if (leftSB.toString().equals(rightSB.toString())) {
            return false;
        }

        char[] left = leftSB.toString().toCharArray();
        char[] right = rightSB.toString().toCharArray();
        if (left.length < right.length) {
            return true;
        } else if (left.length > right.length) {
            return false;
        }
        for (int i = 0; i < left.length; i++) {
            if (left[i] < right[i]) {
                return true;
            } else if (left[i] > right[i]) {
                return false;
            }
        }
        return false;
    }
}
