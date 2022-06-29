package Day29;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static void main(String[] args) {

    }

    public static int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (p1, p2) -> p1[0] != p2[0] ? p2[0] - p1[0] : p1[1] - p2[1]);
        List<int[]> insertingByIndexK = new ArrayList<>();
        for (int[] person : people) {
            insertingByIndexK.add(person[1], person);
        }
        return insertingByIndexK.toArray(new int[people.length][]);
    }
}
