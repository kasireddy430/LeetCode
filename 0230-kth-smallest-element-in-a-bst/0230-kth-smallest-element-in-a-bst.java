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
    //Perform Morris In-order traversal for finding the kth smallest element
    public int kthSmallest(TreeNode root, int k) {
        TreeNode cur = root;
        while(cur != null){
            if(cur.left == null){
                k--;
                if(k == 0) return cur.val;
                cur = cur.right;
            } else{
                TreeNode predecessor = cur.left;

                while(predecessor.right != null && predecessor.right != cur){
                    predecessor = predecessor.right;
                }

                if(predecessor.right == null){
                    predecessor.right = cur;
                    cur = cur.left;
                } else{
                    predecessor.right = null;
                    k--;
                    if(k == 0) return cur.val;
                    cur = cur.right;
                }
            }
        }

        return -1;
    }
}

//Time Complexity: O(n)
//Space Complexity: O(1)