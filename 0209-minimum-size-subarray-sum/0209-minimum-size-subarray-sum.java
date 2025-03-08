class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int subArraySum = 0;//Tracks subarray sum
        int result = Integer.MAX_VALUE;//to store minimum size subarray

        //Iterate through input array
        for(int i = 0; i < nums.length; i++){
            subArraySum += nums[i];

            //while subArraySum is greater than or equal to target
            while(subArraySum >= target){
                //update result with subarray size
                result = Math.min(result, i - left + 1);
                //shrink window
                subArraySum -= nums[left++];
            }
        }

        //If no valid subarray is found return 0, if not return the result
        return (result == Integer.MAX_VALUE) ? 0 : result;
    }
}

//Time Complexity: O(n)
//Space Complexity: O(1)