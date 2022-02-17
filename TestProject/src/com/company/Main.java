package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
//        // Создание строк
//        String str1 = "";  // String str1 = new String();
//        String str2 = "Hello";  // String str1 = new String(new char[] {'H', 'e', 'l', 'l', 'o'});
//
//        // Полезные методы строк
//        str1.length();  // возвращает длинну строки
//        str1.isEmpty();  // true - пустая строка, либо null
//        str1.isBlank();  // true - строка состоит только из пробелов (whitespaces)
//        str1.toCharArray();  // создает массив из символов строк
//
//        // Сравнение строк
//        str1.equals(str2);  // сравнение строк
//        str1.equalsIgnoreCase(str2);  // сравнение строк без учета регистра

    public static int[][] result = new int[2][];
    public static int[] array = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};

    public static void main(String[] args) {
        int mid = (array.length + 1) / 2;
        result[0] = Arrays.copyOfRange(array, 0, mid);
        result[1] = Arrays.copyOfRange(array, mid, array.length);
        System.out.println(Arrays.deepToString(result));
    }
}
