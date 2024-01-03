package MergeStringsAlternately;

public class Solution {
    public static void main(String[] args) {

    }

    public String mergeAlternately(String word1, String word2) {
        StringBuilder sb = new StringBuilder();
        char[] chars1 = word1.toCharArray();
        char[] chars2 = word2.toCharArray();
        int i = 0;
        for (; i < Math.min(chars1.length, chars2.length); i++) {
            sb.append(chars1[i]);
            sb.append(chars2[i]);
        }
        for (; i < chars1.length; i++) {
            sb.append(chars1[i]);
        }
        for (; i < chars2.length; i++) {
            sb.append(chars2[i]);
        }
        return sb.toString();
    }
}
