package Distance;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int n = console.nextInt();
        int k = console.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = console.nextInt();
        }

        // Sorting values
        Pair[] sortedNums = new Pair[n];
        for (int i = 0; i < n; i++) {
            sortedNums[i] = new Pair(i, a[i]);
        }
        Arrays.sort(sortedNums);

        // Counting distances
        int[] functionValues = new int[n];
        for (int i = 0; i < n; i++) {
            int K = k;
            int stepLeft = 1;
            int stepRight = 1;
            int index = sortedNums[i].index;
            int value = sortedNums[i].value;
            while (K > 0) {
                int left = Integer.MAX_VALUE;
                int right = Integer.MAX_VALUE;
                if (i - stepLeft >= 0) {
                    left = Math.abs(value - sortedNums[i - stepLeft].value);
                }
                if (i + stepRight < n) {
                    right = Math.abs(value - sortedNums[i + stepRight].value);
                }
                if (left <= right) {
                    functionValues[index] += left;
                    stepLeft++;
                } else {
                    functionValues[index] += right;
                    stepRight++;
                }
                K--;
            }
        }

        // Printing answer
        for (int i = 0; i < n; i++) {
            System.out.print(functionValues[i] + " ");
        }
    }

    private static class Pair implements Comparable<Pair> {
        public int index;
        public int value;

        public Pair(int index, int value) {
            this.index = index;
            this.value = value;
        }

        @Override
        public int compareTo(Pair o) {
            return this.value - o.value;
        }
    }
}
