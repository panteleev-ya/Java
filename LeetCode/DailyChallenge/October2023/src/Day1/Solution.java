package Day1;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().reverseWords("Let's take LeetCode contest"));
    }

    public String reverseWords(String s) {
        char[] chars = s.toCharArray();
        char[] result = new char[chars.length];
        int index = 0;
        int start = 0;
        int end = 0;
        while (end < chars.length) {
            while (start < chars.length && Character.isWhitespace(chars[start])) {
                start++;
            }
            end = start;
            while (end < chars.length && !Character.isWhitespace(chars[end])) {
                end++;
            }
            for (int j = end - 1; j >= start; j--) {
                result[index] = chars[j];
                index++;
            }
            if (index < result.length) {
                result[index] = ' ';
                index++;
            }
            start = end;
        }
        return new String(result, 0, index);
    }
}
