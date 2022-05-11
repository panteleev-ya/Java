package ValidSudoku;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        char[][] board = {
                {'.', '.', '4', '.', '.', '.', '6', '3', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'5', '.', '.', '.', '.', '.', '.', '9', '.'},
                {'.', '.', '.', '5', '6', '.', '.', '.', '.'},
                {'4', '.', '3', '.', '.', '.', '.', '.', '1'},
                {'.', '.', '.', '7', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '5', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '.'}
        };
        System.out.println(isValidSudoku(board));
    }

    public static boolean isValidSudoku(char[][] board) {
        return checkColumns(board) && checkRows(board) && checkSubSquares(board);
    }

    private static boolean checkRows(char[][] board) {
        Set<Character> digits = new HashSet<>();
        for (char[] row : board) {
            for (char digit : row) {
                boolean contains = addIfDoestContain(digits, digit);
                if (contains) {
                    return false;
                }
            }
            digits.clear();
        }
        return true;
    }

    private static boolean checkColumns(char[][] board) {
        Set<Character> digits = new HashSet<>();
        for (int j = 0; j < board[0].length; j++) {
            for (char[] chars : board) {
                char digit = chars[j];
                boolean contains = addIfDoestContain(digits, digit);
                if (contains) {
                    return false;
                }
            }
            digits.clear();
        }
        return true;
    }

    private static boolean checkSubSquares(char[][] board) {
        Set<Character> digits = new HashSet<>();
        for (int square = 0; square < 9; square++) {
            int startX = (square % 3) * 3;
            int startY = (square / 3) * 3;
            for (int x = startX; x < startX + 3; x++) {
                for (int y = startY; y < startY + 3; y++) {
                    char digit = board[x][y];
                    boolean contains = addIfDoestContain(digits, digit);
                    if (contains) {
                        return false;
                    }
                }
            }
            digits.clear();
        }
        return true;
    }

    private static boolean addIfDoestContain(Set<Character> digits, char digit) {
        // Skip empty cell
        if (digit == '.') {
            return false;
        }
        // Cell contains duplicate digit
        if (digits.contains(digit)) {
            return true;
        }
        digits.add(digit);
        return false;
    }
}
