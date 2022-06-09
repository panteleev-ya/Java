package Rebusi;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int n = console.nextInt();
        int prev = 0;
        char[] alphabet = "abcdefghijklmnopqrstuvwxyz ".toCharArray();
        for (int i = 0; i < n; i++) {
            int next = console.nextInt();
            int index = (int)(Math.log(Math.abs(next - prev)) / Math.log(2));
            System.out.print(alphabet[index]);
            prev = next;
        }
    }
}
