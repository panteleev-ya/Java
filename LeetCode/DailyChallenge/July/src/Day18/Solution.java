package Day18;

public class Solution {
    public static void main(String[] args) {

    }

    public int numSubMatrixSumTarget(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;
        int result = 0;

        // traverse upper boundary
        for (int top = 0; top < n; top++) {

            // for each upper boundary, we have a prefix sum array
            int[] sum = new int[m];

            // traverse lower boundary
            for (int bottom = top; bottom < n; bottom++) {

                // count the prefix sum for each column
                for (int col = 0; col < m; col++) {
                    sum[col] += matrix[bottom][col];
                }

                // traverse left and right boundary
                for (int left = 0; left < m; left++) {
                    int cnt = 0;
                    for (int right = left; right < m; right++) {
                        cnt += sum[right];
                        if (cnt == target) {
                            result++;
                        }
                    }
                }
            }
        }
        return result;
    }
}
