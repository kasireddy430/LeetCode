class Solution {
    public int minSideJumps(int[] obstacles) {
        int[] dp = new int[]{1, 0, 1};

        for(int obstacle : obstacles){
            if(obstacle > 0){
                dp[obstacle - 1] = Integer.MAX_VALUE;
            }

            for(int i = 0; i < 3; i++){
                if(obstacle - 1 != i){
                    dp[i] = Math.min(dp[i], Math.min(dp[(i + 1) % 3] == Integer.MAX_VALUE ? Integer.MAX_VALUE : dp[(i + 1) % 3] + 1,
                                            dp[(i + 2) % 3] == Integer.MAX_VALUE ? Integer.MAX_VALUE : dp[(i + 2) % 3] + 1));
                }
            }
        }

        return Math.min(dp[0], Math.min(dp[1], dp[2]));
    }
}

//TC: O(n)
//SC: O(1)

