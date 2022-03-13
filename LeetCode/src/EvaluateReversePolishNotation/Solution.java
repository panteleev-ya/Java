package EvaluateReversePolishNotation;

import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        String[] tokens = {"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
        System.out.println(evalRPN(tokens));
    }

    private static boolean isOperator(String s) {
        if (s.length() != 1) {
            return false;
        }
        char ch = s.charAt(0);
        return ch == '+' || ch == '-' || ch == '*' || ch  == '/';
    }
    private static int useOperator(int a, int b, String operator) {
        return switch (operator.charAt(0)) {
            case '+' -> a + b;
            case '-' -> a - b;
            case '*' -> a * b;
            case '/' -> a / b;
            default -> -1;
        };
    }
    public static int evalRPN(String[] tokens) {
        if (tokens.length < 3) {
            return Integer.parseInt(tokens[0]);
        }

        Stack<Integer> stack = new Stack<>();
        stack.push(Integer.parseInt(tokens[0]));
        stack.push(Integer.parseInt(tokens[1]));
        int a, b;
        for (int i = 2; i < tokens.length; i++) {
            // Если наткнулись на оператор, то
            // Два последних числа в стеке собираются в одно
            if (isOperator(tokens[i])) {
                b = stack.peek();
                stack.pop();
                a = stack.peek();
                stack.pop();
                stack.push(useOperator(a, b, tokens[i]));
            } else {
                // Иначе добавляется новое число в стек
                stack.push(Integer.parseInt(tokens[i]));
            }
        }
        return stack.peek();
    }
}
