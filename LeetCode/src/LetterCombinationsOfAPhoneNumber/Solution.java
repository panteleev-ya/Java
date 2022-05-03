package LetterCombinationsOfAPhoneNumber;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        String digits = "23";
        System.out.println(letterCombinations(digits));
    }

    private static final String[][] letters = {
            {},
            {}, {"a", "b", "c"}, {"d", "e", "f"},
            {"g", "h", "i"}, {"j", "k", "l"}, {"m", "n", "o"},
            {"p", "q", "r", "s"}, {"t", "u", "v"}, {"w", "x", "y", "z"}
    };

    public static List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return new ArrayList<>();
        }
        String[] combinations = recursiveLetterCombinations(digits.toCharArray(), 0);
        return Arrays.asList(combinations);
    }

    private static String[] recursiveLetterCombinations(char[] digits, int start) {
        if (start == digits.length - 1) {
            return letters[digits[start] - '0'];
        } else {
            String[] lettersDigit = letters[digits[start] - '0'];
            String[] strings = recursiveLetterCombinations(digits, start + 1);
            String[] result = new String[lettersDigit.length * strings.length];
            int i = 0;
            for (String letter: lettersDigit) {
                for (String str: strings) {
                    result[i] = letter + str;
                    i++;
                }
            }
            return result;
        }
    }
}
