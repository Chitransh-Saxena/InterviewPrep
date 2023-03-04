package com.DSA.DSA.Facebook;

public class FriendCircles {

    /*
        -> Individual friend circle is group of people who are directly or indirectly your friends
        -> If A is direct friend of B, and B is direct friend of C, then A is indirect friend of C

        -> Given
            -> n*n matrix where n is the total number of people on facebook
            -> i, j will hold the value 1, is i and j are friends

        -> To Find
            -> Number of friend circles
            -> This is pretty much similar to number of islands problem on leetcode


        -> Approach
            -> All the friends, direct or Indirect and part of one connected component
            -> So, here we are finding number of components to be precise
                -> Number of connected components will give us number of friend circles

            -> Start iterating first 1 (first friend connection)
                -> Check when does this cycle of friendship end
                -> That marks the end of one friend circle
                -> This can be implemented via doing a DFS when we encounter our first 1

    */

    public static void main(String[] args) {

        int n = 4;
        int[][] friends = {
                {1,1,0,0},
                {1,1,1,0},
                {0,0,1,0},
                {0,0,0,1}
        };

        System.out.println("Number of friends circles: " + friendCircles(friends, n));
    }

    public static int friendCircles(int[][] friends, int n) {

        int ans = 0;

        for(int i = 0; i<n; i++) {
            for(int j = 0; j<n; j++) {

                if(friends[i][j] == 1) {
                    traverseFriendCircle(friends, i, j, n);
                    ans+=1;
                }
            }
        }

        return ans;
    }

    public static void traverseFriendCircle(int[][] friends, int i, int j, int n) {

        // Basic Boundary Check
        if(i < 0 || i>n-1 || j<0 || j>n-1) {
            return;
        }


        if(friends[i][j] == 0) {
            return;
        }


        System.out.println("Val here is " + friends[i][j]);
        friends[i][j] = 0;

        traverseFriendCircle(friends, i, j+1, n);
        traverseFriendCircle(friends, i, j-1, n);
        traverseFriendCircle(friends, i-1, j, n);
        traverseFriendCircle(friends, i+1, j, n);


    }
}
