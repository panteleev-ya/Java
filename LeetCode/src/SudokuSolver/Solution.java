package SudokuSolver;

public class Solution {
    public static void solveSudoku(char[][] board) {
        // we are trying to solve the board
        if (!solve(board))
            System.out.println("Cannot be solved");
    }

    public static boolean solve(char[][] board) {
        // traversing each cell in board
        for (int row = 0; row < 9; row++) {
            for (int column = 0; column < 9; column++) {
                // if cell is empty
                if (board[row][column] == '.') {
                    // we are gonna try every character for that cell
                    for (char digit = '1'; digit <= '9'; digit++) {
                        // if character is valid in that cell
                        if (isValid(board, digit, row, column)) {
                            board[row][column] = digit; // put it

                            // try solving the board with updation of this cell
                            if (solve(board)) {
                                return true;
                            } else {
                                board[row][column] = '.'; // if cannot solve remove the value placed
                            }
                        }
                    }

                    // if cannot solve the whole board
                    return false;
                }
            }
        }

        // if whole board is solved
        return true;
    }

    private static boolean isValid(char[][] grid, char digit, int row, int column) {
        for (int i = 0; i < 9; i++) {
            if (grid[i][column] == digit) {
                return false;
            }

            if (grid[row][i] == digit) {
                return false;
            }

            if (grid[3 * (row / 3) + i / 3][3 * (column / 3) + i % 3] == digit) {
                return false;
            }
        }

        return true;
    }
}
