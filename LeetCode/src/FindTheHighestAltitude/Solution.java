package FindTheHighestAltitude;

public class Solution {
    public static void main(String[] args) {

    }

    public int largestAltitude(int[] gain) {
        int max = 0;
        int sum = 0;
        for (int i : gain) {
            sum += i;
            if (sum > max) {
                max = sum;
            }
        }
        return max;
    }
}
