package Task1;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        RectangleOffice o1 = new RectangleOffice(scanner.nextInt(),
                scanner.nextInt(),
                scanner.nextInt(),
                scanner.nextInt());

        RectangleOffice o2 = new RectangleOffice(scanner.nextInt(),
                scanner.nextInt(),
                scanner.nextInt(),
                scanner.nextInt());

        int sizeX = Math.max(o1.getMaxX(), o2.getMaxX()) - Math.min(o1.getMinX(), o2.getMinX());
        int sizeY = Math.max(o1.getMaxY(), o2.getMaxY()) - Math.min(o1.getMinY(), o2.getMinY());

        int squareEdge = Math.max(sizeX, sizeY);
        System.out.println(squareEdge * squareEdge);
    }

    private static class RectangleOffice {
        int x1, x2, y1, y2;
        public RectangleOffice(int x1, int y1, int x2, int y2) {
            this.x1 = x1;
            this.x2 = x2;
            this.y1 = y1;
            this.y2 = y2;
        }

        public int getMaxX() {
            return Math.max(x1, x2);
        }

        public int getMinX() {
            return Math.min(x1, x2);
        }

        public int getMaxY() {
            return Math.max(y1, y2);
        }

        public int getMinY() {
            return Math.min(y1, y2);
        }
    }
}
