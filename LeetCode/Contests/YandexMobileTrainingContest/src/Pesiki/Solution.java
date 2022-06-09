package Pesiki;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        // Reading input
        Scanner console = new Scanner(System.in);
        int n = console.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = console.nextInt();
        }
        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            b[i] = console.nextInt();
        }

        // Looking for the best start point, so the sum of dogs dissatisfaction are minimum
        long minSum = Integer.MAX_VALUE;
        int bestStart = 0;
        for (int start = 0; start < n; start++) {
            long sum = 0;
            for (int i = start; i < n + start; i++) {
                sum += dogDissatisfaction(a[i % n], b[i - start]);
            }
            if (sum < minSum) {
                minSum = sum;
                bestStart = start;
            }
        }

        System.out.println((bestStart + 1) + " " + minSum);
    }

    private static int dogDissatisfaction(int dogSize, int ringSize) {
        if (dogSize >= ringSize) {
            return 0;
        }
        if (ringSize - dogSize <= 100) {
            return (ringSize - dogSize) / 2;
        }

        return 30;
    }
}
