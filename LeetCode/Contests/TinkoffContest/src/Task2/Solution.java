package Task2;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        HashMap<Set<String>, Integer> counterMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String teamInfo = scanner.nextLine();
            counterMap.merge(Set.of(teamInfo.split(" ")), 1, Integer::sum);
        }

        int maxCount = 0;
        for (Map.Entry<Set<String>, Integer> e : counterMap.entrySet()) {
            maxCount = Math.max(maxCount, e.getValue());
        }

        System.out.println(maxCount);
    }
}
