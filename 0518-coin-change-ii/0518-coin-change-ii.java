public class Solution {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;

        for (int coin : coins) {                 // Loop coins outer
            for (int a = coin; a <= amount; a++) // Left to right!
                dp[a] += dp[a - coin];
        }

        return dp[amount];
    }
}
