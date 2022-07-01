package Day1;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public static void main(String[] args) {
        System.out.println(maximumUnits(new int[][]{{1, 3}, {2, 2}, {3, 1}}, 4));
    }

    public static int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, Comparator.comparingInt(o -> -o[1]));
        int unitsNumber = 0;
        for (int[] boxType : boxTypes) {
            if (truckSize > boxType[0]) {
                unitsNumber += boxType[0] * boxType[1];
                truckSize -= boxType[0];
            } else {
                unitsNumber += truckSize * boxType[1];
                break;
            }
        }
        return unitsNumber;
    }
}
