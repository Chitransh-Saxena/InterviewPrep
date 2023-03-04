package com.DSA.DP;

public class BuyAndSellStock2 {

    /*
        -> Approach
            -> We are given prices array which show price on ith day
            -> We will do simple thing of buying on first low and selling on first high
    */


    public int maxProfit(int[] prices) {

        int profit = 0;
        for(int i = 0; i<prices.length-1; i++) {

            if(prices[i] < prices[i+1]) {

                profit+=(prices[i+1] - prices[i]);
            }
        }

        return profit;
    }
}
