package Day21;

import java.util.Collections;
import java.util.PriorityQueue;

public class Solution {
    public static void main(String[] args) {
        System.out.println(furthestBuilding(new int[]{4, 12, 2, 7, 3, 18, 20, 3, 19}, 10, 2));
        System.out.println(furthestBuilding(new int[]{4, 2, 7, 6, 9, 14, 12}, 5, 1));
        System.out.println(furthestBuilding(new int[]{14, 3, 19, 3}, 17, 0));
    }

    public static int furthestBuilding(int[] heights, int bricks, int ladders) {
        PriorityQueue<Integer> usedBricksPQ = new PriorityQueue<>(Collections.reverseOrder());

        int i;
        for (i = 1; i < heights.length; i++) {
            int heightDiff = heights[i] - heights[i - 1];

            if (heightDiff <= 0) {
                continue;
            }

            if (heightDiff <= bricks) {
                bricks -= heightDiff;
                usedBricksPQ.offer(heightDiff);
            } else if (ladders > 0) {
                if (!usedBricksPQ.isEmpty() && usedBricksPQ.peek() > heightDiff) {
                    bricks += usedBricksPQ.poll();
                    bricks -= heightDiff;
                    usedBricksPQ.offer(heightDiff);
                }
                ladders--;
            } else {
                break;
            }
        }

        return i - 1;
    }
}
