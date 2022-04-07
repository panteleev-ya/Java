package Day7;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {
    public static void main(String[] args) {
        int[] stones = {7, 6, 7, 6, 9};
        System.out.println(lastStoneWeight(stones));
    }
    public static int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(i -> -i));
        for (int stone: stones){
            priorityQueue.add(stone);
        }
        while (priorityQueue.size() > 1){
            int a = priorityQueue.peek();
            priorityQueue.poll();
            int b = priorityQueue.peek();
            priorityQueue.poll();
            if (a != b) {
                priorityQueue.add(Math.abs(a - b));
            }
        }

        if (priorityQueue.isEmpty()) {
            return 0;
        }
        return priorityQueue.peek();
    }
}
