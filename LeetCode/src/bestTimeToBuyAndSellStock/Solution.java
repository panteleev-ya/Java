package bestTimeToBuyAndSellStock;

public class Solution {
    public static int maxProfit(int[] prices) {
        if (prices.length < 2) {
            return 0;
        }

        int maxProfit = 0;
        int buyDay = 0;
        int sellDay = 1;

        while (sellDay < prices.length) {
            if (prices[buyDay] > prices[sellDay]) {
                buyDay = sellDay;
            } else {
                maxProfit = Math.max(maxProfit, prices[sellDay] - prices[buyDay]);
            }
            sellDay++;
        }

        return maxProfit;
    }
}
