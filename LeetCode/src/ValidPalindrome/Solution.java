package ValidPalindrome;

public class Solution {

    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        System.out.println(isPalindrome(s));
    }

    public static boolean isPalindrome(String s) {
        var sToCharArray = s.toLowerCase().toCharArray();
        int lettersCount = 0;
        char[] chars = new char[sToCharArray.length];

        // Убираем все, делаем нижний регистр
        for (char ch: sToCharArray) {
            if (Character.isLetter(ch) || Character.isDigit(ch)) {
                chars[lettersCount] = Character.toLowerCase(ch);
                lettersCount++;
            }
        }

        // Проверяем "палиндромность"
        for (int i = 0; i < (lettersCount + 1) / 2; i++) {
            if (chars[i] != chars[lettersCount - 1 - i]) {
                return false;
            }
        }
        return true;
    }
}
