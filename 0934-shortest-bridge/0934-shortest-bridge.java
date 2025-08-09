class Solution {

    int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int shortestBridge(int[][] grid) {
        int n = grid.length;
        Queue<int[]> q = new LinkedList<>();
        boolean found = false;

        for(int i = 0; i < n && !found; i++){
            for(int j = 0; j < n && !found; j++){
                if(grid[i][j] == 1){
                    discoverIsland(grid, i, j, q);
                    found = true;
                }
            }
        }

        int steps = 0;
        while(true){
            int size = q.size();

            for(int i = 0; i < size; i++){
                int[] cur = q.poll();

                for(int[] dir : directions){
                    int row = cur[0] + dir[0];
                    int col = cur[1] + dir[1];

                    if(row >= 0 && row < n && col >= 0 && col < n){
                        if(grid[row][col] == 1){
                            return steps;
                        } else if(grid[row][col] == 0){
                            grid[row][col] = -1;
                            q.offer(new int[]{row, col});
                        }
                    }
                }
            }
            steps++;
        }
    }

    private void discoverIsland(int[][] grid, int i, int j, Queue<int[]> q){
        grid[i][j] = 2;
        q.offer(new int[]{i, j});

        for(int[] dir : directions){
            int row = i + dir[0];
            int col = j + dir[1];

            if(row >= 0 && row < grid.length && col >= 0 && col < grid.length && grid[row][col] == 1){
                discoverIsland(grid, row, col, q);
            }
        }
    }
}