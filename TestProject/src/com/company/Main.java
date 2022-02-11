package com.company;

import java.util.Scanner;

public class Main {
    public static int[] array;

    public static void main(String[] args) throws Exception {
        int n, min;
        Scanner console = new Scanner(System.in);
        n = console.nextInt();
        if (n > 0) {
            array = new int[n];
            for (int i = 0; i < n; i++) {
                array[i] = console.nextInt();
            }
            min = array[0];
            for (int i = 1; i < n; i++) {
                if (array[i] > min) {
                    min = array[i];
                }
            }
            System.out.println(min);
        }
    }
}
