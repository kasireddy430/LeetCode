class Solution {
    public int[] productExceptSelf(int[] nums) {
        //Calculate the length of input array
        int n = nums.length;
        //Initialize output array 
        int[] result = new int[n];

        result[0] = 1;
        //Calculate prefix products and store it with output array
        for(int i = 1; i < n; i++){
            result[i] = result[i - 1] * nums[i - 1];
        }

        int postFix = 1;
        //Calculate postFix products and multiply with the prefix products to retrieve output array
        for(int i = nums.length - 1; i >= 0; i--){
            result[i] = result[i] * postFix;
            postFix = postFix * nums[i];
        }

        return result;
    }
}

//Time Complexity: O(n)
//Space Complexity: O(n)