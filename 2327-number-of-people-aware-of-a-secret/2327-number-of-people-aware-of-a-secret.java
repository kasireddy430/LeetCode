class Solution {
    public int peopleAwareOfSecret(int n, int delay, int forget) {
        long mod = 1_000_000_007;

        long[] dp = new long[n + 1];//new users each day
        dp[1] = 1;

        long sharingCount = 0;

        for(int i = 2; i <= n; i++){
            if(i - delay >= 1){
                sharingCount = (sharingCount + dp[i-delay]) % mod;
            }

            if(i - forget >= 1){
                sharingCount = (sharingCount - dp[i - forget] + mod) % mod;
            }

            dp[i] = sharingCount;
        }

        long total = 0;
        for(int i = n - forget + 1; i <= n; i++){
            total = (total + dp[i])%mod; 
        }

        return (int)total;
    }
}


//TC: O(n)
//SC: O(n)
