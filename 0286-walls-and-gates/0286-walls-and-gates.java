class Solution {
    public void wallsAndGates(int[][] rooms) {
        //Calculate the row and column lengths
        int ROW = rooms.length;
        int COLS = rooms[0].length;

        //Create queue to store coordinates
        Queue<int[]> q = new LinkedList<>();

        //Iterate over each cell
        for(int r = 0; r < ROW; r++){
            for(int c = 0; c < COLS; c++){
                //If a cell is gate, add it to the queue
                if(rooms[r][c] == 0){
                    q.offer(new int[]{r, c});
                }
            }
        }

        //Simply return if queue is empty
        if(q.size() == 0){
            return;
        }

        //Define directions for BFS
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        //Perform BFS traversal
        while(!q.isEmpty()){
            //Dequeue node
            int[] cur = q.poll();
            int row = cur[0];
            int col = cur[1];

            for(int[] dir:directions){
                int r = row + dir[0];
                int c = col + dir[1];

                //skip invalid cell
                if(r < 0 || r >= rooms.length || c < 0 || c >= rooms[0].length || rooms[r][c] != Integer.MAX_VALUE){
                    continue;
                }

                //Update the cell with distance from nearest gate
                rooms[r][c] = rooms[row][col] + 1;
                q.offer(new int[]{r, c});
            }
        }
    }
}

//Time Complexity: O(m * n)
//Space Complexity: O(m * n)