package intervalListIntersections;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        List<int[]> ans = new ArrayList<>();
        int i = 0;
        int j = 0;

        while (i < firstList.length && j < secondList.length) {
            // Let's check if firstList[i] intersects secondList[j].
            // maxStart - the startpoint of the intersection
            // minEnd - the endpoint of the intersection
            int maxStart = Math.max(firstList[i][0], secondList[j][0]);
            int minEnd = Math.min(firstList[i][1], secondList[j][1]);
            if (maxStart <= minEnd) {
                ans.add(new int[]{maxStart, minEnd});
            }

            // Remove the interval with the smallest endpoint
            if (firstList[i][1] < secondList[j][1]) {
                i++;
            } else {
                j++;
            }
        }

        return ans.toArray(new int[ans.size()][]);
    }
}
