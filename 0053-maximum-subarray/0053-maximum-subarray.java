class Solution {
    public int maxSubArray(int[] nums) {
        //Initialize maxSum with first element of input array(such that subarray 
        //maxSum will consider atleast one element from input array). Initilize curSum
        //to track currrent sum in the subarray
        int maxSum = nums[0], curSum = 0;

        //Iterate over input array
        for(int num : nums){
            //Check if current sum is negative. if so reset curSum to 0.
            if(curSum < 0){
                curSum = 0;
            }
            //Add current num to current Sum
            curSum += num;
            //Update maxSum if curSum is greater
            maxSum = Math.max(maxSum, curSum);
        }
        //Return maximum subarray sum
        return maxSum;
    }
}

//Time Complexity: O(n)
//Space Complexity: O(1)