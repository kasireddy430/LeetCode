class Solution {
    public int numIslands(char[][] grid) {
        //Calculate row and column lengths of the 2-D matrix
        int ROWS = grid.length;
        int COLS = grid[0].length;

        //Initialize a variable to count number of valid islands
        int islandsCount = 0;

        //Iterate over each cell
        for(int r = 0; r < ROWS; r++){
            for(int c = 0; c < COLS; c++){
                //Check if the CEll is an island or not
                if(grid[r][c] == '1'){
                    islandsCount++; //Increment the island count
                    visitIslands(grid, r, c);  //Mark the islands visited
                }
            }
        }
        return islandsCount;
    }

    private void visitIslands(char[][] grid, int r, int c){
        //Check if the cell is out of bounds or is it water
        if(r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || grid[r][c] == '0'){
            return;
        }

        //Mark the island visited by marking it as water
        grid[r][c] = '0';

        //Recursively visit all the neightbouring Cells 
        visitIslands(grid, r+1, c);
        visitIslands(grid, r-1, c);
        visitIslands(grid, r, c+1);
        visitIslands(grid, r, c-1);
    }
}

//Time Complexity: O(m * n)
//Space Complexity: O(m * n). Contributed by the recursion stack