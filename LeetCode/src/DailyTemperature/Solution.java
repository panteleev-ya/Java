package DailyTemperature;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        // it is stack, but class Stack is much slower than LinkedList
        Deque<Integer> temperaturesStack = new LinkedList<>();
        int[] answer = new int[temperatures.length];

        for (int i = 0; i < temperatures.length; i++) {
            while (!temperaturesStack.isEmpty() && temperatures[temperaturesStack.peek()] < temperatures[i]) {
                int index = temperaturesStack.pop();
                answer[index] = i - index;
            }
            temperaturesStack.push(i);
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] temperatures = new int[]{73, 74, 75, 71, 69, 72, 76, 73};
        int[] answer = solution.dailyTemperatures(temperatures);
        System.out.println(Arrays.toString(answer));
    }
}