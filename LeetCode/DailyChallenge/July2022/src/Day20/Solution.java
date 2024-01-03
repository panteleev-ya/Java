package Day20;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().numMatchingSubSeq("abcde", new String[]{"a", "bb", "acd", "ace"}));
        System.out.println(new Solution().numMatchingSubSeq("dsahjpjauf", new String[]{"ahjpjau", "ja", "ahbwzgqnuk", "tnmlanowax"}));
    }

    public int numMatchingSubSeq(String s, String[] words) {
        Map<String, Integer> wordsMap = new HashMap<>();
        for (String word : words) {
            wordsMap.put(word, wordsMap.getOrDefault(word, 0) + 1);
        }

        char[] sChars = s.toCharArray();
        int subSeqCounter = 0;
        for (String word : wordsMap.keySet()) {

            int j = 0;
            char[] wordChars = word.toCharArray();
            for (int i = 0; i < sChars.length && j < wordChars.length; i++) {
                if (sChars[i] == wordChars[j]) {
                    j++;
                }
            }

            if (j == wordChars.length) {
                subSeqCounter += wordsMap.get(word);
            }

        }

        return subSeqCounter;
    }
}
