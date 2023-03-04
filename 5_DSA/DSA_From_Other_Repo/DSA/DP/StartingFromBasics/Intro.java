package com.DSA.DP.StartingFromBasics;

public class Intro {

    /*

        Safety Netting
            -> What are we talking about?
                -> Dynamic Programming
                    -> It is an algorithm that produces result of some certain problem, by combining results of previous sub problems
                        -> It is up to us to generate and store those sub problems, and then combine them in the right manner to form the final result.

                    -> Characteristics
                        -> Overlapping sub problems
                            -> Sub problems are not independent. 2 sub problems share a common problem
                        -> Optimal sub-structure property
                            -> Overall optimal solution can be formed from the optimal sub-structure of it's sub-problems
            -> Why is this important?
                -> It improves the efficiency of our algorithms
                    -> This further improves the resources used (CPU) in solving a business logic.
                    -> Also, these days everything is run on cloud, and we are spending money there, so getting things done faster is a priority
                -> But this improve in speed comes at a cost of modest increase in space usage
                    -> If you already know DP, we use DP tables to store result of sub-problems which can be further used to get the final solution

             -> How important is this?
                -> Since the importance of this is pretty good, because of the speed efficiency and the skill it takes to understand this algorithm, this skill is sort of rare
                -> Companies where the product is run on some good algorithm where quick thinking and good coding is involved
                    -> They ask DP in interviews
                    -> If DP has been cracked, interviews are pretty much cracked, that's good money
            -> What can I do when I have this information?
                -> It will not be much used in companies, that's for sure
                -> But, the problem solving ability which this will develop is definitely gonna help in day to day work
            -> What can not be done with this information
                -> This is one algorithm for a certain areas of problems
                    -> It can definitely not solve what sorting, searching and other requirements need
            -> Where to get good knowledge on this?
                -> Educative.io
                -> Interviewbit
                -> Leetcode is good, but premium might be required, otherwise problems are just scattered




        Core Basics
            -> Memoization
                -> If there is a chance that the sub-problem will finally produce the final outcome, we store the results of sub-problems in some sort of data structure
                -> This can be used to produce final output
                -> This approach is called memoization
                -> Example:
                    -> In backtracking, there are cases where the combination of problem and it's factors is repeating in the recursion tree
                        -> In such cases, we store the results in some sort of map or something
                        -> This reduces the time to process the sub-problem, and code can run for part which it did not run before

    */
}
