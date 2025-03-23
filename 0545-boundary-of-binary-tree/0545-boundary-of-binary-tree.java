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
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        /// flag to know we are going to left boundary or right boundary,
        /// left from top to bottom
        /// leaves from left to right
        // right from bottom to top
        /// DFS
        if (root == null) return new ArrayList<>();

        List<Integer> result = new ArrayList<>();
        result.add(root.val);
        if (root.left == null && root.right == null) {
            return result;
        }
        leftBoundary(root.left, result);
        leaves(root, result);
        rightBoundary(root.right, result);
        return result;
    }

    private void leftBoundary(TreeNode root, List<Integer> result) {
        if (root == null || root.left == null && root.right == null) return;
        result.add(root.val);
        if (root.left != null) leftBoundary(root.left, result);
        else leftBoundary(root.right, result);
    }

    private void rightBoundary(TreeNode root, List<Integer> result) {
        if (root == null || root.left == null && root.right == null) return;
        if (root.right != null) rightBoundary(root.right, result);
        else rightBoundary(root.left, result);
        result.add(root.val);
    }

    private void leaves(TreeNode root, List<Integer> result) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            result.add(root.val);
            return;
        }
        leaves(root.left, result);
        leaves(root.right, result);
    }
}