class Solution {
    public int numDistinct(String s, String t) {
        int m = s.length();
        int n = t.length();

        if(n > m){
            return 0;
        }

        int[][] dp = new int[m + 1][n + 1];

        for(int[] row : dp){
            Arrays.fill(row, -1);
        }

        return dfs(s, t, 0, 0, dp);
    }

    private int dfs(String s, String t, int i, int j, int[][] dp){
        if(j == t.length()){
            return 1;
        }
        
        if(i == s.length()){
            return 0;
        }

        if(dp[i][j] != -1){
            return dp[i][j];
        }

        int res = dfs(s, t, i + 1, j, dp);
        if(s.charAt(i) == t.charAt(j)){
            res += dfs(s, t, i + 1, j + 1, dp);
        }

        dp[i][j] = res;

        return res;
    }
}

//TC: O(m * n)
//SC: O(m * n)