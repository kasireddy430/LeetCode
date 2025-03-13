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
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        // TreeMap for sorting columns automatically
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        Queue<Pair<TreeNode, Pair<Integer, Integer>>> queue = new LinkedList<>();
        queue.offer(new Pair<>(root, new Pair<>(0, 0))); // (node, (column, row))
        
        while (!queue.isEmpty()) {
            Pair<TreeNode, Pair<Integer, Integer>> pair = queue.poll();
            TreeNode node = pair.getKey();
            int col = pair.getValue().getKey();
            int row = pair.getValue().getValue();
            
            // Store in the map
            map.putIfAbsent(col, new TreeMap<>());
            map.get(col).putIfAbsent(row, new PriorityQueue<>());
            map.get(col).get(row).offer(node.val);

            // Process children with updated row & column values
            if (node.left != null) queue.offer(new Pair<>(node.left, new Pair<>(col - 1, row + 1)));
            if (node.right != null) queue.offer(new Pair<>(node.right, new Pair<>(col + 1, row + 1)));
        }
        
        // Build the output list
        List<List<Integer>> result = new ArrayList<>();
        for (TreeMap<Integer, PriorityQueue<Integer>> rows : map.values()) {
            List<Integer> sortedColumn = new ArrayList<>();
            for (PriorityQueue<Integer> nodes : rows.values()) {
                while (!nodes.isEmpty()) {
                    sortedColumn.add(nodes.poll());
                }
            }
            result.add(sortedColumn);
        }
        
        return result;
    }
}
