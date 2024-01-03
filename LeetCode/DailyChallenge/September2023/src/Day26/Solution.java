package Day26;

import java.util.Deque;
import java.util.LinkedList;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().removeDuplicateLetters("bcabc"));
        System.out.println(new Solution().removeDuplicateLetters("ecbacba"));
    }

    public String removeDuplicateLetters(String s) {
        int[] lastIndex = new int[26];
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            lastIndex[chars[i] - 'a'] = i; // track the lastIndex of character presence
        }

        boolean[] seen = new boolean[26]; // keep track seen
        Deque<Character> peekedChars = new LinkedList<>();

        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            int diff = c - 'a';
            if (seen[diff]) {
                continue; // if seen continue as we need to pick one char only
            }
            while (!peekedChars.isEmpty() && peekedChars.peekLast() > c && i < lastIndex[peekedChars.peekLast() - 'a']) {
                seen[peekedChars.pollLast() - 'a'] = false; // pop out and mark unseen
            }
            peekedChars.addLast(c); // add into stack
            seen[diff] = true; // mark seen
        }

        StringBuilder sb = new StringBuilder();
        while (!peekedChars.isEmpty()) {
            sb.append(peekedChars.pollFirst());
        }
        return sb.toString();
    }
}
