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
        //Initialize cur pointer at root node
        TreeNode cur = root;

        //Iterate until cur reaches null
        while(cur != null){
            //Check if left subtree doesn't exist
            if(cur.left == null){
                //If so we visit the current node and move to right subTree
                k--;
                if(k==0)
                    return cur.val;
                cur  = cur.right;
            } else {
                //If not identify the predecessor(rightmost node in left subtree)
                TreeNode predecessor = cur.left;

                while(predecessor.right != null &&predecessor.right != cur){
                    predecessor = predecessor.right;
                }

                //Check if predecessor doesn't have a right child
                if(predecessor.right == null){
                    //If so, create a temporary thread to the cur node from predecessor and move 
                    //from current node to left child
                    predecessor.right = cur;
                    cur = cur.left;
                } else{
                    //If not, remove the temporary thread and visit current node and
                    //move from current node to the right child
                    predecessor.right = null;
                    k--;
                    if(k==0)
                        return cur.val;
                    cur = cur.right;
                }
            }
        }
        //return -1, if kth smallest element isn't found
        return -1;
    }
}

//Time Complexity: O(n)
//Space Complexity: O(1)