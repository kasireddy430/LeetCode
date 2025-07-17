class Solution {
    public int minSideJumps(int[] obstacles) {
        int n = obstacles.length;
        int[] dp = new int[3];
        dp[0] = 1;
        dp[1] = 0;
        dp[2] = 1;

        for (int i = 1; i < n; i++) {
           
            for (int j = 0; j < 3; j++) {
                if (obstacles[i] == j + 1) {
                    dp[j] = Integer.MAX_VALUE;
                }
            }
            
            for (int j = 0; j < 3; j++) {
                if (obstacles[i] != j + 1) {
                    dp[j] = Math.min(dp[j], Math.min((dp[(j + 1) % 3] == Integer.MAX_VALUE ? Integer.MAX_VALUE : dp[(j + 1) % 3] + 1),
                                                      (dp[(j + 2) % 3] == Integer.MAX_VALUE ? Integer.MAX_VALUE : dp[(j + 2) % 3] + 1)));
                }
            }
        }
        
        return Math.min(dp[0], Math.min(dp[1], dp[2]));
    }
}