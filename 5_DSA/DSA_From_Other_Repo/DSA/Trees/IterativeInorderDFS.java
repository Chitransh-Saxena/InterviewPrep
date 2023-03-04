package com.DSA.Trees;

public class IterativeInorderDFS {


    /*

        public void helper(TreeNode root){

        if(root == null)
            return;

        helper(root.left);
        ans.add(root.val);
        helper(root.right);
    }

        In recursive DFS solution
            -> We usually do a left root right in the subtree
            -> We return when anything is null
                -> And when that happens, we usually put that item as either left, or right or root.
            -> Till the recursion tree returns, the items are stored in auxiliary stack space.
                -> So, in iterative solution we need to create our own stack and use it to backtrack elements.

            -> Just like DFS, start by iterating the left subtree and then root and then right subtree
                -> So, in each iteration we should traverse the farthest of the left subtree until we get some subtree with left root and right
                -> Same goes for right subtree

                -> We traverse from root, enter the items in the stack until we find some null nodes (hit the leaf node and try to go left to a null node)
                    -> Now we have hit a left leaf node
                    -> We add it to answer array
                    -> Now, if left is done, it's parent is next item in array
                        -> So, we condition the code in such a way, that the moment we find a null node, we handle add left to ans node
                        -> And make previous node as current node (pop from stack)
                    -> Now, once left is found, we start search for right in this subtree
                        -> Make current node as right node of current node
                         -> currentNode = currentNode.right;


              -> Time Complexity
                -> O(N) because it is just a traversal
              -> Space Complexity
                -> O(N) because we are using extra stack space
    */

    public List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        TreeNode node = root;

        while(true) {

            if(node == null) {
                if(stack.isEmpty()) {
                    break;

                    // Because stack has been traversed fully, root node has been considered
                }

                node  = stack.pop();    // We backtrack to previous value of node, and consider this as a child
                ans.add(node.val);
                // Since we got the left child first, now we search for the right child
                node = node.right;
            }
            else {

                stack.push(node);
                node = node.left;
            }
        }

        return ans;
    }
}
