package ReconstructItinerary;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class BetterSolution {
    public List<String> findItinerary(List<List<String>> tickets) {
        HashMap<String, PriorityQueue<String>> flights = new HashMap<>();
        for (List<String> ticket : tickets) {
            if (!flights.containsKey(ticket.get(0))) {
                flights.put(ticket.get(0), new PriorityQueue<>());
            }
            flights.get(ticket.get(0)).add(ticket.get(1));
        }
        List<String> result = new LinkedList<>();
        fi(result, "JFK", flights);
        return result;
    }
    private void fi(List<String> result, String port, HashMap<String, PriorityQueue<String>> flights) {
        PriorityQueue<String> q = flights.get(port);
        while (q != null && !q.isEmpty()) {
            fi(result, q.poll(), flights);
        }
        result.add(0, port);
    }
}
