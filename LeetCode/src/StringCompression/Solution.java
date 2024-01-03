package StringCompression;

public class Solution {
    public static void main(String[] args) {
        char[] chars = {'a', 'a', 'b', 'b', 'c', 'c', 'c'};
        System.out.println(new Solution().compress(chars));
    }

    public int compress(char[] chars) {
        int i = 0;
        StringBuilder result = new StringBuilder();
        while (i < chars.length) {
            char nextChar = chars[i];
            int count = 1;
            i++;
            while (i < chars.length && chars[i] == nextChar) {
                count++;
                i++;
            }
            result.append(nextChar);
            if (count > 1) {
                result.append(count);
            }
        }
        char[] newChars = result.toString().toCharArray();
        System.arraycopy(newChars, 0, chars, 0, newChars.length);
        return newChars.length;
    }
}
