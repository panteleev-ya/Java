package Day31;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        String s = "101100111110011010001000";
        int k = 3;
        System.out.println(hasAllCodes(s, k));
    }

    public static boolean hasAllCodes(String s, int k) {
        int n = 1 << k; // 2^k
        HashSet<String> codesSet = new HashSet<>();
        for (int i = 0; i <= s.length() - k; i++) {
            codesSet.add(s.substring(i, i + k));
            if (codesSet.size() == n) {
                return true;
            }
        }
        return false;
    }
}
