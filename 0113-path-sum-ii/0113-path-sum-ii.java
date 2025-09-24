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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> subList = new ArrayList<>();

        dfs(root, targetSum, subList, res);
        return res;
    }

    private void dfs(TreeNode root, int targetSum, List<Integer> subList, 
                    List<List<Integer>> res){

        if(root == null){
            return;
        }

        subList.add(root.val);

        if(root.left == null && root.right == null && targetSum - root.val == 0){
            res.add(new ArrayList<>(subList));
        }

        dfs(root.left, targetSum - root.val, subList, res);
        dfs(root.right, targetSum - root.val, subList, res);

        subList.remove(subList.size() - 1);
    }
}