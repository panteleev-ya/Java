package SpiralMatrixII;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int n = 5;
        System.out.println(Arrays.deepToString(generateMatrix(n)));
    }

    public static int[][] generateMatrix(int n) {
        int number = 1;
        int[][] matrix = new int[n][n];
        int len = n - 1;
        int i = 0, j = 1;
        matrix[0][0] = 1;
        while (len > 0) {
            // Идем вправо
            for (int k = 0; k < len; k++) {
                matrix[i][j++] = ++number;
            }
            // Двигаем указатель вниз
            j--;
            i++;

            // Идем вниз
            for (int k = 0; k < len; k++) {
                matrix[i++][j] = ++number;
            }
            // Двигаем указатель влево
            i--;
            j--;

            // Идем влево
            for (int k = 0; k < len; k++) {
                matrix[i][j--] = ++number;
            }
            // Двигаем указатель вверх
            i--;
            j++;

            // Идем вверх
            for (int k = 0; k < len - 1; k++) {
                matrix[i--][j] = ++number;
            }
            // Двигаем указатель вправо
            i++;
            j++;

            // Шаг в центр (если еще не конец)
            if (number >= n * n) {
                return matrix;
            }
            matrix[i][j++] = ++number;

            // Уменьшаем длину "шага" на 2
            len -= 2;
        }
        return matrix;
    }
}
