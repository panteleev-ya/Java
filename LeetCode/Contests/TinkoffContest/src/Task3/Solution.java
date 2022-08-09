package Task3;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int multiplier = 1;
        int sum = 0;
        int minPositive = Integer.MAX_VALUE;
        int maxNegative = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int next = scanner.nextInt() * multiplier;
            multiplier *= -1;

            if (next < 0) {
                maxNegative = Math.min(maxNegative, next);
            } else {
                minPositive = Math.min(minPositive, next);
            }

            sum += next;
        }

        int replacedDaysSum = sum - 2 * minPositive - 2 * maxNegative;

        System.out.println(Math.max(sum, replacedDaysSum));
    }
}
