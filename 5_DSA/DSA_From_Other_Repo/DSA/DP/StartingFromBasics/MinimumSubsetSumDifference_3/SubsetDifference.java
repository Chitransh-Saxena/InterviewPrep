package com.DSA.DP.StartingFromBasics.MinimumSubsetSumDifference_3;

import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;

public class SubsetDifference {

    /*
        Problem
            -> Given an array, partition it into two subsets with minimum sum

        Approach
            -> Again, since there is no sure shot  iterative approach for this, recursion is going to be the means of traversal
            -> Recursive - Brute Force
                -> Form two sets, empty from start
                -> Since, we need to return the difference, no need to think about saving sets for the final answer, constant change in min value should do the job
                -> In each step, form min diff by choosing and not choosing to add any element in the sets
                -> Return min in each step
                -> Maintaining a set will be a little tedious, keeping sum instead of set
                    -> In each step of choosing and not choosing, add to the sum in the name of two partitions
                -> TC:
                    -> O(2^N) - 2 branched recursion
                -> SC:

                    -> O(N) for the array in recursive stack space


            -> Memoization
                -> From above approach, we see we have three factors at each step
                    -> currIndex, sum1 and sum2
                    -> This can simplified by the logic that each point, if sum1 has certain value, we can expect sum2 to have remaining sum only
                        -> Why?
                        -> Because, we want subset difference with all the elements, so sum1 + sum2 = totalSum
                    -> Therefore, we can reduce the factors from 3 to just 2
                        -> currIndex, sum1 or sum2
                -> From hereon, it will be a standard memoization approach
                    -> Store the min in 2D array for currIndex and sum1
                -> TC
                    -> O(N * totalSum)
                -> SC
                    -> O(N) for array in recursive stack space

            -> Bottom Up DP Approach
                -> What will the DP table hold?
                    -> minDifference for each value of currIndex and sum1
                    -> We will try to achieve sum1 as totalSum / 2;
                        -> Because that is min value we can get for our difference (0)
                -> Initial states of DP
                    -> column_0
                        -> When minDifference is
    */

    private int getMinRec(int[] arr, int sum1, int sum2, int currIndex) {

        if(currIndex == arr.length) {
            return Math.abs((sum1 - sum2));
        }

        // Include current number in first set
        int diff1 = getMinRec(arr, sum1 + arr[currIndex], sum2, currIndex + 1);

        // Include current number in second set
        int diff2 = getMinRec(arr, sum1, sum2 + arr[currIndex], currIndex + 1);

        return Math.min(diff1, diff2);

    }

    private int getMinRecMemoization(int[] arr, int sum1, int sum2, int currIndex, Integer[][] dp) {

        if(currIndex == arr.length) {
            return Math.abs((sum1 - sum2));
        }

        if(dp[currIndex][sum1] != null) {
            return dp[currIndex][sum1];
        }

        // Include current number in first set
        int diff1 = getMinRecMemoization(arr, sum1 + arr[currIndex], sum2, currIndex + 1, dp);

        // Include current number in second set
        int diff2 = getMinRecMemoization(arr, sum1, sum2 + arr[currIndex], currIndex + 1, dp);

        int min =  Math.min(diff1, diff2);
        dp[currIndex][sum1] = min;
        return min;

    }

    public int getMin(int[] arr) {

        int sum = Arrays.stream(arr).sum();
        Integer[][] dp = new Integer[arr.length][sum+1];
        // return getMinRec(arr, 0, 0, 0);
        return getMinRecMemoization(arr, 0, 0, 0, dp);
    }

    public static void main(String[] args) {

        SubsetDifference sd = new SubsetDifference();

        Instant start = Instant.now();
        // time passes


        int[] num = {1, 2, 3, 9};
        System.out.println(sd.getMin(num));

        num = new int[]{1, 2, 7, 1, 5};
        System.out.println(sd.getMin(num));

        num = new int[]{1, 3, 100, 4};
        System.out.println(sd.getMin(num));

        Instant end = Instant.now();
        long timeElapsed = Duration.between(start, end).toNanos();


        System.out.println("Time Taken: " + timeElapsed);

    }
}
