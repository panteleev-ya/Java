package AliceNotebook;

import java.util.Scanner;

public class Solution {
    private static void ask(String date) {
        System.out.printf("? %s\n", date);
        System.out.flush();
    }

    private static void print(String answer) {
        System.out.printf("! %s\n", answer);
        System.out.flush();
    }

    public static void main(String[] args) {
        // read game configuration
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        // write your code here
    }
}
