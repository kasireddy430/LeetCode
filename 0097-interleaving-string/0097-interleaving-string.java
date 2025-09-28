class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int m = s1.length(), n = s2.length();

        if(m + n != s3.length()){
            return false;
        }    

        boolean[] dp = new boolean[n + 1];
        dp[n] = true;

        for(int i = m; i >= 0; i--){
            boolean[] nextDp = new boolean[n + 1];
            if(i == m) nextDp[n] = true;

            for(int j = n; j >= 0; j--){
                if(i < m && (s1.charAt(i) == s3.charAt(i + j))&& dp[j]){
                    nextDp[j] = true;
                }

                if(j < n && (s2.charAt(j) == s3.charAt(i + j)) && nextDp[j + 1]){
                    nextDp[j] = true;
                }                
            }
            dp = nextDp;
        }

        return dp[0];
    }
}