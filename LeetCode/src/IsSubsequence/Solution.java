package IsSubsequence;

public class Solution {
    public static void main(String[] args) {
        String s = "abc";
        String t = "ghbhc";
        System.out.println(isSubsequence(s, t));
    }

    public static boolean isSubsequence(String s, String t) {
        int i = 0;
        int j = 0;
        var arrS = s.toCharArray();
        var arrT = t.toCharArray();
        while (i < s.length() && j < t.length()) {
            if (arrS[i] == arrT[j]) {
                i++;
            }
            j++;
        }
        return i == s.length();
    }
}
