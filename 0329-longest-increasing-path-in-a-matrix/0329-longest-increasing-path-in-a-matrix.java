class Solution {
    //directions array
    private static final int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    private int m, n;
    
    public int longestIncreasingPath(int[][] matrix) {
        //Base case: if input matrix is null return 0
        if(matrix.length == 0){
            return 0;
        }

        //calculate row and column lengths
        m = matrix.length;
        n = matrix[0].length;

        int res = 0;//to store result

        int[][] cache = new int[m][n];//array to store longest increasing path from each cell

        //Iterate over each cell
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                res = Math.max(res, dfs(matrix, i, j, cache));
            }
        }
        return res;
    }

    private int dfs(int[][] matrix, int i, int j, int[][] cache){
        //If current cell already haslongest increasing path, return it
        if(cache[i][j] != 0){
            return cache[i][j];
        }

        //Iterate through four directions
        for(int[] dir : directions){
            int x = i + dir[0];
            int y = j + dir[1];

            //Check if neighbour cell is valid and it's value is greater than current cell
            if(x >= 0 && x < m && y >= 0 && y < n && matrix[x][y] > matrix[i][j]){
                //then recursively calculate longest path from neighbouring cells
                cache[i][j] = Math.max(cache[i][j], dfs(matrix, x, y, cache));
            }
        }

        return ++cache[i][j];//Adding 1 for current cell
    }
}

//Time Complexity: O(mn)
//Space Complexity: O(mn)