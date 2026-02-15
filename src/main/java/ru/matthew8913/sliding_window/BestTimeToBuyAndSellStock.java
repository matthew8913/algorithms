package ru.matthew8913.sliding_window;

public class BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        int r = 1;
        int maxProfit = 0;

        int l = 0;
        while (r < prices.length) {
            if (prices[r] < prices[l]) {
                l = r;
            } else {
                maxProfit = Math.max(maxProfit, prices[r] - prices[l]);
            }
            r++;
        }
        return maxProfit;
    }
}
