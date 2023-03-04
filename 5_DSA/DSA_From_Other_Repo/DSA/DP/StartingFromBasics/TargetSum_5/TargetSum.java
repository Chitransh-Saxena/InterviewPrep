package com.DSA.DP.StartingFromBasics.TargetSum_5;

import java.util.Arrays;

public class TargetSum {

    /*
        -> Problem
            -> Given an array arr and a sum K
            -> Find how many subsets can be formed so that
                -> All the elements of the array are assigned with either '+' or '-';
                -> And totalSum of the subset is equal to 'k'

            -> Example:
                -> arr = [1, 1, 2, 3]
                -> k = 1
                -> {+1 -1 -2 +3}, {-1 +1 -2 +3}, {+1 +1 +2 -3}

        -> Approach
            -> This problem is very similar to count number of subsets problem, with a constraint that all the elements should be taken
            -> Problem statement can also be deduced to a formula like this
                -> In any certain subset, we are expecting the difference of sum of subsets to result in 'k'
                -> {+1 -1 -2 +3} = 1
                -> {3+1} - {1 + 2} = 1
                -> Sum(s1) - Sum(s2) = k
                    -> This means, difference of two subsets results in 'k'

                -> But we know one more thing as well, since we are taking all the numbers in our subset
                    -> Sum(s1) + Sum(s2) = Sum(allNums)
                        -> sum of subsets sum will equal to all the numbers

                -> So, we have two equations
                    -> Sum(s1) + Sum(s2) = Sum(allNums)
                    -> Sum(s1) - Sum(s2) = k

                    -> Solving above equation
                    -> 2 * Sum(s1) = Sum(allNums) + k
                    -> Sum(s1) = (Sum(allNums) + k ) / 2;

                -> So, essentially our whole problem boils down to this
                    -> Find count of subsets whose sum is equal to
                        -> (Sum(allNums) + k) / 2;


                -> Space Optimization
                    -> Instead of 2-D matrix for DP table (currIndex and currSum), we can just use a 1-D array for DP
                    -> Only for currSum
                        -> And the only factor of choice would be, if we can form the sum
                        -> But here as well, we have the choice to either include or not
                            -> Exclude currNum
                                -> dp[currSum] = dp[currSum]; {did we get currSum before current iteration?}
                            -> Include currNum
                                -> dp[currSum] = dp[currSum] + dp[currSum - arr[num]];
    */

    private int countSubsetSum(int[] arr, int k) {

        int sum = Arrays.stream(arr).sum();

        if(sum < k || ((sum + k) % 2) == 1) {
            return 0;
        }

        return this.countSubsetSumDPMatrix(arr, k);
    }

    private int countSubsetSumDPMatrix(int[] arr, int k) {

        int n = arr.length;
        int[][] dp = new int[n][k + 1];

        for(int i = 0; i<n; i++) {
            dp[i][0] = 1;
        }

        for(int j = 1; j<=k; j++) {
            dp[0][j] = arr[0] == j ? 1 : 0;
        }

        for(int i = 1; i<n; i++) {
            for(int j = 1; j<=k; j++) {

                if(k >= arr[i]) {
                    dp[i][j] = dp[i-1][j] + dp[i-1][j - arr[i]];
                }
                else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        return dp[n-1][k];
    }

    private int countSubsetDP_1D_Array(int[] arr, int k) {

        int n = arr.length;
        int[] dp = new int[k + 1];

        dp[0] = 1;
        for(int j = 1; j<=k; j++) {
            dp[j] = arr[0] == j ? 1 : 0;
        }

        for(int i = 1; i<n; i++) {
            for(int j = 1; j<=k; j++) {

                if(k >= arr[i]) {
                    dp[j] = dp[j] + dp[j - arr[i]];
                }
                else {
                    dp[j] = dp[j];
                }
            }
        }

        return dp[k];

    }

    public static void main(String[] args) {

    }
}
