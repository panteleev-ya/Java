package Sqares;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int n = Integer.parseInt(console.nextLine());
        Square[] squares = new Square[n];
        for (int i = 0; i < n; i++) {
            squares[i] = new Square(console.nextLine());
        }

        int[] counters = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (squares[i].intersect(squares[j])) {
                    counters[i]++;
                    counters[j]++;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            System.out.print(counters[i] + " ");
        }
    }

    private static class Square {
        public int xL;
        public int yL;
        public int xR;
        public int yR;

        public Square(String coordinates) {
            String[] arr = coordinates.split(" ");
            this.xL = Integer.parseInt(arr[0]);
            this.yL = Integer.parseInt(arr[1]);
            this.xR = Integer.parseInt(arr[2]);
            this.yR = Integer.parseInt(arr[3]);
        }
        public Square(int xL, int yL, int xR, int yR) {
            this.xL = xL;
            this.yL = yL;
            this.xR = xR;
            this.yR = yR;
        }

        public boolean intersect(Square s) {
            boolean aLeftOfB = xR <= s.xL;
            boolean aRightOfB = xL >= s.xR;
            boolean aAboveB = yL >= s.yR;
            boolean aBelowB = yR <= s.yL;

            return !(aLeftOfB || aRightOfB || aAboveB || aBelowB);
        }
    }
}

//2
//-2 -4 0 -1
//-2 -1 0 2
