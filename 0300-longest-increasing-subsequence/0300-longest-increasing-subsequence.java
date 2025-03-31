class Solution {
    public int lengthOfLIS(int[] nums) {
        if(nums.length==0 || nums.length==1) return nums.length;

        //dp array
        int[] dp=new int[nums.length];
        Arrays.fill(dp,1);
        int i=1,j=0;

        while(j<i && i<nums.length){
            if(nums[i]>nums[j]){
                dp[i]=Math.max(dp[i], dp[j]+1);
            }
            j++;
            if(i==j){
                i++;
                j=0;
            }
        }

        //finding the maximum value of dp array
        int max=Integer.MIN_VALUE;
        for(int k=0; k<dp.length; k++){
            if(dp[k] > max) max=dp[k];
        }

        return max;
    }
    
}