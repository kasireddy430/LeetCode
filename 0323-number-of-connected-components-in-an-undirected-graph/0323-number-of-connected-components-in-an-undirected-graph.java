class Solution {
    public int countComponents(int n, int[][] edges) {
        //Adjacency list for graph representation
        List<List<Integer>> adj = new ArrayList<>();
        //boolean array to track visited nodes
        boolean[] visit = new boolean[n];

        //Initialize adjacency list
        for(int i = 0; i< n; i++){
            adj.add(new ArrayList<>());
        }
        //populate adjacency list
        for(int[] edge : edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);   
        }

        int result = 0;//tracks no.of connexted components

        //Start from node 0 and check number of disjoint components
        for(int i = 0; i < n; i++){
            //Check if the node is visited or not. If not recursively visit neighbours and mark visited
            if(!visit[i]){
                dfs(i, adj, visit);
                result++;
            }
        }

        return result;
    }

    private void dfs(int node, List<List<Integer>> adj, boolean[] visit){
        //If node is already visited one, do nothing
        if(visit[node]){
            return;
        }

        visit[node] = true;//mark visited

        //process neighbours
        for(int nei : adj.get(node)){
            if(!visit[nei]){//if a neighbour isn't visited recursively visit it's neightbours
                dfs(nei, adj, visit);
            }
        }
    }
}

//Time COmplexity: O(V + E)
//Space Complexity: O(V + E)
//Where V is no.of nodes and E is no.of edges