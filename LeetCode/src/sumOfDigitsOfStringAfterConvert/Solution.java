package sumOfDigitsOfStringAfterConvert;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    private static final Map<Character, Integer> transformations = new HashMap<>();

    static {
        char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        int index = 1;
        for (char c : alphabet) {
            transformations.put(c, (index % 10) + (index / 10));
            index++;
        }
    }

    public int getLucky(String s, int k) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        int num = 0;
        char[] sChars = s.toCharArray();
        for (char c : sChars) {
            int t = transformations.getOrDefault(c, -1);
            if (t == -1) {
                return 0;
            }
            num += t;
        }
        for (int i = 0; i < k - 1; i++) {
            num = transform(num);
        }
        return num;
    }

    private int transform(int num) {
        int transformed = 0;
        while (num > 0) {
            transformed += num % 10;
            num /= 10;
        }
        return transformed;
    }
}