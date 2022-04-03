package Day1;

public class Solution {
    public static void main(String[] args) {
        char[] chars = "hello".toCharArray();
        reverseString(chars);
        System.out.println(chars);
    }
    public static void reverseString(char[] s) {
        char tmp;
        for (int i = 0; i < (s.length + 1) / 2; i++) {
            tmp = s[i];
            s[i] = s[s.length - 1 - i];
            s[s.length - 1 - i] = tmp;
        }
    }
}
