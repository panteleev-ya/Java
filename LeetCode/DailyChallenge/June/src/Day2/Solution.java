package Day2;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3, 33}, {4, 5, 6, 66}, {7, 8, 9, 99}};
        System.out.println(Arrays.deepToString(transpose(matrix)));
    }

    public static int[][] transpose(int[][] matrix) {
        if (matrix == null) {
            return null;
        }
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] transposeMatrix = new int[m][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                transposeMatrix[j][i] = matrix[i][j];
            }
        }
        return transposeMatrix;
    }
}
