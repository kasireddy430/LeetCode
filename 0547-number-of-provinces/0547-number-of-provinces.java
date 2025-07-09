class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] visit = new boolean[n];
        int components = 0;

        for(int i = 0; i < n; i++){
            if(!visit[i]){
                components++;
                bfs(i, isConnected, visit);
            }
        }

        return components;
    }

    private void bfs(int node, int[][] isConnected, boolean[] visit){

        Queue<Integer> q = new LinkedList<>();
        q.offer(node);

        while(!q.isEmpty()){
            int cur = q.poll();
            visit[cur] = true;

            for(int i = 0; i < isConnected.length; i++){
                if(isConnected[cur][i] == 1 && !visit[i]){
                    q.offer(i);
                }
            }
        }
    }
}

//TC: O(n)
//SC: O(n)