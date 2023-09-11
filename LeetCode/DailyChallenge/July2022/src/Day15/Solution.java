package Day15;

public class Solution {
    public static void main(String[] args) {
//        System.out.println(new Solution().maxAreaOfIsland(new int[][]{{0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0}, {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0}, {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}}));
//        System.out.println(new Solution().maxAreaOfIsland(new int[][]{{0, 0, 0, 0, 0, 0, 0, 0}}));
//        System.out.println(new Solution().maxAreaOfIsland(new int[][]{{1, 0, 0}, {0, 1, 1}}));
        System.out.println(new Solution().maxAreaOfIsland(new int[][]{
                {0, 0, 0, 0, 1, 1, 1, 0, 0, 1, 1, 0, 1, 0, 1, 1, 1, 0, 0, 1, 0, 0, 1, 0, 1, 0, 0, 0, 1, 1, 0, 0, 0, 1, 0, 1, 1, 1, 1},
                {0, 0, 0, 0, 0, 1, 1, 0, 1, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 1, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 1, 1, 0},
                {0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 0, 1, 1, 1, 0, 1, 0, 1, 0, 1, 1, 1, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 1},
                {0, 1, 0, 0, 1, 1, 0, 1, 0, 1, 1, 0, 1, 0, 1, 0, 0, 1, 0, 0, 0, 0, 1, 1, 0, 1, 0, 0, 1, 1, 0, 1, 1, 0, 0, 1, 0, 1, 1},
                {1, 0, 0, 1, 1, 0, 1, 0, 0, 0, 0, 1, 1, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0, 0, 1, 1, 0, 0, 0, 1, 0, 0, 1, 0, 1, 1, 0, 0, 1}
        }));
    }

    private static final int[][] steps;

    static {
        steps = new int[][]{{0, -1}, {-1, 0}, {0, 1}, {1, 0}};
    }

    private int currentArea;
    private int maxAreaFound;
    private int[][] grid;


    public int maxAreaOfIsland(int[][] grid) {
        maxAreaFound = 0;
        this.grid = grid;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] != -1) {
                    findLand(i, j);
                }
            }
        }

        return maxAreaFound;
    }

    private void findLand(int i, int j) {
        if (grid[i][j] == 1) {
            currentArea = 0;
            scanLand(i, j);

        }

        grid[i][j] = -1;
        for (int[] step : steps) {
            int i1 = i + step[0];
            int j1 = j + step[1];

            if (isNotWorthChecking(i1, j1)) {
                continue;
            }

            findLand(i1, j1);
        }
    }

    private void scanLand(int i, int j) {
        grid[i][j] = -1;
        currentArea++;
        for (int[] step : steps) {
            int i1 = i + step[0];
            int j1 = j + step[1];

            if (isNotWorthChecking(i1, j1) || grid[i1][j1] == 0) {
                continue;
            }

            scanLand(i1, j1);
        }

        if (currentArea > maxAreaFound) {
            maxAreaFound = currentArea;
        }
    }

    private boolean isNotWorthChecking(int x, int y) {
        return !(0 <= x && x < grid.length && 0 <= y && y < grid[x].length && grid[x][y] != -1);
    }
}
