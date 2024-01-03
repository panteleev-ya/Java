package Day2;

public class Solution {
    public static void main(String[] args) {
        String s1 = "aba";        // true
        String s2 = "abca";       // true
        String s3 = "abcda";      // false
        String s4 = "abcXdedcba"; // true
        String s5 = "abcXeXdcba"; // true
        String s6 = "cuppucu";    // true
        String[] strings = {s1, s2, s3, s4, s5, s6};
        for (String s: strings) {
            System.out.println(validPalindrome(s));
        }
    }
    public static boolean validPalindrome(String s) {
        // Легко расширяется до рекурсивной реализации при возможности пропуска больше чем 1 символа
        // Таким образом: нашли несоответствие и счетчик несоответствий еще не заполнился - вызываем саму себя с current позиции с новым счетчиком
        // И так пока либо счетчик не переполнится (false), либо строчка схлопнется ((start >= end) => true)
        int start = 0;
        int end = s.length() - 1;
        boolean skippable = true;
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                // Если можем пропустить левый или правый символ и получится палиндром - true, иначе - false
                if (checkPalindrome(s, start + 1, end)) {
                    return true;
                } else if (checkPalindrome(s, start, end - 1)) {
                    return true;
                }else {
                    return false;
                }
            }
            start++;
            end--;
        }
        return true;
    }
    private static boolean checkPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
