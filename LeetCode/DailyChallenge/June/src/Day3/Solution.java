package Day3;

public class Solution {
    public static void main(String[] args) {
        int[][] matrix = {
                {3, 0, 1, 4, 2},
                {5, 6, 3, 2, 1},
                {1, 2, 0, 1, 5},
                {4, 1, 0, 1, 7},
                {1, 0, 3, 0, 5}
        };
        NumMatrix numMatrix = new NumMatrix(matrix);
        numMatrix.sumRegion(2, 1, 4, 3); // return 8 (i.e sum of the red rectangle)
        numMatrix.sumRegion(1, 1, 2, 2); // return 11 (i.e sum of the green rectangle)
        numMatrix.sumRegion(1, 2, 2, 4); // return 12 (i.e sum of the blue rectangle)
    }
}
