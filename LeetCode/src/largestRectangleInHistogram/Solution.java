package largestRectangleInHistogram;

public class Solution {
    public int largestRectangleArea(int[] heights) {
        int[] stack = new int[heights.length + 1];
        int maxArea = 0;
        int topIndex = -1;
        for (int i = 0; i <= heights.length; i++) {
            int currHeight = (i == heights.length) ? 0 : heights[i];
            while (topIndex >= 0 && currHeight < heights[stack[topIndex]]) {
                int height = heights[stack[topIndex--]];
                int width = (topIndex < 0) ? i : i - stack[topIndex] - 1;
                maxArea = Math.max(maxArea, height * width);
            }
            stack[++topIndex] = i;
        }
        return maxArea;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().largestRectangleArea(new int[]{7, 1, 7, 2, 2, 4}));
    }
}
