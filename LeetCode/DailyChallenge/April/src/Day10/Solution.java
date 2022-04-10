package Day10;

import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
//        String[] ops = {"5","2","C","D","+"};
//        String[] ops = {"5","-2","4","C","D","9","+","+"};
        String[] ops = {"5"};
        System.out.println(calPoints(ops));
    }
    public static int calPoints(String[] ops) {
        int scoresSum = 0;
        Stack<Integer> scores = new Stack<>();
        for (String action: ops) {
            switch (action) {
                case "D" -> {
                    int doubledScore = scores.peek() * 2;
                    scores.push(doubledScore);
                    scoresSum += doubledScore;
                }
                case "C" -> {
                    int removedScore = scores.pop();
                    scoresSum -= removedScore;
                }
                case "+" -> {
                    int last = scores.pop();
                    int preLast = scores.peek();
                    int lastTwoSum = last + preLast;
                    scores.push(last);
                    scores.push(lastTwoSum);
                    scoresSum += lastTwoSum;
                }
                default -> {
                    int score = Integer.parseInt(action);
                    scores.push(score);
                    scoresSum += score;
                }
            }
        }
        return scoresSum;
    }
}
