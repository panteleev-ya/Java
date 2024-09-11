package meetingRoomsIII;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution {
    public static void main(String[] args) {
        // [[0,10],[1,5],[2,7],[3,4]]
        System.out.println(new Solution().mostBooked(2, new int[][]{{0, 10}, {1, 5}, {2, 7}, {3, 4}}));
    }

    public int mostBooked(int n, int[][] meetings) {
        int[] meetingCount = new int[n];
        PriorityQueue<long[]> usedRooms = new PriorityQueue<>((a, b) -> a[0] != b[0] ? Long.compare(a[0], b[0]) : Long.compare(a[1], b[1]));
        PriorityQueue<Integer> unusedRooms = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            unusedRooms.offer(i);
        }

        Arrays.sort(meetings, (a, b) -> a[0] != b[0] ? Integer.compare(a[0], b[0]) : Integer.compare(a[1], b[1]));

        for (int[] meeting : meetings) {
            int start = meeting[0];
            int end = meeting[1];

            // emptying previously used rooms that are now free
            while (!usedRooms.isEmpty() && usedRooms.peek()[0] <= start) {
                int room = (int) usedRooms.poll()[1];
                unusedRooms.offer(room);
            }

            if (!unusedRooms.isEmpty()) {
                // if there are unused rooms, peek the one with the lowest number
                int room = unusedRooms.poll();
                usedRooms.offer(new long[]{end, room});
                meetingCount[room]++;
            } else {
                // "waiting" until any room will be free (at roomAvailabilityTime),
                // using it for another end-start time units (from roomAvailabilityTime)
                // meaning that room is used now until roomAvailabilityTime+(end-start)
                long roomAvailabilityTime = usedRooms.peek()[0];
                int room = (int) usedRooms.poll()[1];
                usedRooms.offer(new long[]{roomAvailabilityTime + end - start, room});
                meetingCount[room]++;
            }
        }

        int maxMeetingCountRoom = 0;
        for (int i = 0; i < n; i++) {
            if (meetingCount[i] > meetingCount[maxMeetingCountRoom]) {
                maxMeetingCountRoom = i;
            }
        }

        return maxMeetingCountRoom;
    }
}
