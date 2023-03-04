package com.DSA.Trees;

public class LCA {

    private static class TreeNode {

        int data;
        TreeNode left, right;

        TreeNode (int item) {
            data = item;
            left = right = null;
        }

    }

    /*
        Approach
            -> Brute Force
                -> Traverse once to find one element, and note the path
                -> Traverse again to find second element and note the path
                -> Traverse again and find the common ancestor from the two arrays

            -> Internet's approach
                -> Basically do a BFS
                    -> In each step, try to find out if the left or right subtree is returning either of the elements
                        -> To check this, keep track return values of immediate left and right
                            -> If they are any of one of the elements to be found, current node can be a potential ancestor
                                -> If item is found in this subtree, then current node is the ancestor
                            -> If item is not found in this subtree, then current node has to return to it's ancestor with one of the items that it found
                                -> During recursion, the second subtree would be traversed in similar way and if the item is found, we return it back
                                    -> The ancestor which holds both left and right as legit items, is the ancestor.

     */
    public int lca(TreeNode root, int a, int b) {

        return helper(root, a, b).val;

    }

    public TreeNode helper(TreeNode root, int a, int b) {

        if(root == null) {
            return null;
        }

        if(root.val == a || root.val == b) {
            return root;
        }

        TreeNode left = helper(root.left, a, b);
        TreeNode right = helper(root.right, a, b);

        if(left == null) {
            // If left is null, return right no matter what
            return right;
        }

        if(right == null) {
            return left;
        }
        else {
            // This condition means both left and right are not null, this is the case where we found our result.
            return root;
        }
    }
}
