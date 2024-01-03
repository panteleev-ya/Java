package Day27;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        int[][] arrayPairs = {
                {2, 3}, {7, 3}, {3, 8}, {1, 7}, {1, 0}, {0, 4}, {0, 6}, {3, 4}, {2, 5}
        };

        String s = "otilzqqoj";
        List<List<Integer>> pairs = new ArrayList<>();

        for (int[] arrayPair : arrayPairs) {
            ArrayList<Integer> pair = new ArrayList<>();
            pair.add(arrayPair[0]);
            pair.add(arrayPair[1]);
            pairs.add(pair);
        }

        System.out.println(smallestStringWithSwaps(s, pairs));
    }

    public static String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        // UnionFind (by DSU)
        // https://youtu.be/_Dau6qhna84
        // https://www.geeksforgeeks.org/union-find-algorithm-set-2-union-by-rank/
        char[] chars = s.toCharArray();
        int n = chars.length;
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        for (List<Integer> pair : pairs) {
            makeUnion(parent, pair.get(0), pair.get(1));
        }
        Map<Integer, PriorityQueue<Character>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int head = findParent(parent, i);
            parent[i] = head;
            if (!map.containsKey(head)) {
                map.put(head, new PriorityQueue<>());
            }
            map.get(head).add(chars[i]);
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < n; i++) {
            stringBuilder.append(map.get(parent[i]).poll());
        }
        return stringBuilder.toString();
    }

    private static int findParent(int[] parent, int i) {
        if (parent[i] == i) {
            return i;
        }
        int r = findParent(parent, parent[i]);
        parent[i] = r;
        return r;
    }

    private static void makeUnion(int[] parent, int src, int dst) {
        int srcParent = findParent(parent, src);
        int dstParent = findParent(parent, dst);
        parent[srcParent] = dstParent;
    }
//    private static void improveLexicographically(char[] chars, List<List<Integer>> pairs, PriorityQueue<String> combinations) {
//        for (var pair : pairs) {
//            int left = pair.get(0);
//            int right = pair.get(1);
//            if (chars[left] != chars[right]) {
//                char[] newChars = swap(chars, left, right);
//                String newS = String.valueOf(newChars);
//                if (!combinations.contains(newS)) {
//                    combinations.add(newS);
//                    improveLexicographically(newChars, pairs, combinations);
//                }
//            }
//        }
//    }
//
//    private static char[] swap(char[] chars, int left, int right) {
//        char[] newChars = Arrays.copyOf(chars, chars.length);
//        newChars[left] = chars[right];
//        newChars[right] = chars[left];
//        return newChars;
//    }

//    private static boolean less(char[] chars, char[] newChars) {
//        for (int i = 0; i < chars.length; i++) {
//            if (chars[i] < newChars[i]) {
//                return false;
//            } else if (chars[i] > newChars[i]) {
//                return true;
//            }
//        }
//        return true;
//    }
}
