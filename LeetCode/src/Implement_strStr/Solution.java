package Implement_strStr;

public class Solution {
    public static void main(String[] args) {
        String haystack = "aabaaabaaac";
        String needle = "aabaaac";
        System.out.println(strStr(haystack, needle));
    }
    public static int strStr(String haystack, String needle) {
        if (needle == null || needle.equals("")) {
            return 0;
        }

        // Преобразуем в массивы
        var haystackArray = haystack.toCharArray();
        var needleArray = needle.toCharArray();

        // "Подстрока" больше строки - не может быть
        if (needleArray.length > haystackArray.length) {
            return -1;
        }

        // Длина "подстроки" и строки совпадают, проверяем посимвольно
        if (needleArray.length == haystackArray.length) {
            for (int i = 0; i < needleArray.length; i++) {
                if (haystackArray[i] != needleArray[i]) {
                    return -1;
                }
            }
            return 0;
        }

        // Все-таки "подстрока" короче строки, ищем ее предполагаемое начало и проверяем посимвольно
        int needleStart = 0;
        boolean isSubstrEqualsNeedle;

        // Пока мы еще можем попробовать найти начало подстроки - пробуем
        while (needleStart <= haystackArray.length - needleArray.length) {
            if (haystackArray[needleStart] == needleArray[0]) {
                // Предполагаем, что мы нашли needle
                isSubstrEqualsNeedle = true;
                // Посимвольно сравниваем подстроку haystack с needle
                // в диапазоне [needleStart; needleStart + needle.length]
                for (int i = 0; i < needleArray.length; i++) {
                    if (haystackArray[needleStart + i] != needleArray[i]) {
                        // Если найден несовпадающий символ - эта подстрока не needle,
                        // но еще не значит, что нет такой подстроки, которая совпала бы с needle.
                        isSubstrEqualsNeedle = false;
                        // => завершаем цикл for и продолжаем искать
                        break;
                    }
                }
                // Цикл не завершился раньше положенного => мы и правда нашли needle
                if (isSubstrEqualsNeedle) {
                    return needleStart;
                }
            }
            needleStart++;
        }

        // Все же while не завершился досрочно => мы не нашли needle в haystack
        return -1;
    }
}
