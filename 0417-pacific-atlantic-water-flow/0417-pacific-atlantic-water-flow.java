class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        //Calculate row and column length of input 2-D array
        int ROWS = heights.length;
        int COLS = heights[0].length;

        //Queue to store co-ordinates which are flowing to pacific and atlantic respectively
        Queue<int[]> pacQ = new LinkedList<>();
        Queue<int[]> atlQ = new LinkedList<>();

        //For tracking the cells that reach pacific and atlantic oceans
        boolean[][] pac = new boolean[ROWS][COLS];
        boolean[][] atl = new boolean[ROWS][COLS];

        //EnQueue border co-ordinates to the queue
        for(int c = 0; c < COLS; c++){ //First row and last row
            pacQ.offer(new int[]{0, c});    //First row
            atlQ.offer(new int[]{ROWS - 1, c});
        }

        for(int r = 0; r < ROWS; r++){ //First and last columns
            pacQ.offer(new int[]{r, 0});
            atlQ.offer(new int[]{r, COLS - 1});
        }

        //Perform bfs traversal
        bfs(heights, pacQ, pac);
        bfs(heights, atlQ, atl);

        List<List<Integer>> result = new ArrayList<>();

        for(int r = 0; r < ROWS; r++){
            for(int c = 0; c < COLS; c++){
                if(pac[r][c] && atl[r][c]){ //Check if the reaches both atlantic and pacific ocean
                    result.add(Arrays.asList(r, c));
                }
            }
        }
        return result;
    }

    private void bfs(int[][] heights, Queue<int[]> q, boolean[][] ocean){
        //Define directions for BFS traversal
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        while(!q.isEmpty()){
            int[] cur = q.poll();//DeQueue cell coordinates
            int row = cur[0];
            int col = cur[1];
            ocean[row][col] = true;//Mark the cell visited

            for(int[] dir : directions){
                int r = row + dir[0];
                int c = col + dir[1];

                //Check if the cell is valid and avoid revisiting the same cell
                //If the height at the current cell is greater than or equal to the previous cell's height
                //then this cell reaches the ocean. So add the cell to queue
                if(r >= 0 && r < heights.length && c >= 0 && c < heights[0].length &&
                    !ocean[r][c] && heights[r][c] >= heights[row][col]){
                        q.offer(new int[]{r, c});
                }
            }
        }
    }
}

//Time Complexity: O(m * n)
//Space Complexity: O(m * n)