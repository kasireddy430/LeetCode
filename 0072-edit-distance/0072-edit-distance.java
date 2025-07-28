public class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        int[][] dp = new int[m][n];

        for(int i = 0; i <= m; i++){
            dp[i][n] = m - i;
        }

        for(int j = 0; j <= n; j++){
            dp[m][j] = n - j;
        }

        for(int i = word1.length() - 1; i >= 0; i--){

            for(int j = word2.length() - 1; j >= 0; j--){
                if(word1.charAt(i) == word2.charAt(j)){
                    dp[i][j] = dp[i + 1][j + 1];
                } else {
                    dp[i][j] = 1 + Math.min(dp[i + 1][j], Mathmin(dp[i][j + 1], dp[i + 1, j + 1]));
                }
            }

        }

        return dp[0][0];
    }
}


//TC: O(m * n)
//SC: O(m * n)