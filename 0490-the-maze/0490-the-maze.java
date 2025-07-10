class Solution {
    int m;
    int n;
    int[][] dirs;
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        this.m = maze.length;
        this.n = maze[0].length;
        this.dirs = new int[][]{{-1,0}, {1,0}, {0,1}, {0,-1}};
        if(start[0] == destination[0] && start[1] == destination[1]) return true;
        return dfs(maze, start, destination);
    }

    private boolean dfs(int[][] maze, int[] start, int[] destination){
        //base
        if(start[0] == destination[0] && start[1] == destination[1]) return true;
        if(maze[start[0]][start[1]] == 2) return false;
        maze[start[0]][start[1]] = 2;
        for(int[] dir: dirs){
            int nr = start[0];
            int nc = start[1];
            while(nr >=0 && nc >=0 && nr <m && nc <n && maze[nr][nc] != 1){
                nr += dir[0];
                nc += dir[1];
            }
            //step back
            nr -=dir[0];
            nc -=dir[1];
            int[] ne = new int[]{nr, nc};
            if(dfs(maze, ne, destination)) return true;
        }
        return false;
    }
}