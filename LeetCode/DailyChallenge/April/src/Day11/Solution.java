package Day11;

import java.util.Arrays;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        int[][] grid = {{1,2,3},{4,5,6},{7,8,9}};
        System.out.println(shiftGrid(grid, 3));
//        System.out.println(shiftGrid(grid, 1));
//        System.out.println(shiftGrid(grid, 2));
//        System.out.println(shiftGrid(grid, 3));
//        System.out.println(shiftGrid(grid, 4));
//        System.out.println(shiftGrid(grid, 5));
//        System.out.println(shiftGrid(grid, 6));
//        System.out.println(shiftGrid(grid, 7));
//        System.out.println(shiftGrid(grid, 8));
//        System.out.println(shiftGrid(grid, 9));
    }
    public static List<List<Integer>> shiftGrid(int[][] grid, int k) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return null;
        }
        int n = grid.length;
        int m = grid[0].length;
        int linearSize = n * m;
        k = k % (n * m);

        // Превращаем плоскость в линию, сдвигаем элементы
        int[] linearGrid = new int[linearSize];
        int linearIndex;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                linearIndex = (i * m + j + k) % linearSize;
                linearGrid[linearIndex] = grid[i][j];
            }
        }

        // Превращаем линию обратно в плоскость
        int[][] shiftedGrid = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                linearIndex = (i * m + j);
                shiftedGrid[i][j] = linearGrid[linearIndex];
            }
        }
        return (List) Arrays.asList(shiftedGrid);
    }
}
