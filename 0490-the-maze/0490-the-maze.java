class Solution {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        int m = maze.length;
        int n = maze[0].length;

        boolean[][] visit = new boolean[m][n];

        Queue<int[]> q = new LinkedList<>();
        q.offer(start);
        visit[start[0]][start[1]] = true;

        while(!q.isEmpty()){
            int[] cur = q.poll();

            if(cur[0] == destination[0] && cur[1] == destination[1]){
                return true;
            }

            int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

            for(int[] dir : directions){
                int r = cur[0];
                int c = cur[1];

                while(r >= 0 && r < m && c >= 0 && c < n && maze[r][c] == 0){
                    r += dir[0];
                    c += dir[1];
                }

                r -= dir[0];
                c -= dir[1];

                if(!visit[r][c]){
                    q.offer(new int[]{r, c});
                    visit[r][c] = true;
                }
            }
        }

        return false;
    }
}

//TC: O(mn.(m+n))
//SC: O(mn)
