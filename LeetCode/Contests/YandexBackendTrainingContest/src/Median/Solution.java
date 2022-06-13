package Median;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int n = Integer.parseInt(console.nextLine());
        char[] s = console.nextLine().toCharArray();

        int counter = 0;
        int subCounter, subL;
        System.out.print(-1 + " ");
        if (s[0] == '0') {
            counter--;
        } else {
            counter++;
        }
        for (int l = 0, r = 1; r <= n - 1; r++, l = subL) {
            if (s[r] == '0') {
                counter--;
                subCounter = counter;
                subL = l;
                while (subL + 1 < r && !(subCounter < 0)) {
                    if (s[subL] == '0') {
                        subCounter++;
                    } else {
                        subCounter--;
                    }
                    subL++;
                }

                if (subCounter < 0) {
                    System.out.print((subL + 1) + " ");
                } else {
                    subL = l;
                    while (subL > 0 && !(subCounter < 0)) {
                        if (s[subL] == '0') {
                            subCounter++;
                        } else {
                            subCounter--;
                        }
                        subL--;
                    }
                    if (subCounter < 0) {
                        System.out.print((subL + 1) + " ");
                    } else {
                        System.out.print(-1 + " ");
                    }
                }
            } else {
                counter++;
                subCounter = counter;
                subL = l;
                while (subL + 1 < r && !(subCounter > 0)) {
                    if (s[subL] == '0') {
                        subCounter++;
                    } else {
                        subCounter--;
                    }
                    subL++;
                }

                if (subCounter > 0) {
                    System.out.print((subL + 1) + " ");
                } else {
                    subL = l;
                    while (subL > 0 && !(subCounter > 0)) {
                        if (s[subL] == '0') {
                            subCounter++;
                        } else {
                            subCounter--;
                        }
                        subL--;
                    }
                    if (subCounter > 0) {
                        System.out.print((subL + 1) + " ");
                    } else {
                        System.out.print(-1 + " ");
                    }
                }
            }
        }
    }
}
