package Day1;

public class Solution {
    public static void main(String[] args) {

    }

    public int uniquePaths(int m, int n) {
        int k = m + n - 2;
        long count = 1;
        for (int i = 1; i < n; i++) {
            count = count * (k - n  + i + 1) / i;
        }
        return (int) count;
    }
}
