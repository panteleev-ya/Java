package Task5;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int q = scanner.nextInt();
        scanner.nextLine();

        Trie trie = new Trie();

        for (int i = 0; i < n; i++) {
            trie.add(scanner.nextLine(), i + 1);
        }

        for (int i = 0; i < q; i++) {
            int k = scanner.nextInt();
            String word = scanner.nextLine().replaceFirst("^\\s+", "");
            TrieNode node = trie.getNodeByPrefix(word);
            if (node != null) {
                System.out.println(node.findKth(k));
            } else {
                System.out.println(-1);
            }
        }
    }

    private static class Trie {
        private final TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        public void add(String word, int index) {
            TrieNode node = root;
            for (int i = 0; i < word.length(); i++) {
                node.size++;
                node.map.putIfAbsent(word.charAt(i), new TrieNode());
                node = node.map.get(word.charAt(i));
            }
            node.size++;
            node.stringIndex = index;
        }

        public boolean find(String word) {
            TrieNode node = root;
            for (int i = 0; i < word.length(); i++) {
                if (!node.map.containsKey(word.charAt(i))) {
                    return false;
                }
                node = node.map.get(word.charAt(i));
            }
            return node.stringIndex != -1;
        }

        public TrieNode getNodeByPrefix(String word) {
            TrieNode node = root;
            for (int i = 0; i < word.length(); i++) {
                if (!node.map.containsKey(word.charAt(i))) {
                    return null;
                }
                node = node.map.get(word.charAt(i));
            }
            return node;
        }
    }

    private static class TrieNode {
        TreeMap<Character, TrieNode> map;
        int size;
        int stringIndex;

        public TrieNode() {
            map = new TreeMap<>();
            size = 0;
            stringIndex = -1;
        }

        public int findKth(int k) {
            if (k == 1 && stringIndex != -1) {
                return stringIndex;
            }

            int subSize = (stringIndex != -1 ? 1 : 0);
            for (Map.Entry<Character, TrieNode> entry : map.entrySet()) {
                TrieNode child = entry.getValue();

                if (subSize + child.size >= k) {
                    return child.findKth(k - subSize);
                }

                subSize += child.size;
            }

            return -1; // size not enough everywhere
        }
    }
}
