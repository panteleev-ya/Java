package DivideTwoIntegers;

public class Solution {
    public static void main(String[] args) {
        int dividend = -2147483648, divisor = -1;
        System.out.println(divide(dividend, divisor));
    }
    public static int divide(int dividend, int divisor) {
        int result = 0;
        boolean negative = (dividend < 0) ^ (divisor < 0);

        if (dividend > 0) {
            dividend = 0 - dividend;
        }
        if (divisor > 0) {
            divisor = 0 - divisor;
        }

        for (int place = 31; place >= 0; place--) {

            // guard against underflow
            if (Integer.MIN_VALUE >> place <= divisor){ // arithmetic shift in Java preserves the sign bit

                // With 2s complement numbers, left bitshifts on negative numbers multiply
                // them in the same way as they would positive numbers
                int term = divisor << place;
                if (term >= dividend) {
                    dividend -= term;

                    // If we were using positive numbers, then we could just do:
                    // result |= 1 << place
                    // But we're using negative numbers, so it's easier just to add the two negative numbers together
                    result += -1 << place;
                }
            }
        }

        // MAX_VALUE has a lower magnitude than MIN_VALUE, so we may need to trim the result
        // down for positive numbers
        if (!negative && 0 - Integer.MAX_VALUE > result) {
            result = 0 - Integer.MAX_VALUE;
        }

        // Finally, if the result is not supposed to be a negative number, flip it.
        if (!negative) {
            result = 0 - result;
        }

        return result;
    }
}
