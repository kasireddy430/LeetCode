class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if(k <= 1) return 0;

        int l = 0;
        long product = 1;
        int count = 0;

        for(int r = 0; r < nums.length; r++){
            product *= nums[r];

            while(product >= k){
                product /= nums[l];
                l++;
            }

            count += (r - l + 1);
        }

        return count;
    }
}

//TC : O(n)
//SC: O(1)
