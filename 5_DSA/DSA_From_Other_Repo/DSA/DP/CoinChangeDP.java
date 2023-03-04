package com.DSA.DP;

import java.util.Arrays;

public class CoinChangeDP {


    /*
        DP Approach
        -> Tabulize it into subproblems
            -> While recursion, the problem was to find numOfCoins of some denomination, for some target
                -> We originally knew target, but in recursive subtree, it grew smaller and smaller as we picked coins

        -> So, we will create a DP table of coins X target
            -> Amount from [0, Amount]
            -> Coins from [0 and all coins]

            Example:
                Target = 11
                Coins = {1, 2, 5}

                -> DP table would be formed via following logic
                    -> DP[i][j] would mean, using coin of denomination 'i', an amount of target 'j' could be found at DP[i][j]

                -> We first write the base cases
                    -> If we have more amount left and 0 coins left, we mark it is impossible (MATH.MAX or something)
                    -> If we have 0 amount left but more coins left, we return 0

                -> We start populating it via following logic
                    -> If at any point, we have some certian coins [0 .. i] and we have to form some certain amount [j]\
                        -> We have two major possibilities
                            -> With coin i, can we form j?
                                -> If i>j, then difinitely we cannot
                                -> In that case,
                                    -> DP[i][j] = DP[i-1][j] {Without including current coin, what is the answer}
                            -> If we i >= j, then we have the option to include it in our answer
                                -> Here, the answer would be formation of
                                    -> Inclusion of current coin
                                    -> This means, target = currTarget - coins[i]
                                        -> NOTE: We are not considering mulitple coins of denomination i here
                                        -> We are only considering 1 coin here
                                    -> Now, Since I have included current coin, and my target has reduced
                                        -> I need to lookup DP table and see what is the answer for formation of remaining amount with current formation of coins
                                        -> DP[i][j] = DP[i][j - coins[i]] + 1; (Added plus 1 because current coin inclusion adds 1 coin to answer)
                                            -> DP[i][j - coins[i]] means, what is the answer for making j - coins[i] of amount using denominations from 0 ... i

                DP Table would look something like this

                0   1   2   3   4   5   6   7   8   9   10  11
            0   0   x   x   x   x   x   x   x   x   x   x   x
            1   0   1   2   3   4   5   6   7   8   9   10  11
            2   0   1   1   2   2   3   3   4   4   5   5   6
            5   0   1   1   2   2   1   2   2   3   3   2   3
    */

    public int coinChange(int[] coins, int amount) {

        int[][] DP = new int[coins.length + 1][amount+1];
        int n = coins.length;
        // If we have more amount left and less coins left, we cannot return anything there, so we return INT_MAX;
        // If we have coins left, but not money, then we return 0;

        for(int i = 0; i<=coins.length; i++) {

            DP[i][0] = 0;
        }


        for(int i = 1; i<=amount; i++) {

            DP[0][i] = 100000;
        }

        Arrays.sort(coins);

        for(int i = 1; i<=coins.length; i++) {
            for(int j = 1; j<=amount; j++) {

                if(coins[i-1] > j ) {
                    DP[i][j] = DP[i-1][j];
                }
                else {
                    DP[i][j] = Math.min(1 + DP[i][j - coins[i-1]], DP[i-1][j]);
                }
            }
        }

        // for(int i = 0; i<=coins.length; i++) {
        //     for(int j = 0; j<=amount; j++) {
        //         System.out.print(DP[i][j] + "  ");
        //     }
        //     System.out.println();
        // }


        return DP[n][amount]>1e4 ? -1:DP[n][amount];
    }
}
