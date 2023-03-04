package com.DSA.DP.StartingFromBasics.EqualSubset_1;

import java.util.Arrays;
import java.util.Set;

public class Code {

    /*
        Problem:
            -> Given a set of positive numbers, find if we can partition them into two subsets of equal sum
            -> Array would not be sorted

        Example:
            -> [1, 2, 3, 4]
                -> [1, 4] and [2, 3]
                -> Therefore, true


        Approach
            -> Brute Force
                -> Try all combinations of partitioning them
                -> Also, we want two partitions of equal sum, this means total sum should be divisible by 2
                    -> So, if we can form one subset with sum (s/2)

                -> Time Complexity
                    -> Since two branched recursion tree will be formed
                        -> O(2^N)
                -> Space Complexity
                    -> O(N) for recursion stack
                        -> This is mostly the array.

            -> Memoization (Top Down DP)
                -> In above method (recursion), there would be several branches formed where the problem combination is same
                    -> We can store the result of that and re-use it if necessary
                -> The factors which change are currIndex and currSum
                    -> Our aim is to reach half the totalSum with any number of elements
                -> We can have a DS which will store the combinations of currIndex and currSum
                -> Boolean[][] dp = new Boolean[arr.length][totalSum/2 + 1];
                    -> So, dp[2][5] = true would mean, if currIndex is 2, then with some elements (not all, not none, could be any number of elements),
                        -> total sum of 5 is possible
                    -> Also, dp[3][1] = false; If currIndex is 3, and total sum 1 is expected, it is not possible
                -> Time Complexity
                    -> To navigate through all the choices, how many options we have?
                        -> N * Sum
                        -> O(N * S)
                -> Space Complexity
                    -> O(N) for the stack space

            -> DP Bottom Up
                -> This approach is basically building the DP table
                -> How is this DP table going to be populated?
                    -> Same choices, currIndex and currSum
                -> at any point dp[currIndex][currSum] will be formed of two choices
                    -> currIndex-1
                        -> At this point
                            -> Did we pick an element
                            -> Did we not pick an element
                        -> What was the output of OR case?
                            -> Is there some sure shot way to get this?
                            Yes

                                -> We can check if we can get currSum by not picking current number
                                    -> dp[i-1][currSum]
                                -> If, above is not true, so now we check if we can include current number or not?
                                    -> if ( currSum >= arr[currIndex])
                                    -> If above case is true, if we cannot include current number
                                        -> Then we take whatever we got at previous index by not picking previous number


                                -> dp[i-1][currSum]
                                    -> This is, us at previous index, after picking the number and adding it to currSum
                                -> dp[i-1][currSum - arr[i-1]]
                                    -> This is, us at previous index, after not picking the number and thus not adding it to currSum
                                -> OR case of above two will form
                                    -> dp[i][currSum]
                -> Time Complexity
                    -> O(N * Sum / 2)
                -> Space Complexity
                    -> O(N * C)
    */

    public boolean canPartitionBottomUp(int[] arr) {

        int sum = Arrays.stream(arr).sum();
        if(sum % 2 == 1) {
            return false;
        }

        int s = sum / 2;

        boolean[][] dp = new boolean[arr.length][s + 1];


        // First column, sum = 0, always possible, we can always choose to not pick elements
        for(int i = 0; i<arr.length; i++) {
            dp[i][0] = true;
        }

        // Fill first row separately
        // Since there is only 1 number arr[0], then it can only be equal to one of the values, not all and not any combination
        for(int i = 1; i <=s; i++) {

            if(arr[0] == i) {
                dp[0][i] = true;
            }
            else {
                dp[0][i] = false;
            }
        }

        for(int i = 1; i<arr.length; i++) {

            for(int currSum = 1; currSum<=s; currSum++) {

                if(dp[i-1][currSum]) {          // If sum was formed without current number, it meets condition
                    dp[i][currSum] = true;
                }
                else if (currSum >= arr[i]) {

                    // If current sum is greater than current number, then we can no longer pick current number
                    // Only option is to take what we have by not picking previous number
                    dp[i][currSum] = dp[i-1][currSum - arr[i]];

                }
            }
        }

        return dp[arr.length - 1][s];

    }

    public boolean canPartitionBT(int[] arr, int currIndex, int currSum, int sum) {

        if((currSum > sum) || currIndex >= arr.length) {
            return false;
        }

        if(currSum == sum) {
            return true;
        }

        return (canPartitionBT(arr, currIndex+1, currSum + arr[currIndex], sum) || canPartitionBT(arr, currIndex+1, currSum, sum));
    }

    public boolean canPartitionBTMemoization(int[] arr, int currIndex, int currSum, int sum, Boolean[][] dp) {

        if((currSum > sum) || currIndex >= arr.length) {
            return false;
        }

        if(currSum == sum) {
            return true;
        }

        if(dp[currIndex][currSum] != null) {
            return dp[currIndex][currSum];
        }
        else {
            boolean case1 = canPartitionBTMemoization(arr, currIndex+1, currSum + arr[currIndex], sum, dp);
            if(case1) {
                dp[currIndex][currSum] = true;
                return true;
            }


            boolean case2 = canPartitionBTMemoization(arr, currIndex+1, currSum, sum, dp);

            // If case1 were true, we would have updated dp and returned, so if we are reaching this line, this means, case1 was false
            // So, it does not matter what value is there for case2. It is gonna be correct to store it here and return that only
            dp[currIndex][currSum] = case2;
            return case2;
        }

    }

    public boolean canPartition(int[] arr) {

        int sum = Arrays.stream(arr).sum();

        if(sum % 2 == 1) {
            return false;
        }

        Boolean[][] dp = new Boolean[arr.length][(sum / 2) + 1];
        // return canPartitionBT(arr, 0, 0, sum/2);
        // return canPartitionBTMemoization(arr, 0, 0, sum/2, dp);

        return canPartitionBottomUp(arr);
    }

    public static void main(String[] args) {

        Code code = new Code();

        int[] num = {1, 2, 3, 4};
        System.out.println(code.canPartition(num));

        num = new int[]{1, 1, 3, 4, 7};
        System.out.println(code.canPartition(num));

        num = new int[]{2, 3, 4, 6};
        System.out.println(code.canPartition(num));

        num = new int[]{6, 2, 4, 6};
        System.out.println(code.canPartition(num));
    }
}
