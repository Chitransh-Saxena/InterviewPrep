//package com.DSA.InterviewQuestions;
//
//public class Byjus {
//    /*
//
//    import java.io.*;
//import java.util.*;
//
//    class Main {
//        public static void main(String[] args) {
//            ArrayList<String> strings = new ArrayList<String>();
//            strings.add("Hello, World!");
//            strings.add("Running Java " + Runtime.version().feature());
//            for (String string : strings) {
//                System.out.println(string);
//            }
//        }
//    }
//
//
//
//
//
//// a = [12, 3, 4, 8, 10], K = 3
//
//// select k elements from A, such that the sum is maximum
//
//// each time, you can either select 1st or the last elements from the remaining
//
//
//// 12, 3, 4, 8, 10
//
//// 12 - 3, 4, 8, 10
//// 12+10 - 3,4,8
//
//// 12+10+8 - 30
//
//// Output: 30
//
///*
//
//    Backtracking
//
//    [12, 3, 4, 8, 10]
//
//    1 = getSum(1st)
//    removeAnsFromCurrentAnswer;
//    2 = getSum(lastIndex);
//
//    return Math.max(1, 2);
//*/
//
//            0
//                    1       L
//    1       L
//
//    2^N
//
//    TC - O(2^N)
//    SC - Auxiallary Stack Space O(1) + Carrying array in local variable (O(N));
//
///*
//    Backtracking + Memoization
//
//    [12, 3, 4, 8, 10]
//
//    1 = getSum(1st)
//    removeAnsFromCurrentAnswer;
//    2 = getSum(lastIndex);
//
//    // Save the answer, so that it can be looked up in any other recursion tree
//    DP[1st Index][LastIndex] = MAX_SUM_WITHIN_THIS_RANGE
//    Math.max(1, 2);
//
//*/
//
//    public int getAns(int[] arr, int k, int i, int l, int[][] DP, int elTillNow,    int maxSoFar) {
//
//        if(elTillNow == k) {
//
//            DP[i][l] = maxSoFar;
//            return maxSoFar;
//        }
//
//        if(DP[i][l] != -1) {
//            return DP[i][l];
//        }
//
//        int curr = INT_MIN;
//
//
//        if(i < l) {
//
//            int ans1 = arr[i] + getAns(arr, k, i+1, l, DP, elTillNow + 1, maxSoFar);
//            int ans2 = arr[l] + getAns(arr, k, i, l-1, DP, elTillNow + 1, maxSoFar);
//
//            DP[i][l] = Math.max(ans1, ans2);
//            maxSoFar = DP[i][l];
//        }
//        else {
//            // i-l == 1
//        }
//
//
//        return DP[i][l];
//    }
//
//
//
//    public int getMaxWithK(int[] arr, int k) {
//
//        // i = arr.length;
//        // j = arr.length;
//
//        int n = arr.length;
//        int[][] DP = new int[n][n]
//
//        // Fill DP
//
//        return getAns();
//    }
//
//
//
//    DP[i][j] - max possible answer bw i and j   -- (x - no. of elements to be selected )
//    K
//
//
//
//
//
//
//
//
//
//
//
//
//    Inmemory Database application
//1. support for multiple tables
//2. table should have specific schema
//3. Support insert operations
//4. constrants - not null, custom range , etc
//
//
///*
//    -> Database
//        -> Database would be a singleton class here.
//        -> Map for each table and it's instance
//            -> However we map
//        -> Rule definition would be here
//            -> Set in Table
//    -> Table
//        -> Headers (Column titles)
//        -> Columns and rows of data.
//        -> Can choose 2-D Array to store Data
//            -> Insert and Delete would be costly
//            -> Reading would be same as normal RDBMS
//        -> Or we can choose 2-D lists
//            -> But lists comes with it's own overhead.
//            -> But that is the only way, because we need to increase and decrease the size of our tables with insertions and deletions
//        -> Within Table, we can have a function for Rules
//            -> Now this rules function would apply for all the columns of this table and the core data structure
//                -> How to apply that?
//                    -> Before inserting data, go through the rulebook once
//            -> How to store the rules
//                -> Each new rule, could be stored in a map
//                    -> {K, V} = {ColumnNumber, Function()}
//
//    -> About Table
//        -> Each Table instance will be a new table in DB.
//        -> It will be persisted in RAM
//        -> If we want to access it for Select and Insert or any other DML
//            -> I have to make sure that I pass the same instance of table
//        -> So, I need to maintain instances of each table somewhere
//            -> Will use some Map in Database class itself
//
//
//
//    Answer
//
//    1. support for multiple tables
//        -> For each new table, new instance of table
//        -> For existing table modification, use existing table instance
//
//    2. table should have specific schema
//        -> Rule Map, within Table instance.
//
//*/
//
///
//     */
//}
