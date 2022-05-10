package LongestValidParentheses;

import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        String s1 = ")()())";
        String s2 = ")(()(";
        String s3 = "(()()";
//        System.out.println(longestValidParentheses(s1));
        System.out.println(longestValidParentheses(s2));
//        System.out.println(longestValidParentheses(s3));
    }

    public static int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int length = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    length = Math.max(length, i - stack.peek());
                }
            }
        }
        return length;
    }
}
