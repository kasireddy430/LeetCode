class Solution {
    public int numWays(List<String> words, String target) {
        int m = target.length(), n = words.get(0).length(), MOD = (int)1e9 + 7;
        int[][] freq = new int[26][n];
        for (String word : words) {
            for (int i = 0; i < n; i++) {
                freq[i][word.charAt(i) - 'a']++;
            }
        }

        long[] dp = new long[m + 1];
        dp[0] = 1;
        for (int j = 0; j < n; j++) {
            for (int i = m - 1; i >= 0; i--) {
                dp[i + 1] = (dp[i + 1] + dp[i] * freq[target.charAt(i) - 'a'][j]) % MOD;
            }
        }
        return (int) dp[m];
    }
}