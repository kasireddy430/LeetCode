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
    public TreeNode invertTree(TreeNode root) {
        //Check if root is null
        if(root == null){
            return null;
        }

        //Create a new treeNode with the same as the current node's value
        TreeNode invert = new TreeNode(root.val);

        invert.left = invertTree(root.right);
        invert.right = invertTree(root.left);

        return invert;
    }
}

//Time Complexity: O(n).
//Space Complexity: O(n). where n is total no.of nodes