package PermutationInString;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        String s1 = "abcdef";
        String s2 = "xyfecdab";
        System.out.println(checkInclusion(s1, s2));
    }
    public static boolean checkInclusion(String s1, String s2) {
        int index = 0;
        int maxIndex = s2.length() - s1.length() + 1;

        // Получаем символы s1 отсортированными
        var s1Chars = s1.toCharArray();
        Arrays.sort(s1Chars);

        // Проверяем соответствие подстроки s2 и строки s1 и находим количество различающихся символов
        // На это количество сдвигаем указатель на начало (увеличиваем индекс)
        while (index < maxIndex) {

            // Получаем символы подстроки s2 отсортированными
            char[] s2Chars = new char[s1.length()];
            for (int i = 0; i < s1.length(); i++) {
                s2Chars[i] = s2.charAt(index + i);
            }
            Arrays.sort(s2Chars);

            // Сравниваем их и находим количественную разницу
            int s1Indent = 0;
            int s2Indent = 0;
            for (int i = 0; i + s1Indent < s1.length() && i + s2Indent < s1.length(); i++) {
                if (s1Chars[i + s1Indent] < s2Chars[i + s2Indent]) {
                    s1Indent++;
                } else if (s1Chars[i + s1Indent] > s2Chars[i + s2Indent]){
                    s2Indent++;
                }
            }

            // Подстрока равна строке
            if (s1Indent == 0 && s2Indent == 0) {
                return true;
            }
            index += Math.max(s1Indent, s2Indent);
        }
        return false;
    }
}
