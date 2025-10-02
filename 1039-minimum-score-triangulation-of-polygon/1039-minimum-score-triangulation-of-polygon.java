class Solution {
    public int minScoreTriangulation(int[] A) {
        int n = A.length;
        int[][] dp = new int[n][n];

        // dp[i][j] default 0 for j-i < 2
        for (int len = 3; len <= n; len++) {
            for (int i = 0; i + len - 1 < n; i++) {
                int j = i + len - 1;
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = i + 1; k <= j - 1; k++) {
                    int cost = dp[i][k] + dp[k][j] + A[i] * A[k] * A[j];
                    if (cost < dp[i][j]) dp[i][j] = cost;
                }
            }
        }

        return dp[0][n - 1];
    }
}
