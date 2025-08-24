/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        TreeNode cur = root;
        TreeNode prev = null;   // previous node in inorder
        TreeNode successor = null;

        while (cur != null) {
            if (cur.left == null) {
                // Visit current
                if (prev == p) {
                    successor = cur;
                }
                prev = cur;
                cur = cur.right;
            } else {
                TreeNode pred = cur.left;
                while (pred.right != null && pred.right != cur) {
                    pred = pred.right;
                }

                if (pred.right == null) {
                    // Thread the tree
                    pred.right = cur;
                    cur = cur.left;
                } else {
                    // Restore
                    pred.right = null;

                    // Visit current
                    if (prev == p) {
                        successor = cur;
                    }
                    prev = cur;
                    cur = cur.right;
                }
            }
        }
        return successor;
    }
}
