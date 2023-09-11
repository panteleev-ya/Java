package Day2;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        System.out.println(maxArea(5, 4, new int[]{1, 2, 4}, new int[]{1, 3}));
        System.out.println(maxArea(5, 4, new int[]{3, 1}, new int[]{1}));
        System.out.println(maxArea(5, 4, new int[]{3}, new int[]{3}));
        System.out.println(maxArea(1000000000, 1000000000, new int[]{2}, new int[]{2}));
    }

    public static int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        int prevEdge = 0;
        int pieceH = 0;
        for (int cut : horizontalCuts) {
            pieceH = Math.max(pieceH, cut - prevEdge);
            prevEdge = cut;
        }
        pieceH = Math.max(pieceH, h - prevEdge);

        prevEdge = 0;
        int pieceW = 0;
        for (int cut : verticalCuts) {
            pieceW = Math.max(pieceW, cut - prevEdge);
            prevEdge = cut;
        }
        pieceW = Math.max(pieceW, w - prevEdge);

        long area = (long) pieceH * (long) pieceW;

        return (int) ((area % (1_000_000_000 + 7)));
    }
}
