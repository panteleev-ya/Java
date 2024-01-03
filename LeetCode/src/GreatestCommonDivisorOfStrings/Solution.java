package GreatestCommonDivisorOfStrings;

public class Solution {
    public static void main(String[] args) {
        String str1 = "ABCABCABC";
        String str2 = "ABCABC";
        System.out.println(new Solution().gcdOfStrings(str1, str2));
    }

    public String gcdOfStrings(String str1, String str2) {
        if (!(str1 + str2).equals(str2 + str1)) {
            return "";
        } else {
            int gcd = gcd(str1.length(), str2.length());
            return str1.substring(0, gcd);
        }
    }

    public int gcd(int x, int y) {
        return y == 0 ? x : gcd(y, x % y);
    }
}
