package Day26;

public class Solution {
    public static void main(String[] args) {
        System.out.println(maxScore(new int[]{1, 2, 3, 4, 5, 6, 1}, 3));
        System.out.println(maxScore(new int[]{9, 7, 7, 9, 7, 7, 9}, 7));
    }

    public static int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int l = 0;
        int r = n - k;

        int total = 0;
        for (int i = r; i < n; i++) {
            total += cardPoints[i];
        }

        int result = total;
        for (; r < n; l++, r++) {
            total += (cardPoints[l] - cardPoints[r]);
            result = Math.max(result, total);
        }
        return result;
    }
}
