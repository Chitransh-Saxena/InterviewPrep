package com.DSA.DP.StartingFromBasics.KnapsackProblem_000;

public class Code {

    /*
        Problem
            -> Given is a list of items, another list with weights of those items, and another list of profit of those items, and finally a knapsack of a certain wight
            -> Find the maximum profit that can be earned by using full capacity of knapsack

            -> Example:
                items - {apple, orange, banana, melon}
                weights - {2, 3, 1, 4}
                profits - {4, 5, 3, 7}
                Capacity - 5

            -> Combinations for weight 5 or less
                -> apple + orange = 5 (profit = 9)
                -> orange + banana = 4 (profit = 8)
                -> banana + melon = 5 (profit = 10)

            -> Max profit for weight <= 5, is 10


        Approach
            -> One could be a recursive greedy approach
                -> Iterate all the possible combinations and store the maximum profit that we can get
                -> Compare with max each time
            -> We cannot write the iterative approach here, because we are not sure how many items we might need to choose
                -> better approach would be to use a recursive traversal, and have a base case of capacity check

                -> Recursive Approach
                    -> Just like a brute force iteration, it will be a brute force recursion
                    -> We iterate at each index in a recursive way
                        -> We either pick the current element, or do not pick the current element
                        -> We calculate profit under both of these conditions

                    -> Time Complexity Here
                        -> O(2^n)
                            -> Recursion Tree of 2 choices
                    -> Space Complexity
                        -> O(N)
                            -> Recursive stack space

            -> How do we generate DP solution from above solution?
                -> From the recursion tree, if drawn with pen on paper, we will see there are some calculations which we might be repeating
                -> Also, current solution is being built from existing sub-problem's solution
                    -> We apply memoization

            -> Top Down DP with Memoization
                -> Overlapping sub-problems - Memoization
                -> We have two changing variables in our recursive approach
                    -> currentIndex and capacity
                    -> Therefore, we will use a 2-D matrix to store the results of our sub-problems.
                        -> Why like this?
                            -> We want to store the result for every possible capacity and currentIndex
                -> Time Complexity
                    -> How many sub-problems can we have?
                        -> N items * C capacity
                        -> This is also the manner in which we are storing sub-problem's answers
                    -> TC = O(N * C)
                -> Space Complexity
                    -> O(N*C) + O(N) for recursion

            -> Bottom Up DP (Tabulization)
                -> We populate our DP table in such a way, that for any index 'i' and certain capacity  'c', DP[i][c] will return maximum profit
                    -> For first 'i' items, capacity 'c'
                -> How do we populate this table?
                    -> As saw in recursion, at any point, we have two choices, either pick the current element, or not pick it.
                    -> In case of tabulization, if we do not pick an element
                        -> profit in this case will be = dp[i-1][c]
                            -> Previous index (because current index was not picked), existing capacity (since no item picked, capacity not modified)
                    -> If we pick the element
                        -> profit = profit[i] + dp[i-1][c-weights[i]];

                    -> Max of above two conditions will be our answer
                -> TC = O(N * C)
                -> SC = O(N * C)

    */

    public int solveKnapsackBacktracking(int[] profits, int[] weights, int capacity, int currIndex) {

        if(capacity <= 0 || currIndex >= profits.length) {
            return 0;
        }

        int profitWithItem = 0;
        if(weights[currIndex] <= capacity) {
            profitWithItem = profits[currIndex] + solveKnapsackBacktracking(profits, weights, capacity - weights[currIndex], currIndex + 1);
        }

        int profitWithoutItem = solveKnapsackBacktracking(profits, weights, capacity, currIndex+1);

        return Math.max(profitWithoutItem, profitWithItem);

    }

    public int solveKnapsackMemoization(int[] profits, int[] weights, int capacity, int currIndex, Integer[][] dp) {

        if(dp[currIndex][capacity] != null) {
            return dp[currIndex][capacity];
        }

        if(capacity <= 0 || currIndex >= profits.length) {
            return 0;
        }

        int profitWithItem = 0;
        if(weights[currIndex] <= capacity) {
            profitWithItem = profits[currIndex] + solveKnapsackBacktracking(profits, weights, capacity - weights[currIndex], currIndex + 1);
        }

        int profitWithoutItem = solveKnapsackBacktracking(profits, weights, capacity, currIndex+1);

        int ans = Math.max(profitWithoutItem, profitWithItem);
        dp[currIndex][capacity] = ans;
        return ans;

    }

    public int solveKnapsack (int[] profits, int[] weights, int capacity) {

        // return solveKnapsackBacktracking(profits, weights, capacity, 0);

//        Integer[][] dp = new Integer[profits.length][capacity + 1];
//        return solveKnapsackMemoization(profits, weights, capacity, 0, dp);


        if(capacity <= 0 || profits.length == 0 || weights.length != profits.length) {
            return 0;
        }

        int n = profits.length;
        int[][] dp = new int[n][capacity+1];        // capacity+1 because our calculation will include c == capacity, and not c < capacity

        // When capacity = 0, no profit can be earned. So, that column of capacity = 0, will be filled with 0.
        for(int i = 0; i<n; i++) {
            dp[i][0] = 0;
        }

        // This is a corner case, if there is only one weight, we handle it now.

        for(int c = 0; c<=capacity; c++) {
            if(weights[0] <= c) {
                dp[0][c] = profits[0];
            }
        }

        // First row and first column has been handled separately, now work on remaining angles

        for(int i = 1; i<n; i++) {
            for(int c = 1; c<= capacity; c++) {

                int profitWithoutCurrentItem = dp[i-1][c];
                int profitWithCurrentItem = 0;
                if(weights[i] < c) {
                    profitWithCurrentItem = profits[i] + dp[i-1][c - weights[i]];
                }

                dp[i][c] = Math.max(profitWithoutCurrentItem, profitWithCurrentItem);
            }
        }

        return dp[n-1][capacity];
    }

    public static void main(String[] args) {

        Code ks = new Code();
        int[] profits = {1, 6, 10, 16};
        int[] weights = {1, 2, 3, 5};

        int maxProfit = ks.solveKnapsack(profits, weights, 7);
        System.out.println("Total knapsack profit ---> " + maxProfit);
        maxProfit = ks.solveKnapsack(profits, weights, 6);
        System.out.println("Total knapsack profit ---> " + maxProfit);
    }
}
