public class Solution {
    public int cherryPickup(int[][] grid) {
        int n = grid.length;

        Integer[][][] memo = new Integer[n][n][n];
        return Math.max(0, dp(grid, memo, 0, 0, 0));
    }

    private int dp(int[][] grid, Integer[][][] memo, int r1, int c1, int c2){
        int n = grid.length;
        int r2 = r1 + c1 - c2;

        if(r1 >= n || r2 >= n || c1 >= n || c2 >= n || grid[r1][c1] == -1 || grid[r2][c2] == -1){
            return Integer.MIN_VALUE;
        }

        if(memo[r1][c1][c2] != null){
            return memo[r1][c1][c2];
        }

        if(r1 == n - 1 && c1 == n - 1){
            return grid[r1][c1];
        }

        int cherry = (r1 == r2 && c1 == c2) ? grid[r1][c1] : grid[r1][c1] + grid[r2][c2];

        int maxCherry = Math.max(dp(grid, memo, r1 + 1, c1, c2), dp(grid, memo, r1, c1 + 1, c2));
        maxCherry = Math.max(maxCherry, dp(grid, memo, r1 + 1, c1, c2 + 1));
        maxCherry = Math.max(maxCherry, dp(grid, memo, r1, c1 + 1, c2 + 1));

        memo[r1][c1][c2] = maxCherry == Integer.MIN_VALUE ? Integer.MIN_VALUE : maxCherry + cherry;

        return memo[r1][c1][c2];
    }
}

//Time Complexity:
//Space Complexity: