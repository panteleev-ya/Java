package Day20;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        System.out.println(minimumLengthEncoding(new String[]{"time", "me", "bell"}));
        System.out.println(minimumLengthEncoding(new String[]{"t"}));
    }

    public static int minimumLengthEncoding(String[] words) {
        Trie trie = new Trie();
        int refStringLength = 0;
        Arrays.sort(words, (s1, s2) -> s2.length() - s1.length());
        for (String word : words) {
            if (trie.insert(word)) {
                refStringLength += word.length() + 1;
            }
        }
        return refStringLength;
    }

    private static class Trie {
        TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        public boolean insert(String word) {
            boolean isNew = false;
            TrieNode node = root;
            for (int i = word.length() - 1; i >= 0; --i) {
                int index = word.charAt(i) - 'a';
                if (node.children[index] == null) {
                    isNew = true;
                    node.children[index] = new TrieNode();
                }
                node = node.children[index];
            }
            return isNew;
        }
    }

    private static class TrieNode {
        TrieNode[] children = new TrieNode[26];

        public TrieNode() {
        }
    }
}
