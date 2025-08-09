import java.util.ArrayDeque;
import java.util.Queue;

class Solution {
    private static final int ISLAND = 1;
    private static final int VISITED_ISLAND = 2;
    private static final int WATER = 0;
    private static final int VISITED_WATER = -1;

    private int n;
    private final int[][] moves = {{-1,0}, {1,0}, {0,-1}, {0,1}};

    private void discoverIsland(int[][] grid, int row, int col, Queue<int[]> queue) {
        grid[row][col] = VISITED_ISLAND;
        queue.offer(new int[] {row, col});

        for (int[] move : moves) {
            int newRow = row + move[0];
            int newCol = col + move[1];

            if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < n &&
                grid[newRow][newCol] == ISLAND) {
                discoverIsland(grid, newRow, newCol, queue);
            }
        }
    }

    public int shortestBridge(int[][] grid) {
        n = grid.length;
        Queue<int[]> queue = new ArrayDeque<>();

        // 1. Find and mark the first island
        boolean found = false;
        for (int r = 0; r < n && !found; r++) {
            for (int c = 0; c < n && !found; c++) {
                if (grid[r][c] == ISLAND) {
                    discoverIsland(grid, r, c, queue);
                    found = true;
                }
            }
        }

        // 2. BFS expansion
        int steps = 0;
        while (true) {
            for (int size = queue.size(); size > 0; size--) {
                int[] pos = queue.poll();
                for (int[] move : moves) {
                    int newRow = pos[0] + move[0];
                    int newCol = pos[1] + move[1];

                    if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < n) {
                        if (grid[newRow][newCol] == ISLAND) {
                            return steps;
                        }
                        if (grid[newRow][newCol] == WATER) {
                            grid[newRow][newCol] = VISITED_WATER;
                            queue.offer(new int[]{newRow, newCol});
                        }
                    }
                }
            }
            steps++;
        }
    }
}
