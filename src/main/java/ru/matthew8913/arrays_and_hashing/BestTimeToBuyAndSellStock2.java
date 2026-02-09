package ru.matthew8913.arrays_and_hashing;

public class BestTimeToBuyAndSellStock2 {
    public static int maxProfit(int[] prices) {
        int prev = prices[0];
        int sum = 0;
        for (int price : prices) {
            if(price>prev) {
                sum+= price-prev;
            }
            prev = price;
        }
        return sum;

    }

    public static void main(String[] args) {
        int[] prices = new int[]{7,1,5,3,6,4};
        System.out.println(maxProfit(prices));
    }
}
