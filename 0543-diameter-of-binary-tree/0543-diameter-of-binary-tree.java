public class Solution {

    //Create a global variable to find the diameter of the tree
    int diameter;

    public int diameterOfBinaryTree(TreeNode root) {
        diameter = 0;
        height(root);
        return diameter;
    }

    //helper function to recursively calculate the height of the tree
    private int height(TreeNode root){
        //Base case: return 0 if the node is null
        if(root == null){
            return 0;
        }

        //Recursively calculate the height of left and right subtree's
        int leftTree = height(root.left);
        int rightTree = height(root.right);

        //Diameter at the current node is the sum of left and right subtree's
        int localDiameter = leftTree + rightTree;

        //Update the diameter if current node's diameter is bigger
        diameter = Math.max(diameter, localDiameter);

        return Math.max(leftTree, rightTree) + 1;
    }
}

//Time Complexity: O(n)
//Space Complexity: O(n)