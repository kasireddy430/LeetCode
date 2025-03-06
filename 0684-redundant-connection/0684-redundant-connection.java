class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        //Use parent array for Disjoint Set union
        int n = edges.length;
        int[] parent = new int[n + 1];
        //Initialize each nodes parent as itself
        for(int i = 0; i <= n; i++){
            parent[i] = i;
        }

        //Iterate over edges to find redundant edge
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];

            //if parent of both the nodes are same, then adding this edge will create a cycle
            if(find(parent, u) == find(parent, v)){
                return edge;
            } else {
                union(parent, u, v); //Merge sets if both have different parent
            }
        }
        return new int[0];
    }

    private int find(int[] parent, int u){
        //if a node's parent is not itself, then recursively call find funtion to find root
        if(parent[u] != u){
            parent[u] = find(parent, parent[u]);//path compression
        }
        return parent[u];
    }

    private void union(int[] parent, int u, int v){
        int uRoot = find(parent, u);//parent of u
        int vRoot = find(parent, v);//parent of v
        parent[uRoot] = vRoot;//Merge two sets
    }
}

//Time Complexity: O(E * &(n))
//Space Complexity: O(n). contributed by parent array
//where &(n) is inverse Ackermann function (due to path compression)