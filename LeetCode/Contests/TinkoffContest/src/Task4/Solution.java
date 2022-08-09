package Task4;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Solution {
    // Not finished solution
    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//
//        Pattern variableAssignmentPatter = Pattern.compile("[a-z]+=");
//        Pattern variablePattern = Pattern.compile("[a-z]+");
//        Pattern constValuePattern = Pattern.compile("[-+]?[0-9]+");
//        Matcher matcher;
//
//        int depth = 0;
//        Map<String, Stack<Integer>> variables = new HashMap<>();
//
//        while (scanner.hasNextLine()) {
//            String line = scanner.nextLine();
//            if (line.charAt(0) == '{') {
//                depth++;
//                for (String varName : variables.keySet()) {
//                    Stack<Integer> values = variables.get(varName);
//                    values.add(values.peek());
//                }
//            } else if (line.charAt(0) == '}') {
//                depth--;
//                for (String varName : variables.keySet()) {
//                    variables.get(varName).pop();
//                }
//            } else {
//                matcher = variableAssignmentPatter.matcher(line);
//                if (!matcher.find()) {
//                    throw new IllegalArgumentException();
//                }
//                int valueStart = matcher.end();
//                matcher = variablePattern.matcher(line);
//                if (matcher.find(valueStart)) {
//                    // variable assignment
//                    Stack<Integer> values = variables.getOrDefault(matcher.group(), null);
//                    int value = values != null ? values.peek() : 0;
//
//                } else {
//                    matcher = constValuePattern.matcher(line);
//                    if (!matcher.find(valueStart)) {
//                        throw new IllegalArgumentException();
//                    }
//                    // value assignment
//                }
//            }
//        }
    }

//    private static class Variable {
//        private String name;
//        private Stack<Integer> value;
//        private int blockDepth;
//
//        public Variable(String name, int value, int blockDepth) {
//            this.name = name;
//            this.value = value;
//            this.blockDepth = blockDepth;
//        }
//
//        public String getName() {
//            return name;
//        }
//
//        public int getValue() {
//            return value;
//        }
//
//        public int getBlockDepth() {
//            return blockDepth;
//        }
//    }
}
