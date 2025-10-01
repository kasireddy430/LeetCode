class Solution {
    public int splitArray(int[] nums, int k) {
        int max = Integer.MIN_VALUE;
        int sum = 0;

        for(int num : nums){
            sum += num;
            max = Math.max(num, max);
        }

        int left = max, right = sum;
        int res =0;

        while(left <= right){
            int maxAllowedSum = left + (right - left)/2;

            if(computeSubArrays(nums, maxAllowedSum) <= k){
                right = maxAllowedSum - 1;
                res = maxAllowedSum;
            } else {
                left = maxAllowedSum + 1;
            }
        }
        return res;
    }

    private int computeSubArrays(int[] nums, int maxAllowedSum){
        int splits = 0;
        int curSum = 0;

        for(int num : nums){
            if(curSum + num <= maxAllowedSum){
                curSum += num;
            } else{
                curSum = num;
                splits++;
            }
        }

        return splits+1;
    }
}