package com.DSA.DP.StartingFromBasics.RecurringNumbers;

public class NumberFactors {

    /*
        Problem
            -> Given an array of numbers nums and an integer n, find the number of ways to sum 'n
            ' with the numbers present in the array

            -> Example: nums= [1, 3, 4] and n = 4
                -> 1 + 1 + 1 + 1 = 4
                -> 1 + 3 = 4
                -> 3 + 1 = 4
                -> 4 = 4

            -> Ans = 4


        Approach
            -> Naive Approach
                -> Recursively traverse the array, in each step, pick and not pick an element
                    -> Each time a sum is reached, store it in an list
                -> Return the size of this list

                -> TC:
                    -> Since, in recursion we are picking and not picking at each step
                        -> 2^N (N = size of array and not target integer n)
                    -> Space complexity
                        -> To store all the possible solutions
                        -> O(N*N)

            -> Optimization
                -> I know this is a DP topic, but I am not able to intuitively come up with something
                    -> Although, recursion is used here, so there is a chance of overlapping sub problem

                -> Search for DP properties in this case
                    -> Optimal Substructure - If a current solution can be developed with some other solution of existing sub-problem
                        -> This part is not much intuitive, but I guess this is what I need to practise
                        -> So, giving this fact a brute force entry to my brain.

                        -> Looking carefully at the problem
                            -> If F(K) = number of ways to get sum k, with all the items of the array
                                -> Then, following holds true
                                    -> Say, there are n different elements in the array, let's call them k=n1, k2 ... nn
                                    -> Consider there are 3 elements in the array - [1, 3, 4] and k = 4
                                    -> Now, F(k=4) is supposed to be the answer as discussed above
                                    -> F(k-1) (subtracting first element of the array from k) =
                                        -> Number of ways to reach (k - 1st element of array)
                                        -> F(4-1 = 3) = { (1 + 1 + 1), (3)} = 2
                                            -> This formulation is true but not very intuitive at first
                                    -> Doing above formulation for all the elements, we will get
                                        -> F(k = 4) = F(k-1) + F(k-3) + F(k-4)
                                                    = 4 (Answer)
                            -> So, yes, this problem follows the optimal sub structure property
                                -> Therefore, there might be some way to use Bottom-Up DP approach to solve this problem

                    -> Overlapping sub problem
                        -> If we follow the basic recursive approach
                            -> The recursion tree for each number will formed, and at some point it will be repeated
                                -> Check with pen-paper approach
                            -> Therefore, this problem can be optimised with some basic optimisation with Top-Down Approach

    */
}
