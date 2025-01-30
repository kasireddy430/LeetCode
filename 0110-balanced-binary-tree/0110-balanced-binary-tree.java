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
    public boolean isBalanced(TreeNode root) {
        //Base case: return null if root node is null
        if(root == null){
            return true;
        }

        //return false if tree doesn't follow binary tree constraints
        if(height(root) == -1){
            return false;
        }

        return true;
    }

    private int height(TreeNode root){
        if(root == null){
            return 0;
        }

        //Recursively calculate the heights of left and right sub tree's of current node
        int leftTree = height(root.left);
        int rightTree = height(root.right);

        //return -1, if any of subtree's doesn't follow balanced binary tree constraints
        if(leftTree == -1 || rightTree == -1){
            return -1;
        }

        //return -1 if difference in sub tree's depth is greater than 1
        //balanced binary tree should have depth's of subtree's not more than 1.
        if(Math.abs(leftTree - rightTree) > 1){
            return -1;
        }

        //return the maximum depth at the cuurent.(1 is for including the current node)
        return Math.max(leftTree, rightTree) + 1;
    }
}

//Time Complexity: O(n)
//Space Complexity: O(n)