package Day30;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().wordSubsets(new String[]{
                "amazon", "apple", "facebook", "google", "leetcode"
        }, new String[]{
                "e", "o"
        }));

        System.out.println(new Solution().wordSubsets(new String[]{
                "amazon", "apple", "facebook", "google", "leetcode"
        }, new String[]{
                "e", "l"
        }));

        System.out.println(new Solution().wordSubsets(new String[]{
                "amazon", "apple", "facebook", "google", "leetcode"
        }, new String[]{
                "lo", "eo"
        }));
    }

    public List<String> wordSubsets(String[] words1, String[] words2) {
        List<String> result = new ArrayList<>();
        int[] words2Freq = getMaxFrequencies(words2);

        //get frequencies for letters in words1 array and compare with
        //getMaxFrequencies of words2, check if it is valid
        //if yes then add it to a result list
        for (String s : words1) {
            int[] word1Freq = getFrequency(s);
            boolean flag = true;
            for (int j = 0; j < 26; j++) {
                if (word1Freq[j] < words2Freq[j]) {
                    flag = false;
                    break;
                }
            }

            if (flag) {
                result.add(s);
            }
        }

        return result;
    }

    //get maximum of freq of letters for all words in an array
    public int[] getMaxFrequencies(String[] word2) {
        int[] max = new int[26];
        for (String s : word2) {
            int[] wordFrequencies = getFrequency(s);

            for (int j = 0; j < 26; j++) {
                max[j] = Math.max(max[j], wordFrequencies[j]);
            }
        }
        return max;
    }

    //get frequency of letters for a word
    public int[] getFrequency(String s) {
        int[] frequencies = new int[26];
        for (char c : s.toCharArray()) {
            frequencies[c - 'a']++;
        }
        return frequencies;
    }
}
