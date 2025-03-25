class Solution {
    public int minOperations(int[] nums, int x, int y) {
        
        int low = 0; 
        int high = Integer.MIN_VALUE; 

        for(int i=0; i < nums.length; i++)
        {
            high = Math.max(high, nums[i]);
        }

        int bestMid = -1;

        while(low <= high)
        {
            int mid = low + (high - low)/2; 

            if(isPossible(nums, x, y, mid))
            {
                bestMid = mid; 
                high = mid-1;
            }
            else 
            {   
                low = mid+1;
            }
        }

        return bestMid;
    }

    public boolean isPossible(int[] nums, int x, int y, int mid)
    {
        long diff = (long)((long)x - (long)y); 
        long totalExtra= 0; 

        for(int i=0; i < nums.length; i++)
        {
            long rem = ((long)nums[i] - ((long)y * mid));
            if(rem <= 0) continue; 
            totalExtra+= (long)Math.ceilDiv(rem, diff);
        }

        return totalExtra <= mid;
    }
}