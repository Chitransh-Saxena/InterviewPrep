package com.DSA.DP;

public class HouseRobber {

    // Finally, our answer will make a recursion subtree from initial 2 choices
    // Pick 1 or pick 2

    public int getAns(int[] nums, int pos, int[] check) {

        // From this function, I will return what will be the subtree returning as an answer for robbing

        if(pos >= nums.length) {
            // No more houses left to rob
            return 0;
        }

        if(pos == nums.length - 1)  {

            // If we have reached the last element, return the value from this house
            // No need to return max from here itself, it would be added in the recursion

            return nums[pos];
        }

        if(check[pos] != -1)    return check[pos];


        int choice1;
        int choice2;
        if(pos < nums.length) {

            // Pick current house
            choice1 = nums[pos] + getAns(nums, pos+2, check);
            choice2 = getAns(nums, pos+1, check);

            check[pos] = Math.max(choice1, choice2);
        }

        return check[pos];
    }


    public int rob(int[] nums) {

        int[] check = new int[nums.length];
        for(int i = 0; i<nums.length; i++)  check[i] = -1;
        return getAns(nums, 0, check);
    }
}
