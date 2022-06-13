package Andrey;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int n = console.nextInt();
        int[] reservoirs = new int[n];
        for (int i = 0; i < n; i++) {
            reservoirs[i] = console.nextInt();
        }

        // Check if filling reservoirs is available
        int minVolumeRequired = reservoirs[0];
        int operationsCount = 0;
        for (int i = 1; i < n; i++) {
            if (minVolumeRequired < reservoirs[i]) {
                operationsCount += reservoirs[i] - minVolumeRequired;
                minVolumeRequired = reservoirs[i];
            } else if (minVolumeRequired > reservoirs[i]) {
                System.out.println(-1);
                return;
            }
        }
        System.out.println(operationsCount);
    }
}
