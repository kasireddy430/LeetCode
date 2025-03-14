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
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        //If root is null, return empty list
        if(root == null){
            return result;
        }

        //Map to store list of node's value's with their column index as key
        Map<Integer, List> columnTable  = new HashMap<>();

        //Queue for BFS traversal
        //It holds pairs of nodes and their indices
        Queue<Pair<TreeNode, Integer>> q = new LinkedList<>();
        //Enqueue rootnode with 0 as column index
        q.offer(new Pair(root, 0));
        int minColumn = Integer.MAX_VALUE, maxColumn = Integer.MIN_VALUE;

        //Iterate until queue becomes empty
        while(!q.isEmpty()){
            //Dequeue from queue
            Pair<TreeNode, Integer> p = q.poll();

            int column = p.getValue();
            root = p.getKey();

            if(root != null){
                //If current node's index is not part of map, add an entry
                if(!columnTable.containsKey(column)){
                    columnTable.put(column, new ArrayList<>());
                }

                //Update column table with node's values
                columnTable.get(column).add(root.val);

                //Update column range
                minColumn = Math.min(minColumn, column);
                maxColumn = Math.max(maxColumn, column);

                //Add child node along with updated column indices
                q.offer(new Pair(root.left, column - 1));
                q.offer(new Pair(root.right, column + 1));
            }
        }

        //Iterate throup map and populate result list
        for(int i = minColumn; i <= maxColumn; i++){
            result.add(columnTable.get(i));
        }

        return result;
    }
}

//Time Complexity: O(n)
//Space Complexity: O(n)