package Homework;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int t = console.nextInt();
        for (int request = 0; request < t; request++) {
            long a = console.nextLong();
            long b = console.nextLong();

//            long maxPrimeDivisorDiff = 1;
//            long divisor = 2;
//            long answer = 1;
//            while (a != 1 || b != 1) {
//                long divisorCountA = 0;
//                long divisorCountB = 0;
//                while (a % divisor == 0) {
//                    a /= divisor;
//                    divisorCountA++;
//                }
//                while (b % divisor == 0) {
//                    b /= divisor;
//                    divisorCountB++;
//                }
//                if (divisorCountA == divisorCountB) {
//                    answer *= Math.pow(divisor, divisorCountA);
//                } else {
//                    answer *= Math.pow(divisor, Math.min(divisorCountA, divisorCountB));
//                    maxPrimeDivisorDiff = divisor;
//                }
//                divisor++;
//            }
//
//            System.out.println(answer * maxPrimeDivisorDiff);

//            long maxPrimeDivisorDiff = 1;
//
//            if (a % 2 == 0 && b % 2 == 0) {
//                a /= 2;
//                b /= 2;
//            }
//
//            long minNum = Math.min(a, b);
//            for (long divisor = 3; divisor * divisor < minNum; divisor++) {
//                while (a % divisor == 0 && b % divisor == 0) {
//                    a /= divisor;
//                    b /= divisor;
//                }
//
//                if (a % divisor == 0 || b % divisor == 0) {
//                    maxPrimeDivisorDiff = divisor;
//                }
//            }

            System.out.println(getNOK(a, b) * maxDifferentPrimeDivider(a, b));
        }
    }

    private static long getNOK(long a, long b) {
        while (a != 0 && b != 0) {
            if (a > b) {
                a = a % b;
            } else {
                b = b % a;
            }
        }
        return a + b;
    }

    private static long maxDifferentPrimeDivider(long a, long b) {
        long answer = 1;

        while (a % 2 == 0 && b % 2 == 0) {
            a /= 2;
            b /= 2;
        }

        if (a % 2 == 0 || b % 2 == 0) {
            answer = 2;
            while (a % 2 == 0) {
                a /= 2;
            }
            while (b % 2 == 0) {
                b /= 2;
            }
        }


        for (long q = 3; q * q < a; q += 2) {
            while (a % q == 0 && b % q == 0) {
                a /= q;
                b /= q;
            }
            if (a % q == 0 || b % q == 0) {
                answer = q;
                while (a % q == 0) {
                    a /= q;
                }
                while (b % q == 0) {
                    b /= q;
                }
            }
        }

        long resultAB = Math.max(a, b);
        if (getNOK(a, b) != 1) {
            resultAB = Math.min(a, b);
        }
        return Math.max(resultAB, answer);
    }
}

//20
//1 1000000000000
//1 1000000000000
//1 1000000000000
//1 1000000000000
//1 1000000000000
//1 1000000000000
//1 1000000000000
//1 1000000000000
//1 1000000000000
//1 1000000000000
//1 1000000000000
//1 1000000000000
//1 1000000000000
//1 1000000000000
//1 1000000000000
//1 1000000000000
//1 1000000000000
//1 1000000000000
//1 1000000000000
//1 1000000000000
