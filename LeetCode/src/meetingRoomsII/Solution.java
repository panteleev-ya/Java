package meetingRoomsII;

import java.util.PriorityQueue;

public class Solution {
    public static void main(String[] args) {
        // [[2,11],[6,16],[11,16]]
        System.out.println(new Solution().minMeetingRooms(new int[][]{{2, 11}, {6, 16}, {11, 16}}));
    }

    private static class Event implements Comparable<Event> {
        int time;
        boolean isStart;

        public Event(int time, boolean isStart) {
            this.time = time;
            this.isStart = isStart;
        }

        @Override
        public int compareTo(Event o) {
            if (this.time != o.time) {
                return this.time - o.time;
            }
            if (this.isStart) {
                return 1;
            }
            return -1;
        }
    }

    public int minMeetingRooms(int[][] intervals) {
        // 1. We want to go through the intervals,
        // convert each `interval = {start: int, end: int}` to `event = {time: int, isStart: bool}`
        // 2. Put every `event` into PriorityQueue, which will sort them by `event.time`
        // 3. Loop through the PriorityQueue while it is not empty, each time pulling one `event`.
        //  - If `event.isStart == true` - increase `meatingsRunning` by 1,
        //    update `maxMeatingsRunning` if `meatingsRunning` is greater than it.
        //  - Else (`event.isStart == false` => some meeting that previously started now ended) -
        //    decrease `meatingsRunning` by 1
        // 4. Return `maxMeatingsRunning`


        // [[2,11],[6,16],[11,16]]
        // 1. [{2, true}, {6, true}, {11, false}, {11, true}, {16, false}, {16, false}]


        if (intervals == null) {
            return 0;
        }

        PriorityQueue<Event> events = new PriorityQueue<>();
        for (int[] interval : intervals) {
            Event startEvent = new Event(interval[0], true);
            Event endEvent = new Event(interval[1], false);
            events.add(startEvent);
            events.add(endEvent);
        }

        int meatingsRunning = 0;
        int maxMeatingsRunning = 0;
        while (!events.isEmpty()) {
            Event event = events.poll();
            if (event.isStart) {
                meatingsRunning++;
                maxMeatingsRunning = Math.max(maxMeatingsRunning, meatingsRunning);
            } else {
                meatingsRunning--;
            }
        }

        return maxMeatingsRunning;
    }
}
