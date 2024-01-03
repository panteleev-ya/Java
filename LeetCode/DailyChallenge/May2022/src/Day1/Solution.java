package Day1;

import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        String s = "y#fo##f";
        String t = "y#f#o##f";
        System.out.println(backspaceCompare(s, t));
    }
    public static boolean backspaceCompare(String s, String t) {
        Stack<Character> sStack = removeBackspaces(s);
        Stack<Character> tStack = removeBackspaces(t);
        return areSame(sStack, tStack);
    }

    private static Stack<Character> removeBackspaces(String s) {
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for (char c : chars) {
            if (c == '#') {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(c);
            }
        }
        return stack;
    }

    private static boolean areSame(Stack<Character> sStack, Stack<Character> tStack) {
        while (!sStack.isEmpty() && !tStack.isEmpty()) {
            if (sStack.peek() != tStack.peek()) {
                return false;
            }
            sStack.pop();
            tStack.pop();
        }
        return sStack.isEmpty() && tStack.isEmpty();
    }
}
