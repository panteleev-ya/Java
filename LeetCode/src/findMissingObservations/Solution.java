package findMissingObservations;

import java.util.Arrays;

public class Solution {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int rollsSum = 0;
        for (int roll : rolls) {
            rollsSum += roll;
        }
        int missingSum = mean * (rolls.length + n) - rollsSum;
        if (missingSum < n || 6 * n < missingSum) {
            // either to low or to high to fill missing rolls with numbers between 1-6
            return new int[]{};
        }
        int[] missing = new int[n];
        int avg = missingSum / n;
        Arrays.fill(missing, avg);
        int reminder = missingSum % n;
        for (int i = 0; i < reminder; i++) {
            missing[i]++;
        }
        return missing;
    }
}