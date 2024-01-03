package Day28;

public class Solution {
    public static void main(String[] args) {

    }
    public int missingNumber(int[] nums) {
        // Сумма арифм прогрессии от 0 до n включительно
        // (0 + nums.length) / 2 * (nums.length + 1)
        int sum = nums.length * (nums.length + 1) / 2;
        for (int num: nums) {
            sum -= num;
        }
        return sum;
    }
}
