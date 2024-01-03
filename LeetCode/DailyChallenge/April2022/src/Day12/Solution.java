package Day12;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int[][] board = {
                {0, 1, 0},
                {0, 0, 1},
                {1, 1, 1},
                {0, 0, 0}};
        gameOfLife(board);
        System.out.println(Arrays.deepToString(board));
    }

    public static void gameOfLife(int[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return;
        }
        // Rules
        // 1) Any live cell with (x < 2) live neighbors dies as if caused by under-population.
        // 2) Any live cell with (x == 2 || x == 3) live neighbors lives on to the next generation.
        // 3) Any live cell with (x > 3) live neighbors dies, as if by over-population.
        // 4) Any dead cell with (x == 3) live neighbors becomes a live cell, as if by reproduction.

        // Board
        // [i-1][j-1] [i-1][ j ] [i-1][j+1]
        // [ i ][j-1]    i, j    [ i ][j+1]
        // [i+1][j-1] [i+1][ j ] [i+1][j+1]
        int n = board.length;
        int m = board[0].length;
        int[][] nextGen = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // Считаем количество живых соседей
                int aliveNeighbors = 0;
                if (i - 1 >= 0) {
                    if (j - 1 >= 0) {
                        aliveNeighbors += board[i - 1][j - 1];
                    }
                    aliveNeighbors += board[i - 1][j];
                    if (j + 1 < m) {
                        aliveNeighbors += board[i - 1][j + 1];
                    }
                }
                if (j - 1 >= 0) {
                    aliveNeighbors += board[i][j - 1];
                }
                if (j + 1 < m) {
                    aliveNeighbors += board[i][j + 1];
                }
                if (i + 1 < n) {
                    if (j - 1 >= 0) {
                        aliveNeighbors += board[i + 1][j - 1];
                    }
                    aliveNeighbors += board[i + 1][j];
                    if (j + 1 < m) {
                        aliveNeighbors += board[i + 1][j + 1];
                    }
                }

                // Проверяем его самого на "живость" и
                // устанавливаем ему "живость" в следующем поколении
                // в соответствии с правилами
                boolean isAlive = (board[i][j] > 0);
                if (!isAlive) {
                    if (aliveNeighbors == 3) {
                        nextGen[i][j] = 1;
                    } else {
                        nextGen[i][j] = 0;
                    }
                } else {
                    if (aliveNeighbors < 2) {
                        nextGen[i][j] = 0;
                    } else if (aliveNeighbors == 2 || aliveNeighbors == 3) {
                        nextGen[i][j] = 1;
                    } else {
                        nextGen[i][j] = 0;
                    }
                }
            }
        }
        for (int i = 0; i < n; i++) {
            System.arraycopy(nextGen[i], 0, board[i], 0, m);
        }
    }
}
