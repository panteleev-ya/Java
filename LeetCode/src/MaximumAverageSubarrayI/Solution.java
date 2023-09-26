package MaximumAverageSubarrayI;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().maxVowels("abciiidef", 3));
    }

    public int maxVowels(String s, int k) {
        boolean[] isVowels = new boolean[26];
        char[] vowels = {'a', 'e', 'i', 'o', 'u'};
        for (char vowel : vowels) {
            isVowels[vowel - 'a'] = true;
        }
        int count = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < k; i++) {
            if (isVowels[chars[i] - 'a']) {
                count++;
            }
        }
        int maxCount = count;
        for (int i = k; i < chars.length; i++) {
            if (isVowels[chars[i - k] - 'a']) {
                count--;
            }
            if (isVowels[chars[i] - 'a']) {
                count++;
            }
            maxCount = Math.max(maxCount, count);
        }
        return maxCount;
    }
}
