package imageSmoother;

public class Solution {
    public int[][] imageSmoother(int[][] img) {
        for (int i = 0; i < img.length; i++) {
            for (int j = 0; j < img[i].length; j++) {
                // img[i][j] = p * X + r, where p = smoothed, X = 256, r = original
                img[i][j] += 256 * smooth(img, i, j);
            }
        }

        for (int i = 0; i < img.length; i++) {
            for (int j = 0; j < img[i].length; j++) {
                // extract `p`
                img[i][j] /= 256;
            }
        }

        return img;
    }

    private int smooth(int[][] img, int x, int y) {
        int neighbourCount = 0;
        int neighbourSum = 0;

        for (int dx = -1; dx <= 1; dx++) {
            for (int dy = -1; dy <= 1; dy++) {
                int nX = x + dx;
                int nY = y + dy;
                if (nX < 0 || nX >= img.length || nY < 0 || nY >= img[nX].length) {
                    continue;
                }
                neighbourCount++;
                neighbourSum += img[nX][nY] % 256; // extract `r`
            }
        }

        return neighbourSum / neighbourCount;
    }
}
