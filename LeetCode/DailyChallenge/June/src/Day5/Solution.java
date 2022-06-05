package Day5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static void main(String[] args) {

    }

    int queensSolutionsCount;

    // The idea is to separate queens by rows
    // Each of N queen has its own row, so they avoid row-conflicts
    // That means everytime we place a queen - we only try to place it on the next row from the last queen
    public int totalNQueens(int n) {
        queensSolutionsCount = 0;
        char[][] board = new char[n][n];
        for (char[] array : board) {
            Arrays.fill(array, '.');
        }
        dfs(0, n, board);
        return queensSolutionsCount;
    }

    void dfs(int row, int n, char[][] board) {
        // All queens added already -> save solution to the list
        if (row == n) {
            queensSolutionsCount++;
            return;
        }

        // Looking for every valid placement for queen in the i-th row (0 <= i < n)
        for (int col = 0; col < n; col++) {
            if (isValid(row, col, n, board)) {
                // Using backtracking: after we check the case - we roll everything back
                board[row][col] = 'Q';
                dfs(row + 1, n, board);
                board[row][col] = '.';
            }
        }
    }

    boolean isValid(int row, int col, int n, char[][] matrix) {
        // Checking column conflict
        for (int i = 0; i < row; i++) {
            if (matrix[i][col] == 'Q') {
                return false;
            }
        }

        // Checking main diagonal conflict
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (matrix[i][j] == 'Q') {
                return false;
            }
        }

        // Checking sub diagonal conflict
        for (int i = row, j = col; i >= 0 && j < n; i--, j++) {
            if (matrix[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }
}
