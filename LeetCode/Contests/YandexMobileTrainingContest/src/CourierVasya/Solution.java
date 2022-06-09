package CourierVasya;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        // Reading input and finding most left and most right coordinates
        Scanner console = new Scanner(System.in);
        int s = console.nextInt();
        int n = console.nextInt();
        int[] coordinates = new int[n];
        int left = Integer.MAX_VALUE;
        int right = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            coordinates[i] = console.nextInt();
            left = Math.min(left, coordinates[i]);
            right = Math.max(right, coordinates[i]);
        }

        // Getting distance from S to most left and from S to most right (except S itself) coordinates
        int leftDist = Math.abs(left - s);
        int rightDist = Math.abs(right - s);

        // If left < S < right -> go to the closest, go back and then go to the most far coordinate
        if (left <= s && s <= right) {
            System.out.println(2 * Math.min(leftDist, rightDist) + Math.max(leftDist, rightDist));
        } else if (s < left) {
            // If it is [S, left, ... , right], so just go to the right
            System.out.println(rightDist);
        } else {
            // If it is [left, ... , right, S], so just go to the left
            System.out.println(leftDist);
        }
    }
}
