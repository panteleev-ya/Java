package Day22;

public class Solution {
    public static void main(String[] args) {

    }

    public boolean isSubsequence(String s, String t) {
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        int index = 0;
        for (int i = 0; i < tChars.length && index < sChars.length; i++) {
            if (tChars[i] == sChars[index]) {
                index++;
            }
        }
        return index == sChars.length;
    }
}
