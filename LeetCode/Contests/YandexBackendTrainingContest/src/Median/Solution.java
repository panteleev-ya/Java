package Median;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int n = Integer.parseInt(console.nextLine());
        char[] S = console.nextLine().toCharArray();
        int[] L = new int[n + 1];
        L[1] = -1;
        int counter = 0;
        if (S[0] == '0') {
            counter--;
        } else {
            counter++;
        }
        for (int r = 2; r <= n; r++) {
            L[r] = -1;

            if (S[r - 1] == '0') {
                counter--;
            } else {
                counter++;
            }
            if ((counter < 0 && S[r - 1] == '0') || (counter > 0 && S[r - 1] == '1')) {
                L[r] = 1;
                continue;
            }
            int bufferCounter = counter;
            for (int l = 1; l <= r - 2; l++) {
                if (S[l - 1] == '0') {
                    bufferCounter++;
                } else {
                    bufferCounter--;
                }
                if (bufferCounter == 0) {
                    continue;
                }
                if (bufferCounter < 0 && S[r - 1] == '0' || bufferCounter > 0 && S[r - 1] == '1') {
                    L[r] = l + 1;
                    break;
                }
            }
        }

        for (int i = 1; i < n + 1; i++) {
            System.out.print(L[i] + " ");
        }
    }
}
