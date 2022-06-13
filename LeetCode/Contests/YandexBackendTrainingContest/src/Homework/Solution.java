package Homework;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int t = console.nextInt();
        for (int request = 0; request < t; request++) {
            long a = console.nextLong();
            long b = console.nextLong();

            if (a == b) {
                System.out.println(a);
                continue;
            }

            long maxNum = Math.max(a, b);

            long answer = 1;
            long maxPrimeDifferentDivisor = 1;

            while (a % 2 == 0 && b % 2 == 0) {
                a >>= 1;
                b >>= 1;
                answer <<= 1;
            }

            if (a % 2 == 0 || b % 2 == 0) {
                maxPrimeDifferentDivisor = 2;
                while (a % 2 == 0) {
                    a >>= 1;
                }
                while (b % 2 == 0) {
                    b >>= 1;
                }
            }

            for (long divisor = 3; (a != 1 || b != 1) && divisor * divisor <= maxNum; divisor += 2) {
                while (a % divisor == 0 && b % divisor == 0) {
                    a /= divisor;
                    b /= divisor;
                    answer *= divisor;
                }
                if (a % divisor == 0 || b % divisor == 0) {
                    maxPrimeDifferentDivisor = divisor;
                    while (a % divisor == 0) {
                        a /= divisor;
                    }
                    while (b % divisor == 0) {
                        b /= divisor;
                    }
                }
            }

            if (a == b) {
                answer *= a;
            }

            if (getNOK(a, b) == 1) {
                maxPrimeDifferentDivisor = Math.max(maxPrimeDifferentDivisor, Math.max(a, b));
            }
            System.out.println(answer * maxPrimeDifferentDivisor);
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
}

//1
//26 78