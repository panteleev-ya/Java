package Day24;

public class Solution {
    public static void main(String[] args) {

    }

    public static int longestValidParentheses(String s) {
        int longest = 0;

        int leftCount = 0;
        int rightCount = 0;

        for (int start = 0, end = 0; end < s.length(); end++) {
            if (s.charAt(end) == '(') {
                leftCount++;
            } else {
                rightCount++;
            }

            if (leftCount == rightCount) {
                longest = Math.max(longest, end - start + 1);
            } else if (leftCount < rightCount) {
                leftCount = 0;
                rightCount = 0;
                start = end + 1;
            }
        }

        leftCount = 0;
        rightCount = 0;

        for (int start = s.length() - 1, end = s.length() - 1; start >= 0; start--) {
            if (s.charAt(start) == ')') {
                rightCount++;
            } else {
                leftCount++;
            }

            if (leftCount == rightCount) {
                longest = Math.max(longest, end - start + 1);
            } else if (leftCount > rightCount) {
                leftCount = 0;
                rightCount = 0;
                end = start - 1;
            }
        }

        return longest;
    }
}
