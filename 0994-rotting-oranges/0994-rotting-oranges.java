class Solution {
    public int orangesRotting(int[][] grid) {
        //Create a queue to store the co-ordinates of the rotten oranges
        Queue<int[]> queue = new LinkedList<>();
        //Initialize fresh variable for tracking fresh oranges across the grid
        int fresh = 0;
        int time = 0;

        //Iterate over each cell
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                //Check if the cell has rotten orange
                if(grid[i][j] == 2){
                    //If so add it to the queue
                    queue.offer(new int[]{i, j});
                }

                //If the cell has fresh fruit, increment the fresh count
                if(grid[i][j] == 1){
                    fresh++;
                }
            }
        }

        //for tracking the adjacent cells
        int[][] directions = {{1,0}, {-1, 0}, {0, 1}, {0, -1}};

        //Iterate over the queue until it's empty and has no fresh fruits
        while(fresh > 0 && !queue.isEmpty()){
            int length = queue.size();

            //Process all rotten oranges at same time
            for(int i = 0; i < length; i++){
                int[] current = queue.poll();
                int row = current[0];
                int col = current[1];

                for(int[] dir:directions){
                    int r = dir[0] + row;
                    int c = dir[1] + col;

                    //If the adjacent cells are valid and has a frsh fruit
                    //add it to the queue and make it rotten.
                    //Decrease the fresh count
                    if(r >=0 && r < grid.length && c >= 0 && c < grid[0].length && grid[r][c]==1){
                        fresh--;
                        grid[r][c] = 2;
                        queue.offer(new int[]{r, c});
                    }
                }

            }
            time++;
        }

        //return time taken for rotting all the oranges if it doesn't have any fresh fruits
        return fresh == 0?time:-1;
    }
}

//Time Complexity: O(m * n)
//Space Complexity: O(m * n)