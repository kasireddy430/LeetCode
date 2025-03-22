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

    private int matchingCount = 0;

    public int averageOfSubtree(TreeNode root) {
        subTreeAverage(root);
        return matchingCount;
    }

    private int[] subTreeAverage(TreeNode root){
        if(root == null){
            return new int[]{0, 0};
        }

        int[] leftSubTree = subTreeAverage(root.left);
        int[] rightSubTree = subTreeAverage(root.right);

        int subTreeSum = leftSubTree[0] + rightSubTree[0] + root.val;
        int subTreeNodes = leftSubTree[1] + rightSubTree[1] + 1;

        if(root.val == subTreeSum/subTreeNodes){
            matchingCount++;
        }

        return new int[]{subTreeSum, subTreeNodes};
    }
}

//Time Complexity: O(n)
//Space Complexity: O(n)