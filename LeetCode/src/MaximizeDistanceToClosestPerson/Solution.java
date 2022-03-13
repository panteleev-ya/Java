package MaximizeDistanceToClosestPerson;

public class Solution {
    public static void main(String[] args) {
//        int[] seats = {1,0,0,0,1,0,1};
        int[] seats = {0,1,0,1,0};
        System.out.println(maxDistToClosest(seats));
    }

    public static int maxDistToClosest(int[] seats) {
        int max = 0;
        int currentLength = 0;
        int j;
        for (int i = 0; i < seats.length;) {
            if (seats[i] == 0) {
                // Получаем длину цепочки пустых мест
                for (j = i; j < seats.length && seats[j] == 0; j++) {
                    currentLength++;
                }
                if (i == 0 || j == seats.length) {
                    max = Math.max(max, currentLength);
                } else {
                    max = Math.max(max, (currentLength + 1) / 2);
                }
                i = j;
                currentLength = 0;
            }
            else {
                i++;
            }
        }
        return max;
    }
}
