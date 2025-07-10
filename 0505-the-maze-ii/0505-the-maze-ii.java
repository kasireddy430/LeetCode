class Solution {
    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        int m = maze.length, n = maze[0].length;
        int[][] distance = new int[m][n];
        for (int[] row : distance)
            Arrays.fill(row, Integer.MAX_VALUE);

        // 4 directions: right, down, left, up
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{start[0], start[1]});
        distance[start[0]][start[1]] = 0;

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            for (int[] dir : directions) {
                int x = curr[0], y = curr[1];
                int count = 0;

                // Roll the ball until it hits a wall
                while (x + dir[0] >= 0 && x + dir[0] < m &&
                       y + dir[1] >= 0 && y + dir[1] < n &&
                       maze[x + dir[0]][y + dir[1]] == 0) {
                    x += dir[0];
                    y += dir[1];
                    count++;
                }

                // If this new path is shorter, update and explore
                if (distance[curr[0]][curr[1]] + count < distance[x][y]) {
                    distance[x][y] = distance[curr[0]][curr[1]] + count;
                    queue.offer(new int[]{x, y});
                }
            }
        }

        int result = distance[destination[0]][destination[1]];
        return result == Integer.MAX_VALUE ? -1 : result;
    }
}
