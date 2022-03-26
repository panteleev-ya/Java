package OneEditDistance;

import java.util.ArrayDeque;

public class Solution {
    public static void main(String[] args) {
        System.out.println(isOneEditDistance("aDb", "adb"));
        System.out.println(isOneEditDistance("ab", "adb"));
        System.out.println(isOneEditDistance("ac", "bb"));
        System.out.println(isOneEditDistance("ac", "ac"));
        System.out.println(isOneEditDistance("abcdec", "ac"));
    }
    public static boolean isOneEditDistance(String s, String t) {
        ArrayDeque<Character> sDeque = new ArrayDeque<>();
        ArrayDeque<Character> tDeque = new ArrayDeque<>();
        for (char ch: s.toCharArray()) {
            sDeque.addLast(ch);
        }
        for (char ch: t.toCharArray()) {
            tDeque.addLast(ch);
        }

        while (!sDeque.isEmpty() && !tDeque.isEmpty() && sDeque.peekFirst() == tDeque.peekFirst()) {
            sDeque.removeFirst();
            tDeque.removeFirst();
        }
        while (!sDeque.isEmpty() && !tDeque.isEmpty() && sDeque.peekLast() == tDeque.peekLast()) {
            sDeque.removeLast();
            tDeque.removeLast();
        }

        if (sDeque.isEmpty() && tDeque.isEmpty()) {
            return false;
        }
        int sSize = sDeque.size();
        int tSize = tDeque.size();
        return sSize == 1 || tSize == 1;
    }
}
