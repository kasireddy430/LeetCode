class Solution {
    public int rob(int[] nums) {
        if(nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        
        int rob1 = 0, rob2 = 0;

        for(int num : nums){
            int tmp = Math.max(rob2, num + rob1);
            rob1 = rob2;
            rob2 = tmp;
        }

        return rob2;
    }
}

//TC: O(n)
//SC: O(1)