/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    //Create a global variable to track good nodes in the tree
    int count = 0;

    public int goodNodes(TreeNode root) {
        helper(root, root.val);
        return count;
    }

    //helper method to count good nodes
    private void helper(TreeNode root, int max){
        if(root == null){
            return;
        }

        //Check if current node's value is greater than max value
        if(root.val >= max){
            //If so update the max value and increment the count
            max = root.val;
            count++;
        }

        //Recursively count good nodes in left and right subtree's
        helper(root.left, max);
        helper(root.right, max);
    }
}

//Time Complexity: O(n)
//Space Complexity: O(n) .Worst case scenario where the tree is skewed