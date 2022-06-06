package Gradient;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int columnsCount = console.nextInt();
        int rowsCount = console.nextInt();

        // Getting matrix Y
        long[] Y = new long[columnsCount];
        for (int column_min = 0; column_min < columnsCount; column_min++) {
            for (int column_max = column_min; column_max < columnsCount; column_max++) {
                for (int column = column_min; column <= column_max; column++) {
                    Y[column]++;
                }
            }
        }

        // Getting matrix X
        long[] X = new long[rowsCount];
        for (int row_min = 0; row_min < rowsCount; row_min++) {
            for (int row_max = row_min; row_max < rowsCount; row_max++) {
                for (int row = row_min; row <= row_max; row++) {
                    X[row]++;
                }
            }
        }

        // Result screen matrix XY = X * Y, where X and Y are matrix
        // But we only want to know sum of each row and each column
        // (notice that matrix is symmetric by rows and columns)
        // So we count summaries from 0 to H/2 and from 0 to W/2 and then copy it to another half

        // Count row summaries
        long[] rowsSummaries = new long[rowsCount];
        int iMiddle = (X.length % 2 == 1) ? (X.length / 2 + 1) : (X.length / 2);
        for (int i = 0; i < iMiddle; i++) {
            for (int j = 0; j < Y.length / 2; j++) {
                rowsSummaries[i] += X[i] * Y[j];
            }
            rowsSummaries[i] *= 2;
            if (Y.length % 2 == 1) {
                rowsSummaries[i] += X[i] * Y[Y.length / 2];
            }
            rowsSummaries[X.length - 1 - i] = rowsSummaries[i];
        }

        // Count column summaries
        long[] columnsSummaries = new long[columnsCount];
        int jMiddle = (Y.length % 2 == 1) ? (Y.length / 2 + 1) : (Y.length / 2);
        for (int j = 0; j < jMiddle; j++) {
            for (int i = 0; i < X.length / 2; i++) {
                columnsSummaries[j] += Y[j] * X[i];
            }
            columnsSummaries[j] *= 2;
            if (X.length % 2 == 1) {
                columnsSummaries[j] += Y[j] * X[X.length / 2];
            }
            columnsSummaries[Y.length - 1 - j] = columnsSummaries[j];
        }

        for (long sum: rowsSummaries) {
            System.out.print(sum + " ");
        }
        System.out.println();
        for (long sum: columnsSummaries) {
            System.out.print(sum + " ");
        }
    }
}
