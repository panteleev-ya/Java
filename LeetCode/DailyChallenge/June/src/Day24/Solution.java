package Day24;

public class Solution {
    public static void main(String[] args) {
        System.out.println(isPossible(new int[]{9, 9}));
        System.out.println(isPossible(new int[]{9, 5, 3}));
    }

    public static boolean isPossible(int[] target) {
        long sum = 0;
        int max = 0, index = 0;
        for (int i = 0; i < target.length; i++) {
            sum += target[i];
            if (target[i] > max) {
                max = target[i];
                index = i;
            }
        }
        sum -= max;
        if (sum == 1 || max == 1) {
            return true;
        }
        if (max < sum || sum == 0 || max % sum == 0) {
            return false;
        }
        max %= sum;
        target[index] = max;
        return isPossible(target);
    }
}
