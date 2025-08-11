class Solution {
    public int calculateMinimumHP(int[][] dun) {
        int m = dun.length, n = dun[0].length;

        int[][] dp = new int[m][n];
        for(int[] row: dp){
            Arrays.fill(row, -1);
        }

        return solve(0, 0, m, n, dun, dp);
    }

    private int solve(int i, int j, int m, int n, int[][] dun, int[][] dp){
        if(i >= m || j >= n){
            return Integer.MAX_VALUE;
        }

        if(i == m - 1 && j == n - 1){
            return Math.max(1, 1 - dun[i][j]);
        }

        if(dp[i][j] != -1) return dp[i][j];

        int right = solve(i, j + 1, m, n, dun, dp);
        int bottom = solve(i + 1, j, m, n, dun, dp);

        int total = Math.min(right, bottom) - dun[i][j];
        return dp[i][j] = Math.max(1, total); 
    }
}

//TC: O(m * n)
//SC: O(m * n)