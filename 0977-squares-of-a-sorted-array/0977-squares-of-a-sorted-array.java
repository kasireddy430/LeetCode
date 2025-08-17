class Solution {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int l = 0, r = nums.length - 1;
        int[] ans = new int[n];

        for(int i = n -1; i >= 0; i--){
            int square = 0;

            if(Math.abs(nums[l]) < Math.abs(nums[r])){
                square = nums[r];
                r--;
            } else{
                square = nums[l];
                l++;
            }

            ans[i] = square * square;
        }

        return ans;
    }
}

//TC: O(n)
//SC: O(1)