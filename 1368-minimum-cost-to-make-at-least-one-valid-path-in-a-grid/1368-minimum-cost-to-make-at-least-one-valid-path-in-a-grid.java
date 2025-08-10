class Solution {
    public int minCost(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] minCost = new int[m][n];

        for(int i = 0; i < m; i++){
            Arrays.fill(minCost[i], Integer.MAX_VALUE);
        }

        Deque<int[]> q = new ArrayDeque<>();
        q.offerFirst(new int[]{0, 0});
        minCost[0][0] = 0;

        int[][] directions = { {0,1}, {0,-1}, {1,0}, {-1,0} };

        while(!q.isEmpty()){
            int[] cur = q.removeFirst();
            int r = cur[0];
            int c = cur[1];

            if(r == m - 1 && c == n - 1){
                return minCost[r][c];
            }

            for(int i = 0; i < 4; i++){
                int nr = r + directions[i][0];
                int nc = c + directions[i][1];

                int cost = (i + 1) == grid[r][c] ? 0 : 1;

                if(nr >= 0 && nr < m && nc >= 0 && nc < n && minCost[r][c] + cost < minCost[nr][nc]){

                    minCost[nr][nc] = minCost[r][c] + cost; 
                    if(cost == 0){
                        q.offerFirst(new int[]{nr, nc});
                    } else {
                        q.offerLast(new int[]{nr, nc});
                    }
                }
            }
        }

        return minCost[m - 1][n - 1];
    }
}