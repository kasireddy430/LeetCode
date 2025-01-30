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
    public int maxDepth(TreeNode root) {
        //Base case: return null if the current node is null
        if(root == null){
            return 0;
        }

        //Recursively calculate the height of left and right sub tree's
        int leftTree = maxDepth(root.left);
        int rightTree = maxDepth(root.right);

        //return maximum height at the current node + 1(for the current node)
        return Math.max(leftTree, rightTree) + 1;
    }
}

//Time Complexity: O(n)
//Space Complexity: O(n). caused by the recursion stack