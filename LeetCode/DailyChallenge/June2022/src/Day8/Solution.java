package Day8;

public class Solution {
    public static void main(String[] args) {

    }
    public int removePalindromeSub(String s) {
        // If palindrome - remove itself
        // If not - remove all A, so there are only B's, then remove all B
        StringBuilder sb = new StringBuilder();
        sb.append(s);
        sb.reverse();
        return sb.toString().equals(s) ? 1 : 2;
    }
}
