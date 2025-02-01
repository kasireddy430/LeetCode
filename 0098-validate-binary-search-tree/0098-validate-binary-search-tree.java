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
    public boolean isValidBST(TreeNode root) {
        return isValid(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    //helper function to validate BST
    private boolean isValid(TreeNode root, long min, long max){
        if(root == null){
            return true;
        }

        //check for BST constraints for the current node and 
        //recursively check left and right subtree's for valid BST
        return (root.val > min && root.val < max) 
                && isValid(root.left, min, root.val) 
                && isValid(root.right, root.val, max);
    }
}

//Time Complexity: O(n)
//Space Complexity: O(n)