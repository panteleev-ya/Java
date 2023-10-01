package Day10;

public class Solution {
    public static void main(String[] args) {
        for (int i = 1; i <= 500; i++) {
            System.out.println(new Solution().countOrders(i));
        }
    }

    public int countOrders(int n) {
        long count = 1;
        for (int i = 2; i <= n; i++) {
            count = (count * (2 * i - 1) * i) % 1000000007;
        }
        return (int) count;
    }
}
