package NumberOfRecentCalls;

import java.util.ArrayList;

public class RecentCounter {

    ArrayList<Integer> requests = new ArrayList<>();
    int lastStartIndex = 0;

    public RecentCounter() {

    }

    public int ping(int t) {
        requests.add(t);
        int start = Math.max((t - 3000), 0);
        int startIndex = lastStartIndex;

        // Находим такой "тайминг", который соответствует началу диапазона
        while (requests.get(startIndex) < start) {
            startIndex++;
        }

        lastStartIndex = startIndex;
        return requests.size() - startIndex;
    }
}
