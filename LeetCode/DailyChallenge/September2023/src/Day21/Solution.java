package Day21;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int[] coins = {411, 412, 413, 414, 415, 416, 417, 418, 419, 420, 421, 422};
        int amount = 9864;
//        int[] coins = {2};
//        int amount = 3;
//        int[] coins = {1};
//        int amount = 0;
        System.out.println(coinChange(coins, amount));
    }

    public static int coinChange(int[] coins, int amount) {
        int[] minCoinNumbers = new int[amount + 1];

        Arrays.fill(minCoinNumbers, Integer.MAX_VALUE);

        // To get amount = 0 you need to take 0 coins
        minCoinNumbers[0] = 0;

        for (int coin : coins) {
            for (int currentAmount = coin; currentAmount < minCoinNumbers.length; currentAmount++) {
                if (minCoinNumbers[currentAmount - coin] != Integer.MAX_VALUE) {
                    minCoinNumbers[currentAmount] = Math.min(minCoinNumbers[currentAmount], minCoinNumbers[currentAmount - coin] + 1);
                }
            }
        }

        // That amount of money cannot be made up by any combination of the coins
        if (minCoinNumbers[minCoinNumbers.length - 1] == Integer.MAX_VALUE) {
            minCoinNumbers[minCoinNumbers.length - 1] = -1;
        }

        return minCoinNumbers[minCoinNumbers.length - 1];
    }
}
