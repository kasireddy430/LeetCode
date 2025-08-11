class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length, n = dungeon[0].length;
        int[][] dp = new int[m][n];
        
        // Start from bottom-right corner
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (i == m - 1 && j == n - 1) {
                    // Princess cell (bottom-right)
                    dp[i][j] = Math.max(1, 1 - dungeon[i][j]);
                } else if (i == m - 1) {
                    // Last row, can only go right
                    dp[i][j] = Math.max(1, dp[i][j + 1] - dungeon[i][j]);
                } else if (j == n - 1) {
                    // Last column, can only go down
                    dp[i][j] = Math.max(1, dp[i + 1][j] - dungeon[i][j]);
                } else {
                    int need = Math.min(dp[i + 1][j], dp[i][j + 1]) - dungeon[i][j];
                    dp[i][j] = Math.max(1, need);
                }
            }
        }
        // Answer: minimum initial health needed at (0,0)
        return dp[0][0];
    }
}