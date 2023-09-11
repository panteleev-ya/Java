package Day23;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {
    public static void main(String[] args) {

    }

    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses, Comparator.comparingInt(a -> a[1]));
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        int time = 0;
        for (int[] course : courses) {
            if (time + course[0] <= course[1]) {
                queue.offer(course[0]);
                time += course[0];
            } else if (!queue.isEmpty() && queue.peek() > course[0]) {
                time += course[0] - queue.poll();
                queue.offer(course[0]);
            }
        }
        return queue.size();
    }
}
