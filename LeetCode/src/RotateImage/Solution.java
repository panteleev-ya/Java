package RotateImage;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int[][] matrix = {{5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}};
        // int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        rotate(matrix);
        System.out.println(Arrays.deepToString(matrix));
    }

    public static void rotate(int[][] matrix) {
        if (matrix.length < 2) {
            return;
        }
        for (int kMax = matrix.length - 1,
             ind = 0,
             indMax = matrix.length - 1,
             tmp;
             kMax >= 1; // statement
             kMax -= 2, ind++, indMax--) // increment
        {
            for (int k = 0; k < kMax; k++) {
                // Свапаем верх и право
                tmp = matrix[ind + k][indMax];
                matrix[ind + k][indMax] = matrix[ind][ind + k];
                matrix[ind][ind + k] = tmp;

                // Свапаем верх и низ
                tmp = matrix[indMax][indMax - k];
                matrix[indMax][indMax - k] = matrix[ind][ind + k];
                matrix[ind][ind + k] = tmp;

                // Свапаем верх и лево
                tmp = matrix[indMax - k][ind];
                matrix[indMax - k][ind] = matrix[ind][ind + k];
                matrix[ind][ind + k] = tmp;

                // Все по кругу свапнули
                k++;
            }
        }
    }
}
