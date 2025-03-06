class Solution {
    public boolean validTree(int n, int[][] edges) {
        //Base case: If number of edges is greater than n - 1, then tree is invalid
        if(edges.length > n - 1){
            return false;
        }
        //Build adjaceny list
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }

        //populate adjacency list
        for(int[] edge : edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        //Tracks visited nodes
        Set<Integer> visit = new HashSet<>();

        //Check if there is any cycle in the graph. If so, it isn't a tree
        //Start from node 0
        if(!dfs(0, -1, visit, adj)){
            return false;
        }

        //if visited nodes equal's n then tree is valid
        return visit.size() == n;
    }

    private boolean dfs(int node, int parent,Set<Integer> visit, List<List<Integer>> adj){
        //Check if a node is visited, if visiting again then a cycle is detected
        if(visit.contains(node)){
            return false;
        }

        //Mark the current node visited
        visit.add(node);

        //Recursively visit neightbours and check for valid tree(cycle detection)
        //If neightbour is a parent, skip iteration since the node is already visited
        for(int nei : adj.get(node)){
            if(nei == parent){
                continue;
            }
            if(!dfs(nei, node, visit, adj)){
                return false;
            }
        }

        //return true, if current DFS path is valid
        return true;
    }
}

//Time Complexity: O(V + E)
//Space Complexity: O(V + E)