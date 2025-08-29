public class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;

        // Step 1: Create a new array with 1 at both ends to handle boundaries easily
        int arr[] = new int[n + 2];
        arr[0] = 1;
        arr[n + 1] = 1;
        for (int i = 1; i <= n; i++) arr[i] = nums[i - 1];

        // Step 2: Initialize DP table
        // dp[i][j] = max coins obtainable by bursting balloons from index i to j (inclusive)
        int dp[][] = new int[n + 2][n + 2];
        for (int row[] : dp) Arrays.fill(row, 0);

        // Step 3: Fill DP table in bottom-up manner
        // i goes from n to 1 to ensure smaller intervals are computed first
        for (int i = n; i >= 1; i--) {
            for (int j = 1; j <= n; j++) {
                if (i > j) continue; // skip invalid intervals

                int maxi = Integer.MIN_VALUE;

                // Step 4: Try bursting each balloon in [i, j] as the last balloon
                for (int ind = i; ind <= j; ind++) {
                    // Coins from bursting 'ind' last in this interval
                    // arr[i-1] and arr[j+1] are the neighbors outside the current interval
                    int cost = arr[i - 1] * arr[ind] * arr[j + 1]
                             + dp[i][ind - 1]   // max coins from left subinterval
                             + dp[ind + 1][j];  // max coins from right subinterval

                    maxi = Math.max(maxi, cost); // take the maximum
                }

                dp[i][j] = maxi; // store max coins for interval [i,j]
            }
        }

        // Step 5: Return max coins for bursting all balloons
        return dp[1][n];
    }
}
