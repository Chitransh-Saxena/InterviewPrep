package com.DSA.Heap;

public class Intro_0 {

    /*

        Heap is a complete binary tree which follows the rule of max or min heap.
        A complete binary tree is a tree which has 2 children till leaf node. Leaf node can have less than 2 children, but should be filled from left to right

        Max heap
            -> Child is smaller than parent
            -> Top most item (root) is of the highest priority

        Min Heap - Entirely opposite of above

        Heap is denoted using an array while performing operations.
            -> So, when the question is given, we are given heap in form of array and not some binary tree with some nodes.

        If n nodes are there and it is complete binary tree, the HEIGHT of tree would be logN

        While forming an array, it is formed in such a way
            -> if an element is placed at index i
                -> Then it's left child would be placed at index - 2i and right would be placed at 2i+1
                -> Parent would be at |i/2|

        Above property works for heap data structure. So, if we do a level order traversal of the heap tree, store it in array, it would follow above properties


        How to insert a new node in Heap Binary Tree?
        -> Since, after adding the new element, we still want it to be complete binary tree, we cannot start comparing from top and add
            -> In that case, it won't be complete binary tree
            -> We need to start comparing from the bottom of the tree.
        -> So, if we are starting from bottom, we will try to fill in the left most spot.
            -> If the tree is complete, then new node will be left child of the left most node of last level.
            -> Now that we have inserted the element, we will start comparing the element with parent and check if the property of heap is satisfied
                -> If not, we swap elements and do comparison till root level.


     */


    public void insertInHeap(int[] maxHeap, int n, int item) {

        
    }
}
