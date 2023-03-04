package com.DSA.DP;

public class BuyAndSellStock1 {

    public int maxProfit(int[] prices) {

        int min = Integer.MAX_VALUE;

        /*
            Or, since the buying day has to be low, and has to come first, we know the smaller number has to come from left side
            So, what we will do, we will mantain a min number to keep track of what is the minimum I have so far
            Now, once we have some minimum to compare with, we can just traverse the array and subtract with max
        */


        int ans = 0;

        for(int i = 0; i<prices.length; i++) {

            min = Math.min(min, prices[i]);
            ans = Math.max(ans, prices[i] - min);
        }

        return ans;
    }
}
