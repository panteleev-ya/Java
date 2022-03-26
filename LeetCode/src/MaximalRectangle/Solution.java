package MaximalRectangle;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        char[][] matrix = {{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};
        System.out.println(maximalRectangle(matrix));
    }
    public static int maximalRectangle(char[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int area = 0;
        int rectHeight;
        int height;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] != '0') {
                    rectHeight = 0;
                    // Идем по всем отрезкам из '1'
                    for (int j1 = j; j1 < m && matrix[i][j1] != '0'; j1++) {
                        height = 0;
                        for (int i1 = i; i1 < n && matrix[i1][j1] != '0'; i1++) {
                            height++;
                        }
                        // Если это первый столбец прямоугольника - задаем его размер
                        if (rectHeight == 0) {
                            rectHeight = height;
                        }
                        else {
                            // Иначе если текущая высота больше высоты нового столбца - уменьшаем высоту
                            if (rectHeight > height)
                                rectHeight = height;
                        }
                        if (area < rectHeight * (j1 - j + 1))
                            area = rectHeight * (j1 - j + 1);
                    }
                }
            }
        }
        return area;
    }
}
