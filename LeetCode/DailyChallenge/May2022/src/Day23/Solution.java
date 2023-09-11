package Day23;

public class Solution {
    public static void main(String[] args) {
        String[] strs = {"10", "0001", "111001", "1", "0"};
        int m = 5, n = 3;
        System.out.println(findMaxForm(strs, m, n));
    }

    public static int findMaxForm(String[] strs, int m, int n) {
        Pair[] pairs = new Pair[strs.length];
        for (int i = 0; i < strs.length; i++) {
            pairs[i] = new Pair(strs[i]);
        }

        int[][] arr = new int[m + 1][n + 1];

        for (Pair p : pairs) {
            for (int i = m; i >= p.zeros; i--) {
                for (int j = n; j >= p.ones; j--) {
                    arr[i][j] = Math.max(arr[i][j], arr[i - p.zeros][j - p.ones] + 1);
                }
            }
        }

        return arr[m][n];
    }

    private static class Pair {
        public int zeros;
        public int ones;

        public Pair(int zeros, int ones) {
            this.zeros = zeros;
            this.ones = ones;
        }

        public Pair(String s) {
            this.zeros = 0;
            this.ones = 0;
            for (char digit : s.toCharArray()) {
                if (digit == '0') {
                    this.zeros++;
                } else {
                    this.ones++;
                }
            }
        }
    }
}
