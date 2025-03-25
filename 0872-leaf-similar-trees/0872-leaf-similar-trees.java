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
public class Solution {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> leafNodes1 = new ArrayList<>();
        List<Integer> leafNodes2 = new ArrayList<>();

        calculateLeafNodes(root1, leafNodes1);
        calculateLeafNodes(root2, leafNodes2);

        return leafNodes1.equals(leafNodes2);
    }

    private void calculateLeafNodes(TreeNode root, List<Integer> leafNodes){
        if(root == null){
            return;
        }

        if(root.left == null && root.right == null){
            leafNodes.add(root.val);
            return;
        }

        calculateLeafNodes(root.left, leafNodes);
        calculateLeafNodes(root.right, leafNodes);
    }
}


//Time Complexity: O(N). where is total number of nodes in both tree's
//Space Complexity: O(N) worst case for skewed tree's 