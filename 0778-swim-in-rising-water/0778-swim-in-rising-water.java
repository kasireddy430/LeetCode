class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        boolean[][] visited = new boolean[n][n];

        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        q.offer(new int[]{grid[0][0], 0, 0});
        visited[0][0] = true;

        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        while(!q.isEmpty()){
            int[] cur = q.poll();

            int t = cur[0], r = cur[1], c = cur[2];
            if(r == n - 1 && c == n - 1){
                return t;
            }

            for(int[] dir : directions){
                int row = r + dir[0];
                int col = c + dir[1];

                if(row >= 0 && row < n && col >= 0 && col < n && !visited[row][col]){
                    visited[row][col] = true;
                    q.offer(new int[]{Math.max(t, grid[row][col]), row, col});
                }
            }
        }
        return -1;
    }
}

//TC: O(n^2 log n)
//SC: O(n^2)