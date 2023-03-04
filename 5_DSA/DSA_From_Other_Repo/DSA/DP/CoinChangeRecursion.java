package com.DSA.DP;

public class CoinChangeRecursion {
    /*

        Applied Basic backtracking and got till some solution
        It gave TLE, tried to apply memoization on my level, but it did not work properly

        Going ahead with DP Tabulization solution now

        Time Complexity of this solution
        -> At each step, we were searching in 3 different spaces.
            -> So, in step 1: 1 = 3 ^ 0
                -> Step2 : 3^1
                -> Step3 - 3*2
                -> Step4 - 3 ..

                -> So, for h recursion levels, the search space would be 3^h
                    -> Each function in itself is O(1), so time complexity would be O(1) * O(3^h)
                    -> Logarithmic complexity
                        -> Not sure how to represent this.
     */

    public static int getAns(int[] coins, int currTotal, int amount, int pos, int numOfCoins) {

        if(currTotal == amount) {
            return numOfCoins;
        }

        if(currTotal > amount) {

            // We crossed and thus could not make
            return -1;
        }

        if(pos >= coins.length) {
            // Again, did nit find anything and traversed till end of array
            return -1;
        }

        int choice1 = getAns(coins, currTotal + coins[pos], amount, pos, numOfCoins+1);
        int choice2 = getAns(coins, currTotal + coins[pos], amount, pos+1, numOfCoins+1);
        int choice3 = getAns(coins, currTotal, amount, pos+1, numOfCoins);

        int ans = -1;
        if(choice1 != -1) {
            ans = choice1;
        }

        if(choice2 != -1) {

            if(ans != -1) {
                ans = Math.min(ans, choice2);
            }
            else {
                ans = choice2;
            }
        }

        if(choice3 != -1) {

            if(ans != -1) {
                ans = Math.min(ans, choice3);
            }
            else {
                ans = choice3;
            }
        }

        return ans;
    }
}
