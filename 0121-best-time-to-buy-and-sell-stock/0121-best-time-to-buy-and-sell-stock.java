class Solution {
    public int maxProfit(int[] prices) {
        int max = 0;
        int l = 0;

        for(int r = 1; r < prices.length; r++){
            if(prices[r] < prices[l]){
                l = r;
            } else {
                max = Math.max(max, prices[r] - prices[l]);
            }
        }
        return max;
    }
}

//Time Complexity: O(n)
//Space Complexity: O(1)