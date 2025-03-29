class Solution {
    public boolean solveMem(int i, int j, String inp, String p, Boolean[][] dp){
        //if j become out of index, then inp should also become, if both are true then return true else false
        if(j == p.length()){
            return i == inp.length();
        }
        if(dp[i][j] != null) return dp[i][j];
        //we will check if 1st char of both the strings are matching or not, 
        //they will also match if p's 0th char is '.',
        //but before checking, we will insure that our input's length should not be 0
        boolean firstCharMatch = false;
        if((i < inp.length())  && (inp.charAt(i) == p.charAt(j) || p.charAt(j) == '.')) firstCharMatch = true;
        //Now we will check, if 1st index char of p is equal to star, then we have 2 options, take that star or not take
        if(j+1 < p.length() && p.charAt(j+1)=='*'){
            //if we are taking *, we will check the 0th index char is match or not, then we will call solve for 1st index input
            boolean take = firstCharMatch == true && solveMem(i+1, j, inp, p, dp); 
            //if we are not taking *, then we will try next char after star in p, inp will remain same
            boolean notTake = solveMem(i, j+2, inp, p, dp); 
            return dp[i][j] = take || notTake;
        }
        //else it means p's 1st index char is not star, so we will do normal checking, after matching 0th index char
            return dp[i][j] = firstCharMatch == true && solveMem(i+1, j+1, inp, p, dp);
    }
    public boolean isMatch(String s, String p) {
        Boolean[][] dp = new Boolean[s.length() + 1][p.length() + 1]; 
        return solveMem(0, 0, s, p, dp);
    }
}