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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root == null){
            return subRoot == null;
        }

        return isIdentical(root, subRoot) || isSubtree(root.left, subRoot) 
                || isSubtree(root.right, subRoot);
    }

    private boolean isIdentical(TreeNode root, TreeNode subRoot){
        if(root == null || subRoot == null){
            return root == subRoot;
        }

        return (root.val == subRoot.val) && isIdentical(root.left, subRoot.left) && 
            isIdentical(root.right, subRoot.right);
    }
}