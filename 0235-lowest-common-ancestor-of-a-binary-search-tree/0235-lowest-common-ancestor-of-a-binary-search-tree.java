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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //Initialize a pointer at root
        TreeNode cur = root;

        //Iterate until cur reaches null
        while(cur != null){
            //Check if p and q nodes values are less than current node's value
            if(p.val < cur.val && q.val < cur.val){
                //If so, LCA could be found in left subtree
                cur = cur.left;
            }//Check if p and q nodes values are greater than current node's value
             else if(p.val > cur.val && q.val > cur.val){
                //If so, LCA could be found in right subtree
                cur = cur.right;
            } else{
                //LCA found
                return cur;
            }
        }
        //return null, if LCA isn't found
        return null;
    }
}

//TIme Complexity: O(n)
//Space Complexity: O(1)