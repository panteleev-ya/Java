package Homework;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TestSolution {
    public static void main(String[] args) {
//        Scanner console = new Scanner(System.in);
//        int t = console.nextInt();
//        List<List<Long>> requests = new ArrayList<>();
//        for (int i = 0; i < t; i++) {
//            List<Long> request = new ArrayList<>();
//            request.add(console.nextLong());
//            request.add(console.nextLong());
//            requests.add(request);
//        }
        Random r = new Random();
        while (true) {
            int t = Math.abs(r.nextInt()) % 20 + 1;
            List<List<Long>> requests = new ArrayList<>();
            for (int i = 0; i < t; i++) {
                List<Long> request = new ArrayList<>();
//                request.add(Math.abs(r.nextLong()) % (long)(1e12) + 1);
//                request.add(Math.abs(r.nextLong()) % (long)(1e12) + 1);
                request.add(Math.abs(r.nextLong()) % (long)(1e2) + 1);
                request.add(Math.abs(r.nextLong()) % (long)(1e2) + 1);
                requests.add(request);
            }
            var fastSolution = solveFast(t, requests);
            var slowSolution = solveSlow(t, requests);
            if (!fastSolution.equals(slowSolution)) {
                System.out.println("===============================");
                System.out.println("Test case:");
                System.out.println("t = " + t);
                System.out.println("requests = " + requests);
                System.out.println("===============================");
                System.out.println("slowSolution = " + slowSolution);
                System.out.println("fastSolution = " + fastSolution);
                System.out.println("===============================");
                break;
            }
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

    private static List<Long> solveFast(int t, List<List<Long>> requests) {
        List<Long> result = new ArrayList<>();
        for (int request = 0; request < t; request++) {
//            long a = console.nextLong();
//            long b = console.nextLong();
            long a = requests.get(request).get(0);
            long b = requests.get(request).get(1);

            if (a == b) {
//                System.out.println(a);
                result.add(a);
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
//            System.out.println(answer * maxPrimeDifferentDivisor);
            result.add(answer * maxPrimeDifferentDivisor);
        }
        return result;
    }

    private static List<Long> solveSlow(int t, List<List<Long>> requests) {
        List<Long> result = new ArrayList<>();
        for (int request = 0; request < t; request++) {
//            long a = console.nextLong();
//            long b = console.nextLong();
            long a = requests.get(request).get(0);
            long b = requests.get(request).get(1);

            long maxPrimeDivisorDiff = 1;
            long divisor = 2;
            long answer = 1;
            while (a != 1 || b != 1) {
                long divisorCountA = 0;
                long divisorCountB = 0;
                while (a % divisor == 0) {
                    a /= divisor;
                    divisorCountA++;
                }
                while (b % divisor == 0) {
                    b /= divisor;
                    divisorCountB++;
                }
                if (divisorCountA == divisorCountB) {
                    answer *= Math.pow(divisor, divisorCountA);
                } else {
                    answer *= Math.pow(divisor, Math.min(divisorCountA, divisorCountB));
                    maxPrimeDivisorDiff = divisor;
                }
                divisor++;
            }

//            System.out.println(answer * maxPrimeDivisorDiff);
            result.add(answer * maxPrimeDivisorDiff);
        }
        return result;
    }
}
