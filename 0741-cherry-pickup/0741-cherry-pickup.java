public class Solution {
    public int cherryPickup(int[][] grid) {
        int n = grid.length;
        Integer[][] memo = new Integer[n][n];  // Only need to track one person's position
        return Math.max(0, dp(grid, memo, 0, 0));  // Start from (0, 0)
    }
    
    private int dp(int[][] grid, Integer[][] memo, int r, int c) {
        int n = grid.length;
        
        // If out of bounds or thorn cell (-1)
        if (r >= n || c >= n || grid[r][c] == -1) {
            return Integer.MIN_VALUE;
        }
        
        // Memoization check to return already computed result
        if (memo[r][c] != null) {
            return memo[r][c];
        }
        
        // Base case: reached bottom-right corner (goal)
        if (r == n - 1 && c == n - 1) {
            return grid[r][c];
        }
        
        // Move right or down
        int maxCherries = Math.max(dp(grid, memo, r + 1, c), dp(grid, memo, r, c + 1));
        
        // Add current cell's cherries
        maxCherries = (maxCherries == Integer.MIN_VALUE) ? Integer.MIN_VALUE : maxCherries + grid[r][c];
        
        // Memoize and return the result
        memo[r][c] = maxCherries;
        
        return memo[r][c];
    }
}
