class Solution {
    private static final int ISLAND = 1;
    private static final int VISITED_ISLAND = 2;
    private static final int VISITED_WATER = -1;
    private static final int WATER = 0;
    
    private static final int[][] DIRECTIONS = {
        {0, 1}, {1, 0}, {-1, 0}, {0, -1}
    };
    
    private void dfs(int[][] grid, int i, int j, Queue<int[]> queue) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] != ISLAND) {
            return;
        }
        
        grid[i][j] = VISITED_ISLAND; // Mark before adding
        queue.offer(new int[]{i, j, 0});
        
        for (int[] dir : DIRECTIONS) {
            dfs(grid, i + dir[0], j + dir[1], queue);
        }
    }

    public int shortestBridge(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        
        // Find first island
        boolean found = false;
        for (int i = 0; i < rows && !found; i++) {
            for (int j = 0; j < cols && !found; j++) {
                if (grid[i][j] == ISLAND) {
                    dfs(grid, i, j, queue);
                    found = true;
                }
            }
        }

        // BFS to expand over water
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int x = cell[0], y = cell[1], steps = cell[2];
            
            for (int[] dir : DIRECTIONS) {
                int newX = x + dir[0];
                int newY = y + dir[1];
                
                if (newX >= 0 && newX < rows && newY >= 0 && newY < cols) {
                    if (grid[newX][newY] == ISLAND) {
                        return steps; // Found second island
                    }
                    if (grid[newX][newY] == WATER) {
                        grid[newX][newY] = VISITED_WATER;
                        queue.offer(new int[]{newX, newY, steps + 1});
                    }
                }
            }
        }
        return 0; // Should never happen for valid inputs
    }
}
