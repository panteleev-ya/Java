package Median;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int n = Integer.parseInt(console.nextLine());
        char[] s = console.nextLine().toCharArray();

        int counter = 0;
        int subCounter;
        System.out.print(-1 + " ");
        if (s[0] == '0') {
            counter--;
        } else {
            counter++;
        }
        for (int l = 0, r = 1; r <= n - 1; r++, l = 0) {
            if (s[r] == '0') {
                counter--;
                subCounter = counter;
                while (l + 1 < r && !(subCounter < 0)) {
                    if (s[l] == '0') {
                        subCounter++;
                    } else {
                        subCounter--;
                    }
                    l++;
                }

                if (subCounter < 0) {
                    System.out.print((l + 1) + " ");
                } else {
                    System.out.print(-1 + " ");
                }
            } else {
                counter++;
                subCounter = counter;
                while (l + 1 < r && !(subCounter > 0)) {
                    if (s[l] == '0') {
                        subCounter++;
                    } else {
                        subCounter--;
                    }
                    l++;
                }

                if (subCounter > 0) {
                    System.out.print((l + 1) + " ");
                } else {
                    System.out.print(-1 + " ");
                }
            }
        }
    }
}
