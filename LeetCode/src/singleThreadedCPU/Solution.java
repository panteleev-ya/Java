package singleThreadedCPU;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().getOrder(new int[][]{
                new int[]{19, 13},
                new int[]{16, 9},
                new int[]{21, 10},
                new int[]{32, 25},
                new int[]{37, 4},
                new int[]{49, 24},
                new int[]{2, 15},
                new int[]{38, 41},
                new int[]{37, 34},
                new int[]{33, 6},
                new int[]{45, 4},
                new int[]{18, 18},
                new int[]{46, 39},
                new int[]{12, 24}
        })));
    }

    public int[] getOrder(int[][] tasks) {
        Task[] sortedTasks = new Task[tasks.length];
        for (int i = 0; i < tasks.length; i++) {
            sortedTasks[i] = new Task(tasks[i][0], tasks[i][1], i);
        }

        // sort by enqueue time
        Arrays.sort(sortedTasks, Comparator.comparingInt(a -> a.enqueueTime));

        // queue for available tasks sorted by process time and index
        PriorityQueue<Task> pq = new PriorityQueue<>((t1, t2) -> {
            if (t1.processTime != t2.processTime) {
                return t1.processTime - t2.processTime;
            }
            return t1.index - t2.index;
        });

        int enqueueIndex = 0;
        int processIndex = 0;
        int[] ans = new int[sortedTasks.length];
        int time = 0;

        while (processIndex < sortedTasks.length) {
            if (pq.isEmpty()) {
                time = sortedTasks[enqueueIndex].enqueueTime; // shift timer to the enqueuing time of the next task
            } else {
                Task task = pq.poll();
                ans[processIndex] = task.index;
                processIndex++;
                time += task.processTime; // shift timer to the task execution finish time
            }

            // put new tasks in pq, which were enqueued while executing this task
            while (enqueueIndex < sortedTasks.length && time >= sortedTasks[enqueueIndex].enqueueTime) {
                pq.add(sortedTasks[enqueueIndex]);
                enqueueIndex++;
            }
        }

        return ans;
    }

    private static class Task {
        int enqueueTime;
        int processTime;
        int index;

        public Task(int enqueueTime, int processTime, int index) {
            this.enqueueTime = enqueueTime;
            this.processTime = processTime;
            this.index = index;
        }
    }
}