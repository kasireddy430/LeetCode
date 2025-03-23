class Solution {
    public int maximumProfit(int[] present, int[] future, int budget) {
        int n = present.length;
        int[] dp = new int[budget + 1];

        for(int i = 0; i < n; i++){
            int cost = present[i];
            int profit = future[i] - present[i];

            if(profit < 0) continue;

            for(int j = budget; j >= cost; j--){
                dp[j] = Math.max(dp[j], profit + dp[j - cost]);
            }
        }
        return dp[budget];
    }
}

//Time Complexity: O(n * budget)
//Space Complexity: O(budget)