package Day6;

import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        String s = "pbbcggttciiippooaais";
        int k = 2;
        System.out.println(removeDuplicates(s, k));
    }

    public static String removeDuplicates(String s, int k) {
        Stack<Pair> pairStack = new Stack<>();
        for (char ch: s.toCharArray()) {
            if (!pairStack.empty()) {
                Pair last = pairStack.peek();

                // If last char is equal to current char
                if (ch == last.ch) {
                    // Increment counter
                    int newCount = last.count + 1;
                    pairStack.pop();
                    pairStack.push(new Pair(ch, newCount));
                } else {// Else add new char
                    pairStack.push(new Pair(ch, 1));
                }
            } else {
                pairStack.push(new Pair(ch, 1));
            }

            // If last counter is equal to k -> remove last char
            if (pairStack.peek().count == k) {
                pairStack.pop();
            }
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (Pair p : pairStack) {
            int i = p.count;
            while (i > 0) {
                stringBuilder.append(p.ch);
                i--;
            }
        }
        return stringBuilder.toString();
    }

    private static class Pair {
        char ch;
        int count;

        public Pair(char ch, int count) {
            this.ch = ch;
            this.count = count;
        }
    }
}
