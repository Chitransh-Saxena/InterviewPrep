package com.DSA.Trees;

import org.w3c.dom.Node;

public class RecursiveLevelOrderTraversal {

    /*
    On each level, two times recursion call is done
    So, the search space will grow in size like this
    1
    2
    4
    8
    16
    2^h
    Where h is height of the tree
    So, the total recursion calls would be 2^0 + 2^1 + ... + 2^n-1
    This is sum of GP
    Approx = 2^n+2

    -> When time complexity comes like 2^n or 3^n, we call it exponential time complexity
    -> Total function calls = 2^(n+2)
    -> O(NLog2)

     */
    public int getHeightOfTree(TreeNode root) {

        if(root == null) {
            return 1;       // O(1)
        }

        int left = getHeightOfTree(root.left);
        int right = getHeightOfTree(root.right);

        return Math.max(left, right) + 1; // O(1)
    }

    public List<Integer> doLevelOrder(TreeNode root, int level, List<Integer> list) {

        if(root == null) {
            return null;
        }

        if(level == 1) {
            list.add(root.val);
        }

        doLevelOrder(root.left, level-1, list);
        doLevelOrder(root.right, level-1, list);

        return list;
    }


    public List<List<Integer>> levelOrder(TreeNode root) {

        int heightOfTree = getHeightOfTree(root);   // O(logh)


        List<List<Integer>> ans  = new ArrayList<List<Integer>>(); // O(N^2) space, but it is requirement so not counter
        for(int i = 0; i<heightOfTree; i++) {

            // Consider root at level 0
            // So, we start from traversing next level
            // At each level, we send the root node and the level we want to traverse
            // So, we are doing a recursion from root to given level each time
            List<Integer> levelItems = new ArrayList<>();
            levelItems = doLevelOrder(root, i+1, levelItems); // O(logh)

            if(levelItems != null && !levelItems.isEmpty()) {
                ans.add(levelItems);
            }
        }

        return ans;

    }
}
