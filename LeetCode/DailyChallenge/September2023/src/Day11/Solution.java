package Day11;

public class Solution {
    public static void main(String[] args) {
        int n = 50;
        System.out.println(countVowelStrings(n));
    }

    public static int countVowelStrings(int n) {
        int[] counts = {1, 1, 1, 1, 1};
        for (int step = 0; step < n - 1; step++) {
            for (int i = 1; i < counts.length; i++) {
                counts[i] += counts[i - 1];
            }
        }
        int sum = 0;
        for (int count : counts) {
            sum += count;
        }
        return sum;
    }
}
