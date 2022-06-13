package Bus;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        int number = Integer.parseInt(console.nextLine());
        number++;
        while (!isLuckyNumber(number)) {
            number++;
        }
        System.out.println(number);
    }

    private static boolean isLuckyNumber(int number) {
        char[] numberDigits = String.valueOf(number).toCharArray();
        return numberDigits[0] + numberDigits[1] + numberDigits[2] == numberDigits[3] + numberDigits[4] + numberDigits[5];
    }
}
