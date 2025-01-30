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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        //Check if any of the tree holds null value
        //If so both needs to null for being identical
        if(p == null || q == null){
            return p == q;
        }

        //Check if current node's values matches for both the trees and
        //recursively check if both the tree's have identical left and right subtree's
        return (p.val == q.val) && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}

//Time Complexity: O(n)
//Space Complexity: O(n)