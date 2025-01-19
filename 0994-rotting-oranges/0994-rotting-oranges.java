class Solution {
    public int orangesRotting(int[][] grid) {
        //Create a queue to store the coordinates of the rotten oranges
        Queue<int[]> q = new LinkedList<>();

        //Initialize variables to track fresh oranges and the time
        int fresh = 0;
        int time = 0;

        //Iterate over each cell
        for(int r = 0; r < grid.length; r++){
            for(int c =0; c < grid[0].length; c++){
                //Check if the cell holds the fresh fruit
                if(grid[r][c] == 1){
                    fresh++;
                }

                //Add co-ordinates of rotten oranges to queue
                if(grid[r][c] == 2){
                    q.offer(new int[]{r, c});
                }
            }
        }

        //Define directions for the adjacent cells
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        //Iterate until no fresh fruits are left and queue is empty
        while(fresh > 0 && !q.isEmpty()){
            int size = q.size();

            for(int i = 0; i < size; i++){
                int[] current = q.poll();
                int row = current[0];
                int col = current[1];

                for(int[] dir:directions){
                    int r = row + dir[0];
                    int c = col + dir[1];

                    if(r >= 0 && r < grid.length && c >= 0 && c < grid[0].length && grid[r][c] == 1 ){
                        grid[r][c] = 2;
                        q.offer(new int[]{r, c});
                        fresh--;
                    }

                }
            }
            time++;
        }
        return fresh == 0 ? time : -1;
    }
}

//Time Complexity: O(m * n)
//Space Complexity: O(m * n)