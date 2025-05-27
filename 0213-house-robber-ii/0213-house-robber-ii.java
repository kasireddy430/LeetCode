class Solution {
    public int rob(int[] nums) {
        if(nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];

        return Math.max(helper(nums, 0, nums.length - 2),
                        helper(nums, 1, nums.length - 1));
    }

    public int helper(int[] nums, int start, int end){
        int rob1 = 0, rob2 = 0;

        for(int i = start; i <= end; i++){
            int tmp = Math.max(nums[i] + rob1, rob2);
            rob1 = rob2;
            rob2 = tmp;
        }

        return rob2;
    }
}

//TC: O(n)
//SC: O(1)
