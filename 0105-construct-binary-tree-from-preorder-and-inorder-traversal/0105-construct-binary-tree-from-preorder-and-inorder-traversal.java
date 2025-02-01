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
    //Pointers to track elements from inorder and preorder array's
    int preIndx = 0;
    int inIndx = 0;

    //Use preorder array to construct root nodes and 
    //inorder array to set boundaries for the subtree's
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(preorder, inorder, Integer.MAX_VALUE);
    }

    private TreeNode helper(int[] preorder, int[] inorder, int max){
        if(preIndx >= preorder.length){
            return null;
        }

        //If current element in inorder array matches maximum limit, we are
        //done with constructing the subtree's
        if(inorder[inIndx] == max){
            inIndx++;
            return null;
        }

        TreeNode root = new TreeNode(preorder[preIndx++]);
        //recursively construct left and rightsubtree's
        //left subtrr's limit will be the root node's value, whereas
        //right subtree inherits the limit from the parent node
        root.left = helper(preorder, inorder, root.val);
        root.right = helper(preorder, inorder, max);

        return root;
    }
}

//Time Complexity: O(n)
//Space Complexity: O(n)