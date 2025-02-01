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
    public List<Integer> rightSideView(TreeNode root) {
        //Initialize a variable to store result list
        List<Integer> rightSide = new ArrayList<>();

        //Check if root is null
        if(root == null){
            //If so return empty list
            return rightSide;
        }

        //Create a queue to perform level-order traversing
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        //Iterate until the queue is empty
        while(!q.isEmpty()){
            int size = q.size(); //Number of nodes at current level

            for(int i = 0; i < size; i++){
                TreeNode cur = q.poll();//Remove the front element from queue

                //Check if left and right subtree's are not null. If so, add them to queue
                
                if(cur.left != null){
                    q.offer(cur.left);
                }
                if(cur.right != null){
                    q.offer(cur.right);
                }

                if(i == size - 1){
                    rightSide.add(cur.val);
                }
            }
        }
        return rightSide;        
    }
}

//Time Complexity: O(n)
//Space Complexity: O(n)