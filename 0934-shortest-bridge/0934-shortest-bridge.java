import java.util.*;

class Solution {
    Queue<int[]> q = new LinkedList<>();

    void dfs(int[][] grid, int i, int j) {
        // Base case: Out of bounds or not part of the island
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] != 1)
            return;
        
        // Mark as visited
        q.add(new int[] { i, j, 0 });
        grid[i][j] = 2;

        // Visit all 4 directions
        dfs(grid, i + 1, j);
        dfs(grid, i - 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i, j - 1);
    }

    public int shortestBridge(int[][] grid) {
        int startI = 0, startJ = 0;
        
        // Find the first island
        outerLoop:
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    startI = i;
                    startJ = j;
                    break outerLoop; // Stop searching
                }
            }
        }

        // Mark the first island and add it to the queue
        dfs(grid, startI, startJ);

        // BFS to find the shortest bridge
        int[][] directions = { {0, 1}, {1, 0}, {-1, 0}, {0, -1} };
        while (!q.isEmpty()) {
            int[] current = q.poll();
            int x = current[0], y = current[1], steps = current[2];

            for (int[] dir : directions) {
                int newX = x + dir[0];
                int newY = y + dir[1];

                // Check bounds
                if (newX >= 0 && newX < grid.length && newY >= 0 && newY < grid[0].length) {
                    if (grid[newX][newY] == 1) {
                        return steps; // Reached the second island
                    }
                    if (grid[newX][newY] == 0) {
                        grid[newX][newY] = -1; // Mark water as visited
                        q.add(new int[] { newX, newY, steps + 1 });
                    }
                }
            }
        }
        return 0;
    }
}