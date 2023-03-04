package com.DSA.DP.StartingFromBasics.CountOfSubsetSum_4;

public class CountOfSubsetSum {

    /*
        Problem
            -> Given an array of numbers, find total number of subsets whose sum equal to 'k'

        Approach
            -> Brute Force
                -> NOTE: Brute force was a little hard to think, because instead of creating set, we have to think it in terms of keeping track of sum of subsets
                -> Doing it with just two conditions where we choose and not choose a number was a little tricky to think of.
                -> Recursive Approach
                    -> We need to create subset of each combination where sum = k
                    -> We need not create actual HashSet for this approach, we can keep track of sum and can still get it done
                    -> We can start from 0th index and sum = k only
                        -> In the process where we select and not select the element, if we are selecting, we can subtract currentNumber from totalSum
                            -> Once it reaches 0, it means we have attained 1 subset where totalSum = k
                        -> Before subtracting, we need to do a basic check if our number is smaller or not, else it will give a negative value
                    -> Time Complexity
                        -> O(2^N) because it is a two branched recursion
                    -> Space Complexity
                        -> O(N) for the array in recursive stack space

            -> Recursion + Memoization (Top Down DP)
                -> We have overlapping sub-problems
                    -> Sub-problems which repeat under different recursive trees are overlapping sub-problems
                    -> If we store their results in some sort of data structure, we need not do the processing for them and thus save some time.
                -> Changing factors in recursion above?
                    -> currIndex
                    -> sum
                -> Thus, we create a matrix to store all the values of currIndex against all sum
                    -> So, for arr length 4, k = 5, we create 2-D array to store for currIndex 0 -> 3 and sum = 1->5

                -> Time Complexity
                    -> O(N*S) -> This is the number of decisions which this is going to take
                -> Space Complexity
                    -> O(N) for the array in recursive stack space

            -> Bottom Up DP
                -> Since we have overlapping sub-problems, we did memoization to improve our time
                -> If we can populate the DP matrix from bottom to top, for every value from 0-> arr.length and 1 -> sum
                    -> Then, we can solve the problem in even lesser time
                -> In above approach, we took sum = k and subtracted it down to 0
                    -> Here, we are not going to do that
                    -> We build the solution to store data in DP matrix in such a way, that for some certain index, certain value of sum
                        -> How many subsets we have, we store that.

                -> In subset sum problem, we had to check that, at any step, do we get the required subset or not
                    -> If yes, we stop the counting then and there, and return true
                -> In this case, we cannot stop at any point we get our answer, we have to keep counting
                    -> So, the update we do to our code is, we replace || with '+' in our core logic of dp[i][j] = dp[i-1][j] || dp[i-1][j-arr[i]];

    */

    public static void main(String[] args) {


        CountOfSubsetSum ss = new CountOfSubsetSum();
        int[] num = {1, 1, 2, 3};
        System.out.println(ss.countSubsets(num, 4));
        num = new int[]{1, 2, 7, 1, 5};
        System.out.println(ss.countSubsets(num, 9));
    }

    private int countSubsets(int[] arr, int sum) {

        Integer[][] dp = new Integer[arr.length][sum+1];

        // return this.countSubsetsRecursive(arr, sum, 0);
        // return this.countSubsetsRecursiveMemoization(arr, sum, 0, dp);
        return this.countSubsetDP(arr, sum);
    }

    private int countSubsetsRecursive(int[] arr, int sum, int currIndex) {

        // Base condition, if currSum is 0, it means we got one subset where subsetSum = sum
        if(sum == 0) {
            return 1;
        }

        if(currIndex >= arr.length || arr.length == 0) {
            return 0;
        }

        // When we are including the number, we need to check if it is smaller than currSum or not
        int sum1 = 0;
        if(arr[currIndex] <= sum) {
            sum1 = countSubsetsRecursive(arr, sum - arr[currIndex], currIndex + 1);
        }

        int sum2 = countSubsetsRecursive(arr, sum, currIndex+1);

        return sum1 + sum2;

    }

    private int countSubsetsRecursiveMemoization(int[] arr, int sum, int currIndex, Integer[][] dp) {

        // Base condition, if currSum is 0, it means we got one subset where subsetSum = sum
        if(sum == 0) {
            return 1;
        }

        if(currIndex >= arr.length || arr.length == 0) {
            return 0;
        }

        if(dp[currIndex][sum] != null) {
            return dp[currIndex][sum];
        }

        // When we are including the number, we need to check if it is smaller than currSum or not
        int sum1 = 0;
        if(arr[currIndex] <= sum) {
            sum1 = countSubsetsRecursiveMemoization(arr, sum - arr[currIndex], currIndex + 1, dp);
        }

        int sum2 = countSubsetsRecursiveMemoization(arr, sum, currIndex+1, dp);

        dp[currIndex][sum] = sum1 + sum2;
        return sum1 + sum2;

    }

    private int countSubsetDP(int[] arr, int sum) {

        int[][] dp = new int[arr.length][sum + 1];

        // Initial states - All indices of array, currSum = 0
        for(int i = 0; i<arr.length; i++) {
            dp[i][0] = 1;
        }

        // Initial State - Only first item of array, all sums from 1 -> sum
        for(int i = 1; i<=sum; i++) {
            dp[0][i] = (arr[0] == i) ? 1 : 0;
        }

        for(int currIndex = 1; currIndex < arr.length; currIndex++) {
            for(int currSum = 1; currSum <= sum; currSum++) {

                if(arr[currIndex] <= currSum) {     // Include current number
                    dp[currIndex][currSum] = dp[currIndex - 1][currSum] + dp[currIndex - 1][currSum - arr[currIndex]];
                }
                else {
                    dp[currIndex][currSum] = dp[currIndex - 1][currSum];
                }
            }
        }

        return dp[arr.length - 1][sum];
    }
}
