class Solution {
    public int maxCoins(int[] nums) {
        
        int n = nums.length;
        int[] new_nums = new int[n + 2];
        new_nums[0] = 1;
        new_nums[n + 1] = 1;

        for (int x = 1; x <= n; x++) {
            new_nums[x] = nums[x - 1];
        }

        int[][] dp = new int[n + 2][n + 2];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return func(new_nums, 0, n + 1, dp);
    }

    public int func(int[] arr, int i, int j, int[][] dp) {
        if (i + 1 == j) {
            return 0;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int max = 0;

        for (int k = i + 1; k < j; k++) {
            int coins = arr[i] * arr[k] * arr[j];
            int left = func(arr, i, k, dp);
            int right = func(arr, k, j, dp);
            max = Math.max(max, coins + left + right);
        }

        dp[i][j] = max;
        return max;
    }
}