class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;

        for(int i = 0; i < n; i++){
            while(nums[i] > 0 && nums[i] < n && nums[i] != nums[nums[i] - 1]){
                swap(nums, i, nums[i] - 1);
            }
        }

        for(int j = 0; j < n; j++){
            if(nums[j] != j + 1){
                return j + 1;
            }
        }

        return n + 1;
    }

    private void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}   


//TC: O(n)
//SC: O(1)