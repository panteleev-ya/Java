package Day16;

public class Solution {
    public static void main(String[] args) {
        int[][] heights = {{1, 2, 2}, {3, 8, 2}, {5, 3, 5}};
        System.out.println(new Solution().minimumEffortPath(heights));
    }

    public int minimumEffortPath(int[][] heights) {
        int low = -1;
        int high = findOneSolution(heights);
        while (low + 1 < high) {
            int mid = (low + high) / 2;
            if (isPossible(heights, mid, 0, 0, new boolean[heights.length][heights[0].length])) {
                high = mid;
            } else {
                low = mid;
            }
        }
        return high;
    }

    private int findOneSolution(int[][] heights) {
        int answer = 0;
        int last = heights[0][0];
        for (int col = 0; col < heights[0].length; col++) {
            answer = Math.max(answer, Math.abs(heights[0][col] - last));
            last = heights[0][col];
        }
        for (int row = 1; row < heights.length; row++) {
            answer = Math.max(answer, Math.abs(last - heights[row][heights[0].length - 1]));
            last = heights[row][heights[0].length - 1];
        }
        return answer;
    }

    private boolean isPossible(int[][] heights, int effort, int row, int col, boolean[][] visited) {
        if (visited[row][col]) {
            return false;
        }
        int n = heights.length;
        int m = heights[0].length;
        if (row == n - 1 && col == m - 1) {
            return true;
        }
        visited[row][col] = true;
        boolean result = false;
        if (row + 1 < n && Math.abs(heights[row][col] - heights[row + 1][col]) <= effort) {
            result = isPossible(heights, effort, row + 1, col, visited);
        }
        if (!result && col + 1 < m && Math.abs(heights[row][col] - heights[row][col + 1]) <= effort) {
            result = isPossible(heights, effort, row, col + 1, visited);
        }
        if (!result && row - 1 >= 0 && Math.abs(heights[row][col] - heights[row - 1][col]) <= effort) {
            result = isPossible(heights, effort, row - 1, col, visited);
        }
        if (!result && col - 1 >= 0 && Math.abs(heights[row][col] - heights[row][col - 1]) <= effort) {
            result = isPossible(heights, effort, row, col - 1, visited);
        }
        return result;
    }
}
