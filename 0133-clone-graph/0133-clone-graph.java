/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        //Base Case: if the input node is empty return null
        if(node == null){
            return null;
        }

        //Create a map to store originalNode -> clonedNode refrence
        Map<Node, Node> oldToNew = new HashMap<>();
        //Create queue to perform BFS traversal
        Queue<Node> q = new LinkedList<>();

        //Clone the 1st node and enqueue it
        oldToNew.put(node, new Node(node.val));
        q.offer(node);

        //Perform BFS traversal
        while(!q.isEmpty()){
            //De-queue node
            Node cur = q.poll();

            for(Node nei : cur.neighbors){
                //Check if neighbor isn't cloned yet
                if(!oldToNew.containsKey(nei)){
                    //If so clone it and add it to the map before adding to the queue
                    oldToNew.put(nei, new Node(nei.val));
                    q.offer(nei);
                }
                //Add neighbors to the cloned node
                oldToNew.get(cur).neighbors.add(oldToNew.get(nei));
            }
        }

        //return the cloned entry node
        return oldToNew.get(node);
    }
}

//Time Complexity: O(V + E)
//Space Complexity: O(V)
//Where v - vertices, e - edges