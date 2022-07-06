package Day6;

public class Solution {
    public static void main(String[] args) {
        System.out.println(fib(2));
        System.out.println(fib(3));
        System.out.println(fib(4));
        System.out.println(fib(5));
        System.out.println(fib(6));
        System.out.println(fib(7));
    }

    public static int fib(int n) {
        if (n < 2) {
            return n;
        }

        int first = 0;
        int second = 1;
        int result = 1;
        for (int i = 2; i <= n; i++) {
            result = first + second;
            first = second;
            second = result;
        }

        return result;
    }
}
