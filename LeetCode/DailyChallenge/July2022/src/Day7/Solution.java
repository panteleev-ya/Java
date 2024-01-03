package Day7;

public class Solution {
    public static void main(String[] args) {
        System.out.println(isInterleave("aabcc", "dbbca", "aadbbcbcac"));
        System.out.println(isInterleave("aabcc", "dbbca", "aadbbbaccc"));
        System.out.println(isInterleave("", "", ""));
    }

    public static boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }

        boolean[][] interleaving = new boolean[2][s2.length() + 1];
        int i;
        int j = s2.length();
        int k = 1;

        do {
            interleaving[0][j] = true;
            j--;
        } while (j >= 0 && s2.charAt(j) == s3.charAt(s1.length() + j));

        for (i = s1.length() - 1; i >= 0; i--) {
            for (j = s2.length(); j >= 0; j--) {
                interleaving[k][j] = (s3.charAt(i + j) == s1.charAt(i) && interleaving[1 - k][j]) ||
                        (j < s2.length() && s3.charAt(i + j) == s2.charAt(j) && interleaving[k][j + 1]);
            }
            k = 1 - k;
        }

        return interleaving[1 - k][0];
    }
}
