package ValidParentheses;

import java.util.Stack;

public class Solution {

    public static void main(String[] args) {
        String s = "(])";
        System.out.println(isValid(s));
    }

    public static boolean isValid(String s) {
        Stack<Character> breaksStack = new Stack<>();
        for (char br: s.toCharArray()) {
            if (br == '(' || br == '[' || br == '{') {
                breaksStack.push(br);
            } else if (!breaksStack.isEmpty()) {
                var lastBreak = breaksStack.peek();
                if (br == ')' && lastBreak == '(' ||
                    br == ']' && lastBreak == '[' ||
                    br == '}' && lastBreak == '{') {
                    breaksStack.pop();
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }
        return breaksStack.isEmpty();
    }
}