package Sqares;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(console.readLine());
        int[][] squares = new int[n][4];
        int[] counters = new int[n];
        for (int i = 0; i < n; i++) {
            String[] line = console.readLine().split(" ");
            for (int coord = 0; coord < 4; coord++) {
                squares[i][coord] = Integer.parseInt(line[coord]);
            }
            for (int j = i - 1; j >= 0; j--) {
                if (!(squares[i][2] <= squares[j][0] || squares[i][0] >= squares[j][2] || squares[i][1] >= squares[j][3] || squares[i][3] <= squares[j][1])) {
                    counters[i]++;
                    counters[j]++;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.print(counters[i] + " ");
        }
    }
}
