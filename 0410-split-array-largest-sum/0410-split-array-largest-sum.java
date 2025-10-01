class Solution {
    public int splitArray(int[] nums, int k) {
        int sum = 0;
        int max = 0;

        for(int num : nums){
            sum += num;
            max = Math.max(num, max);
        }

        int left = max, right = sum;
        int res = 0;

        while(left <= right){
            int maxSumAllowed = left + (right - left)/2;

            if(computeSubArrays(nums, maxSumAllowed) <= k){
                right = maxSumAllowed - 1;
                res = maxSumAllowed;
            } else {
                left = maxSumAllowed + 1;
            }
        }
        return res;
    }

    private int computeSubArrays(int[] nums, int maxSumAllowed){
        int curSum = 0;
        int splits = 0;

        for(int num : nums){
            if(curSum + num <= maxSumAllowed){
                curSum += num;
            } else {
                curSum = num;
                splits++;
            }
        }

        return splits + 1;
    }
}

//TC: O(N log (sumOfArray))
//SC: O(1)