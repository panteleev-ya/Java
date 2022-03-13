package NumberOfIslands;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        char[][] grid = {{'1', '1', '1', '1', '0'}, {'1', '1', '0', '1', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '0', '0', '0'}};
        System.out.println(numIslands(grid));
    }
    public static int numIslands(char[][] grid) {
        int count = 0;
        boolean[][] flags = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                // Если это остров и мы на нем еще не были - добавляем
                if (grid[i][j] == '1' && !flags[i][j]) {
                    addIsland(grid, flags, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    private static void addIsland(char[][] grid, boolean[][] flags, int i, int j) {
        // Теперь мы здесь были
        flags[i][j] = true;

        // Есть шаг вправо - все еще остров, то нам надо его посетить
        if (j + 1 < grid[i].length && grid[i][j + 1] == '1' && !flags[i][j + 1]) {
            addIsland(grid, flags, i, j + 1);
        }

        // Если шаг вниз - все еще остров, то нам надо его посетить
        if (i + 1 < grid.length && grid[i + 1][j] == '1' && !flags[i + 1][j]) {
            addIsland(grid, flags, i + 1, j);
        }

        // Есть шаг налево - все еще остров, то нам надо его посетить
        if (j - 1 >= 0 && grid[i][j - 1] == '1' && !flags[i][j - 1]) {
            addIsland(grid, flags, i, j - 1);
        }

        // Есть шаг вверх - все еще остров, то нам надо его посетить
        if (i - 1 >= 0 && grid[i - 1][j] == '1' && !flags[i - 1][j]) {
            addIsland(grid, flags, i - 1, j);
        }
    }
}
