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

    //Create a global variable to calculate the maximum path sum in the entire tree
    int globalMaximum;

    public int maxPathSum(TreeNode root) {
        globalMaximum = Integer.MIN_VALUE;
        helper(root);
        return globalMaximum;
    }

    //helper method to find maximum path sum
    private int helper(TreeNode root){
        if(root == null){
            return 0;
        }

        //Recursively calculate left and right subtree's path sum
        int leftTreeMax = helper(root.left);
        int rightTreeMax = helper(root.right);

        //Discard negative contributions
        leftTreeMax = Math.max(leftTreeMax, 0);
        rightTreeMax = Math.max(rightTreeMax, 0);

        //calclate path maximum path sum at the current node.
        int localMaximum = leftTreeMax + rightTreeMax + root.val;
        //update the maximum pathSum if localPath sum is greater
        globalMaximum = Math.max(globalMaximum, localMaximum);

        //return maximum pathSum at the current node
        //We can include only one of the subTree's
        return Math.max(leftTreeMax, rightTreeMax) + root.val;
    }
}

//Time Complexity: O(n)
//Space Complexity: O(n)