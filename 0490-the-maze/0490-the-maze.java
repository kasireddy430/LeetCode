class Solution {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        int m = maze.length;
        int n = maze[0].length;

        // Visited matrix to track cells we've already explored
        boolean[][] visit = new boolean[m][n];

        // Directions: {down, right, up, left}
        int[][] directions = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

        // BFS queue to store current positions
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(start);
        visit[start[0]][start[1]] = true;

        // BFS traversal
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();

            // If we've reached the destination, return true
            if (curr[0] == destination[0] && curr[1] == destination[1]) {
                return true;
            }

            // Explore all 4 directions
            for (int[] dir : directions) {
                int r = curr[0];
                int c = curr[1];

                // Roll the ball until it hits a wall or goes out of bounds
                while (r >= 0 && r < m && c >= 0 && c < n && maze[r][c] == 0) {
                    r += dir[0];
                    c += dir[1];
                }

                // Step back to the last valid cell (just before the wall)
                r -= dir[0];
                c -= dir[1];

                // If we haven't visited this stopping point, explore it
                if (!visit[r][c]) {
                    queue.offer(new int[]{r, c});
                    visit[r][c] = true;
                }
            }
        }

        // If we exhaust all options and don't reach destination, return false
        return false;
    }
}
