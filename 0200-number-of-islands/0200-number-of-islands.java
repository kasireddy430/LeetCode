class Solution {
    public int numIslands(char[][] grid) {
        //Calculate row and column length of 2-D array
        int ROWS = grid.length;
        int COLS = grid[0].length;

        int islandsCount = 0;

        //Iterate over each cell in input array
        for(int r = 0; r < ROWS; r++){
            for(int c = 0; c < COLS; c++){
                //Check if the is island. If so, increment the island count
                //and mark adjacent islands visited(by marking it as water)
                if(grid[r][c] == '1'){
                    islandsCount++;
                    visitIslands(grid, r, c);
                }
            }
        }
        return islandsCount;
    }

    private void visitIslands(char[][] grid, int r, int c){
        //Base case: check if the row or column is invalid and the cell is water
        if(r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || grid[r][c] == '0'){
            //If so the cell isn't required to be marked as visited
            return;
        }

        //If not, mark the cell visited
        grid[r][c] = '0';

        //Visit the adjacent cells of the current island and mark them visited
        visitIslands(grid, r + 1, c);
        visitIslands(grid, r - 1, c);
        visitIslands(grid, r, c + 1);
        visitIslands(grid, r, c - 1);
    }
}

//Time Complexity: O(m * n)
//Space Complexity: O(m * n). Contributed by the recursion stack