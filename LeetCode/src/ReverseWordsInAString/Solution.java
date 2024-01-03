package ReverseWordsInAString;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().reverseWords("the sky is blue"));
    }

    public String reverseWords(String s) {
        char[] chars = s.trim().toCharArray();

        reverseChars(chars, 0, chars.length - 1);

        int start = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == ' ') {
                reverseChars(chars, start, i - 1);
                start = i + 1;
            }
        }

        reverseChars(chars, start, chars.length - 1);

        int j = 0;
        if (chars[0] != ' ') {
            j++;
        }
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] != ' ' || chars[i - 1] != ' ') {
                chars[j] = chars[i];
                j++;
            }
        }
        if (j > 0 && chars[j - 1] == ' ') {
            j--;
        }

        return new String(chars, 0, j);
    }

    private void reverseChars(char[] chars, int start, int end) {
        while (start < end) {
            char temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;
            start++;
            end--;
        }
    }
}
