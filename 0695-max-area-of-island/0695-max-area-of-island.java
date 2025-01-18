class Solution {

    public int maxAreaOfIsland(int[][] grid) {
        //Calculate row and column length of the input matrix
        int ROWS = grid.length;
        int COLS = grid[0].length;

        //Initilize a variable to count max area
        int maxArea = 0;

        //Iterate over each cell of the input matrix
        for(int r = 0; r < ROWS; r++){
            for(int c = 0; c < COLS; c++){
                //Check if the cell is an island
                if(grid[r][c] == 1){
                    maxArea = Math.max(maxArea, visitIsland(grid, r, c)); //Mark the cell visited
                }
            }
        }
        return maxArea;
    }

    private int visitIsland(int[][] grid, int r, int c){
        //Check if the cell is out of bounds or if it is filled with 0
        if(r < 0 || r >= grid.length || c < 0|| c >= grid[0].length || grid[r][c] == 0){
            return 0;
        }

        //Mark the island visited
        grid[r][c] = 0;

        int count = 1;

        //Recursively visit adjacent islands
        count += visitIsland(grid, r + 1, c);
        count += visitIsland(grid, r - 1, c);
        count += visitIsland(grid, r, c + 1);
        count += visitIsland(grid, r, c - 1);

        return count;
    }
}


//Time Complexity: O(m * n)
//Space Complexity: O(m * n). Contributed by the recursion stack