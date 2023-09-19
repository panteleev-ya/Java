package ReverseVowelsOfAString;

public class Solution {
    public static void main(String[] args) {

    }

    public String reverseVowels(String s) {
        boolean[] vowels = new boolean[128];
        for (char c : "aeiouAEIOU".toCharArray()) {
            vowels[c] = true;
        }
        char[] chars = s.toCharArray();
        int left = 0;
        int right = chars.length - 1;
        while (left < right) {
            while (left < right && !vowels[chars[left]]) {
                left++;
            }
            while (left < right && !vowels[chars[right]]) {
                right--;
            }
            if (left < right) {
                char t = chars[left];
                chars[left] = chars[right];
                chars[right] = t;
                left++;
                right--;
            }
        }
        return String.valueOf(chars);
    }
}
