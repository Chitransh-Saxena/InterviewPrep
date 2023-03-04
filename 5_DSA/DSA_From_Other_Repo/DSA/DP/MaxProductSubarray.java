package com.DSA.DP;

public class MaxProductSubarray {

    // Since the array can have both positive and negative numbers, so we have chance to get greater number when mulitplying -ve and -ve
    /*
        So, there is no sure shot way to figure out what is prod max
        In order to do it, we maintain a map or pair of min and max at each step
        And multiply current number with both to generate new min and max at each step

        Typically, start by getting min and max in iteraiton 0 (default min and max at 0 are 1 and 1)
        Move on to get min and max for other elements

        Point to note, it is longest contiguous subarray
        -> So, at current position if we get some negative in a positive range of nums, it is better to store the max value because we might not get that high number in future
        -> Next thing, at each step the currentMax will be max of (currMax * nums[i], currMin * nums[i] * nums[i])
            -> Because, the current max number can be fetched from mulitplying current number to currentMin (maybe curent number is negative, so -ve and -ve make +ve)
            -> Else, max could add to max
            -> Else, current number itself could be higher then all of the options
                -> Note, we are not mulitplying current number to anything if it wins, because now it must start a new range of numbers with higher product (contigous subarray)
    */

    public int maxProduct(int[] nums) {

        int ans = Integer.MIN_VALUE;


        int currMin = 1;
        int currMax = 1;

        for(int i = 0; i<nums.length; i++) {

            int tmpCurrMax = currMax;

            int localMax = Math.max(nums[i] * currMin, nums[i] * currMax);
            currMax = Math.max(nums[i], localMax);

            int localMin = Math.min(nums[i] * currMin, nums[i] * tmpCurrMax);
            currMin = Math.min(localMin, nums[i]);

            ans = Math.max(currMax, ans);

        }

        return ans;

    }
}
