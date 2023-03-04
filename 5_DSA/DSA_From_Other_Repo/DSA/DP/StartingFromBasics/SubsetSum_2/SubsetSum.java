package com.DSA.DP.StartingFromBasics.SubsetSum_2;

public class SubsetSum {

    /*
        Problem
            -> Given a set of positive numbers, check is there exists a subset whose sum is 'K'

        Approach
            -> Brute Force
                -> Basic Recursion
                -> Time Complexity
                    -> O(2^N) - Because two branched recursion will be there
                -> Space Complexity
                    -> O(N) for the arr in the recursion stack space

            -> Recursion with memoization (Top Down DP)
                -> There are two factors affecting the result of a sub problem
                    -> currIndex and currSum
                -> Store the result of that in a 2D matrix, and we look it up
                -> Time Complexity
                    -> O(N * K) - Total number of choices
                -> Space Complexity
                    -> O(N) for the arr in the recursion stack space

            -> Bottom Up DP
                -> Build the dp table with solutions of sub-problems from bottom up and return the result of overall problem once the table is built
                -> Initial States
                    -> When only one number is picked (currIndex = 0)
                    -> When currSum is 0, what is the state of each number going to be? (col = 0)

                -> Once the initial states are built, we are going to build the remaining DP table with the following logic
                    -> For dp[currIndex][currSum] to be true or false, we need to check the following
                        -> Can we get currSum without including current number (currIndex-1)
                            -> dp[currIndex-1][currSum]
                        -> If above is not true, then we include the number, but how do we decide true or false for it?
                            -> If the currentNumber (arr[currIndex]) is not greater than currSum, then we need to figure out the following
                                -> Can we get remaining sum (currSum - arr[currIndex]) from the items before current item?
                                -> dp[currIndex-1][currSum - arr[currIndex]];
                        -> Both of the above conditions will define dp[currIndex][currSum]

                -> Time Complexity
                    -> O(N * Sum)
                -> Space
                    -> O(N * Sum)
    */

    public boolean checkSubsetSumBottomUpDP(int[] arr, int k) {

        boolean[][] dp = new boolean[arr.length][k+1];

        // Initial state 1, when currSum is 0, everything will be true
        for(int row = 0; row < arr.length; row++) {
            dp[row][0] = true;
        }

        // When can we form sum equal to some number if only first item is considered
        // We exclude column 0 because it was set to true (if we need sum = 0, do not pick anything)
        for(int col = 1; col<=k; col++) {
            dp[0][col] = arr[0] == col;
        }

        for(int currIndex = 1; currIndex<arr.length; currIndex++) {
            for(int currSum = 1; currSum<=k; currSum++) {

                if(dp[currIndex-1][currSum]) {
                    dp[currIndex][currSum] = true;
                }
                else if (currSum >= arr[currIndex]){
                    dp[currIndex][currSum] = dp[currIndex-1][currSum - arr[currIndex]];
                }
            }
        }

        return dp[arr.length-1][k];
    }

    public boolean checkSubsetRecMemoization(int[] arr, int k, int currIndex, int currSum, Boolean[][] dp) {

        if(currSum > k || currIndex >= arr.length) {
            return false;
        }

        if(currSum == k) {
            return true;
        }

        if(dp[currIndex][currSum] != null) {
            return dp[currIndex][currSum];
        }

        // When we do not pick current element
        boolean choice1 = checkSubsetRecMemoization(arr, k, currIndex+1, currSum, dp);
        boolean choice2 = checkSubsetRecMemoization(arr, k, currIndex + 1, currSum + arr[currIndex], dp);

        dp[currIndex][currSum] = choice1 || choice2;
        return dp[currIndex][currSum];

        // return (checkSubsetRec(arr, k, currIndex + 1, currSum + arr[currIndex]) || checkSubsetRec(arr, k, currIndex + 1, currSum));
    }

    public boolean checkSubsetRec(int[] arr, int k, int currIndex, int currSum) {

        if(currSum > k || currIndex >= arr.length) {
            return false;
        }

        if(currSum == k) {
            return true;
        }

        return (checkSubsetRec(arr, k, currIndex + 1, currSum + arr[currIndex]) || checkSubsetRec(arr, k, currIndex + 1, currSum));
    }

    public boolean isSubsetSum(int[] arr, int k) {

        // return checkSubsetRec(arr, k, 0, 0);
        Boolean[][] dp = new Boolean[arr.length][k];
        // return checkSubsetRecMemoization(arr, k, 0, 0, dp);

        return this.checkSubsetSumBottomUpDP(arr, k);
    }

    public static void main(String[] args) {

        SubsetSum subsetSum = new SubsetSum();
        int[] num = { 1, 2, 3, 7 };
         System.out.println(subsetSum.isSubsetSum(num, 6));

        num = new int[] { 1, 2, 7, 1, 5 };
        System.out.println(subsetSum.isSubsetSum(num, 10));

         num = new int[] { 1, 3, 4, 8 };
         System.out.println(subsetSum.isSubsetSum(num, 6));
    }
}
