package LongestPalindromicSubstring;

import java.util.ArrayDeque;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        String s = "aacabdkacaa";
        System.out.println(longestPalindrome(s));
    }
    public static String longestPalindrome(String s) {
        String palindrome = "";
        String tmp;
        for (int i = 0; i < s.length(); i++) {
            for (int j = s.length() - 1; j >= i; j--) {
                if (j - i + 1 < palindrome.length()) {
                    // Нет смысла проверять палиндром ли "bab", если мы уже нашли палиндром "cbabc"
                    continue;
                }
                if (s.charAt(i) == s.charAt(j)) {
                    tmp = isPalindrome(s, i, j);
                    if (tmp != null && tmp.length() > palindrome.length()) {
                        palindrome = tmp;
                    }
                }
            }
        }
        return palindrome;
    }

    // Проверяет, является ли подстрока s[start, end] палиндромом
    // Если да, то возвращает эту подстроку, иначе возвращает null
    private static String isPalindrome(String s, int start, int end) {

        // Выбираем центральный символ
        int mid = (end - start + 1) / 2;

        // Проверяем соответствие всех символов [0, mid] символам [end, mid]
        for (int i = start, j = end; i <= start + mid && j >= end - mid; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return null;
            }
        }

        // Возвращаем подстроку-палиндром
        var chars = s.toCharArray();
        return new String(Arrays.copyOfRange(chars, start, end + 1));
    }
}
