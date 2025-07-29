class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) return 0;

        int hold = -prices[0];   // Holding a stock
        int sold = 0;            // Just sold
        int rest = 0;            // In cooldown or idle

        for (int i = 1; i < prices.length; i++) {
            int prevHold = hold;
            int prevSold = sold;
            int prevRest = rest;

            hold = Math.max(prevHold, prevRest - prices[i]);
            sold = prevHold + prices[i];
            rest = Math.max(prevRest, prevSold);
        }

        return Math.max(sold, rest); // Can't end on hold
    }
}
