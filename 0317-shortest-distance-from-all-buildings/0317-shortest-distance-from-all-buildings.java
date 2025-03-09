class Solution {
    public int shortestDistance(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;

        //Define directions for BFS
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        int[][] total = new int[row][col];//stores total distance to empty land from all buildings

        int emptyland = 0;
        int min = Integer.MAX_VALUE;//stores shortest distance from all buildings if found

        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(grid[i][j] == 1){
                    min = Integer.MAX_VALUE;

                    Queue<int[]> q = new LinkedList<>();
                    q.add(new int[]{i, j});
                    int steps = 0;

                    while(!q.isEmpty()){
                        steps++;
                        int levelSize = q.size();
                        for(int k = 0; k < levelSize; k++){
                            int[] cur = q.poll();
                            int x = cur[0];
                            int y = cur[1];

                            for(int[] dir : directions){
                                int px = x + dir[0];
                                int py = y + dir[1];

                                if(px >= 0 && px < row && py >= 0 && py < col && grid[px][py] == emptyland){
                                    grid[px][py]--;
                                    total[px][py] += steps;
                                    q.offer(new int[]{px, py});
                                    min = Math.min(min, total[px][py]);
                                }
                            }
                        }
                    }
                    emptyland--;
                }
            }
        }

        return min == Integer.MAX_VALUE ? -1: min;
    }
}

//Time Complexity: O((mn)^2)
//Space Complexity: O(mn)