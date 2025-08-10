class Solution {
    public int minCost(int[][] grid) {
        int n = grid[0].length;
        int m = grid.length;

        int[] dr = {0,  0,  1, -1};
        int[] dc = {1, -1,  0,  0};

        int[][] dist = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++)
                dist[i][j] = Integer.MAX_VALUE;
        }
        dist[0][0] = 0;
        Deque<int[]> deq = new ArrayDeque<>();
        deq.addFirst(new int[]{0,0});

        while(!deq.isEmpty()){
            int[] curr = deq.removeFirst();
            int r = curr[0];
            int c = curr[1];
            if (r == m-1 && c == n-1) 
                return dist[r][c];
            for(int i=1;i<=4;i++){
                int k = i-1;
                int nr = r+dr[k];
                int nc = c+dc[k];
                if(nr < m && nc < n && nr >= 0 && nc >= 0){
                    int extra = i == grid[r][c] ? 0 : 1;
                    if(dist[r][c]+extra<dist[nr][nc])
                    {
                        dist[nr][nc] = dist[r][c]+extra;
                        if (extra == 0)
                            deq.addFirst(new int[]{nr,nc});
                        else
                            deq.addLast(new int[]{nr,nc});
                    }
                        
                }
            }
        }
        return dist[m-1][n-1];
    }
}