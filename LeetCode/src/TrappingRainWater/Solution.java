package TrappingRainWater;

public class Solution {
    public static void main(String[] args) {
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(trap(height));
    }
    public static int trap(int[] height) {
        // TC = O(n^2), MC = O(1)
        if (height.length < 3) {
            return 0;
        }

        // Ищем индекс центрального максимума в массиве
        int maxIndex = 0;
        for (int i = 1; i < height.length; i++) {
            if (height[i] > height[maxIndex]) {
                maxIndex = i;
            }
        }
        int sum = 0;

        // Ищем максимумы слева и справа от центрального максимума
        int prevLeftMaxIndex = maxIndex;
        int prevRightMaxIndex = maxIndex;
        int maxLeftIndex, maxRightIndex;
        while (prevLeftMaxIndex >= 0 || prevRightMaxIndex < height.length) {
            maxLeftIndex = prevLeftMaxIndex - 1;
            maxRightIndex = prevRightMaxIndex + 1;
            for (int i = prevLeftMaxIndex - 2; i >= 0; i--) {
                if (height[i] > height[maxLeftIndex]) {
                    maxLeftIndex = i;
                }
            }

            for (int i = maxLeftIndex + 1; i < prevLeftMaxIndex; i++) {
                sum += height[maxLeftIndex] - height[i];
            }


            for (int i = prevRightMaxIndex + 2; i < height.length; i++) {
                if (height[i] > height[maxRightIndex]) {
                    maxRightIndex = i;
                }
            }

            for (int i = prevRightMaxIndex + 1; i < maxRightIndex; i++) {
                sum += height[maxRightIndex] - height[i];
            }

            prevLeftMaxIndex = maxLeftIndex;
            prevRightMaxIndex = maxRightIndex;
        }

        return sum;
    }
}
