package Day27;

public class Solution {
    public static void main(String[] args) {

    }

    public int minPartitions(String n) {
        int maxDigit = 0;
        for (char digitChar : n.toCharArray()) {
            maxDigit = Math.max(maxDigit, digitChar);
        }
        return maxDigit - '0';
    }
}
