package Hexagons;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        String[] nm = console.nextLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);
        char[][] field = new char[n][m];
        boolean[] hasSlashes = new boolean[m];
        for (int i = 0; i < n; i++) {
            char[] line = console.nextLine().toCharArray();
            for (int j = 0; j < m; j++) {
                char c = line[j];
                if (c == '\\' || c == '/') {
                    hasSlashes[j] = true;
                }
                field[n - 1 - i][m - 1 - j] = c;
            }
        }

        char tmp;
        for (int j = 0; j < m; j++) {
            if (!hasSlashes[j]) {
                continue;
            }
            for (int i = n - 1; i >= 1; i--) {
                tmp = field[i][j];
                field[i][j] = field[i - 1][j];
                field[i - 1][j] = tmp;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(field[i][j]);
            }
            System.out.println();
        }
    }
}
