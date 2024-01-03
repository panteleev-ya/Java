package Day18;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
//        int[][] mat = {
//                {1, 1, 0, 0, 0},
//                {1, 1, 1, 1, 0},
//                {1, 0, 0, 0, 0},
//                {1, 1, 0, 0, 0},
//                {1, 1, 1, 1, 1}
//        };
//        int k = 3;
        int[][] mat = {
                {1, 0}, {1, 0}, {1, 0}, {1, 1}
        };
        int k = 4;
        System.out.println(Arrays.toString(new Solution().kWeakestRows(mat, k)));
    }

    public int[] kWeakestRows(int[][] mat, int k) {
        int[] soldiers = new int[mat.length];

        for (int i = 0; i < mat.length; i++) {
            soldiers[i] = countSoldiers(mat[i]);
        }

        int[] weakOrder = new int[k];

        for (int i = 0; i < k; i++) {
            int index = indexOfLeast(soldiers);
            soldiers[index] = -1;
            weakOrder[i] = index;
        }

        return weakOrder;
    }

    private int countSoldiers(int[] row) {
        int start = 0;
        int end = row.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (row[mid] < 1) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return start;
    }

    private int indexOfLeast(int[] arr) {
        int least = Integer.MAX_VALUE;
        int index = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= 0 && arr[i] < least) {
                least = arr[i];
                index = i;
            }
        }
        return index;
    }
}
